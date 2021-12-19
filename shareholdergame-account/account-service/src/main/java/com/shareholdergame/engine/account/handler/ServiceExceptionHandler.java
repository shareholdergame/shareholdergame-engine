package com.shareholdergame.engine.account.handler;

import com.google.common.collect.ImmutableMap;
import com.shareholdergame.engine.common.exception.ApplicationException;
import com.shareholdergame.engine.common.exception.BusinessException;
import com.shareholdergame.engine.common.exception.Errors;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.hateoas.JsonError;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Singleton;
import java.util.Map;
import java.util.function.Function;

@Singleton
public class ServiceExceptionHandler implements ExceptionHandler<Exception, HttpResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceExceptionHandler.class);

    private static Map<Class<? extends Exception>, Pair<Function<Exception, String>, HttpStatus>> callbackMap = ImmutableMap
            .<Class<? extends Exception>, Pair<Function<Exception, String>, HttpStatus>>builder()
            .put(ApplicationException.class, Pair.of(e -> Errors.APPLICATION_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR))
            .put(BusinessException.class, Pair.of(Throwable::getMessage, HttpStatus.INTERNAL_SERVER_ERROR))
            .put(Exception.class, Pair.of(e -> String.format("Unhadled exception %s. %s", e.getClass().getName(), e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR))
            .build();

    @Override
    public HttpResponse handle(HttpRequest request, Exception exception) {
        LOGGER.error(exception.getMessage(), exception);

        Pair<Function<Exception, String>, HttpStatus> callbackAndStatus = callbackMap.getOrDefault(exception.getClass(), callbackMap.get(Exception.class));

        return HttpResponse.status(callbackAndStatus.getRight()).body(new JsonError(callbackAndStatus.getLeft().apply(exception)));
    }
}
