package com.shareholdergame.engine.account.support;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.shareholdergame.engine.account.config.AccountServiceConfiguration;
import com.shareholdergame.engine.account.model.UserLocation;
import com.shareholdergame.engine.common.exception.ApplicationException;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.io.IOException;

@Singleton
public class CountryDetector {

    //private static final Logger LOGGER = LoggerFactory.getLogger(CountryDetector.class);

    private static final String IPSTACK_URL = "http://api.ipstack.com/";
    private static final String IP_STACK_QUERY = "{ipAddress}?access_key={accessKey}";
    private static final String IP_ADDRESS_PARAM = "ipAddress";
    private static final String ACCESS_KEY_PARAM = "accessKey";
    private static final String COUNTRY_NAME = "country_name";
    private static final String REGION_NAME = "region_name";
    private static final String CITY = "city";
    private static final String ERROR_NODE = "error";
    private static final String INFO_NODE = "info";

    @Inject
    private AccountServiceConfiguration configuration;

    @Client(IPSTACK_URL)
    @Inject
    private HttpClient httpClient;

    private ObjectMapper mapper = new ObjectMapper();

    public UserLocation detect(String ipAddress) {
        String response = sendGeoIpRequest(ipAddress);
        try {
            JsonNode jsonNode = mapper.readTree(response);
            if (jsonNode.has(COUNTRY_NAME)) {
                return UserLocation.of(jsonNode.get(COUNTRY_NAME).asText(),
                        jsonNode.get(REGION_NAME).asText(),
                        jsonNode.get(CITY).asText());
            } else if (jsonNode.has(ERROR_NODE) && jsonNode.get(ERROR_NODE).has(INFO_NODE)) {
                throw new ApplicationException(jsonNode.get(ERROR_NODE).get(INFO_NODE).asText());
            } else {
                throw new ApplicationException("Unexpected response format: " + response);
            }
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }

    private String sendGeoIpRequest(String userIPAddress) {
        String uri = UriBuilder.of(IP_STACK_QUERY).expand(ImmutableMap.of(IP_ADDRESS_PARAM, userIPAddress,
                ACCESS_KEY_PARAM, configuration.getIpStackApiKey())).toString();
        return httpClient.toBlocking().retrieve(uri);
    }
}
