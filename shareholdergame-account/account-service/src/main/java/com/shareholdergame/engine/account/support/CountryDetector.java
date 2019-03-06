package com.shareholdergame.engine.account.support;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shareholdergame.engine.account.config.AccountServiceConfiguration;
import com.shareholdergame.engine.account.model.UserLocation;
import com.shareholdergame.engine.common.exception.ApplicationException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;

@Singleton
public class CountryDetector {

    private static final String IPSTACK_URL = "http://api.ipstack.com/{0}?access_key={1}";
    private static final String COUNTRY_NAME = "country_name";
    private static final String REGION_NAME = "region_name";
    private static final String CITY = "city";

    @Inject
    private AccountServiceConfiguration configuration;

    private ObjectMapper mapper = new ObjectMapper();

    public UserLocation detect(String ipAddress) {
        String response = sendGeoIpRequest(ipAddress);
        if (StringUtils.isBlank(response)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // todo - bad practice! Write message to log.
                e.printStackTrace();
            }
            response = sendGeoIpRequest(ipAddress);
        }
        try {
            JsonNode jsonNode = mapper.readTree(response);
            return UserLocation.of(jsonNode.get(COUNTRY_NAME).asText(),
                    jsonNode.get(REGION_NAME).asText(),
                    jsonNode.get(CITY).asText());
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }

    private String sendGeoIpRequest(String userIPAddress) {
        String urlString = MessageFormat.format(IPSTACK_URL, userIPAddress, configuration.getIpStackApiKey());
        InputStream stream = null;
        try {
            URL url = new URL(urlString);
            stream = url.openStream();
            return IOUtils.toString(stream);
        } catch (Exception e) {
            throw new ApplicationException("Location by IP request failed", e);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }
}
