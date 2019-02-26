package com.shareholdergame.engine.facade.handler;

import com.google.common.collect.ImmutableMap;
import com.shareholdergame.engine.common.exception.ApplicationException;
import com.shareholdergame.engine.common.exception.BusinessException;
import com.shareholdergame.engine.common.http.ErrorBody;
import com.shareholdergame.engine.common.http.ResponseWrapper;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.security.authentication.AuthenticationException;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.function.Function;

/**
 * Facade exception handler.
 */
@Singleton
public class FacadeExceptionHandler implements ExceptionHandler<Exception, HttpResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeExceptionHandler.class);

    private static Map<Class<? extends Exception>, Pair<Function<Exception, String>, HttpStatus>> callbackMap = ImmutableMap
            .<Class<? extends Exception>, Pair<Function<Exception, String>, HttpStatus>>builder()
            .put(ApplicationException.class, Pair.of(e -> "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR))
            .put(BusinessException.class, Pair.of(Throwable::getMessage, HttpStatus.INTERNAL_SERVER_ERROR))
            .put(AuthenticationException.class, Pair.of(Throwable::getMessage, HttpStatus.INTERNAL_SERVER_ERROR))
            .put(ConstraintViolationException.class, Pair.of(e -> String.format("Validation failed: %s", e.getMessage()), HttpStatus.BAD_REQUEST))
            .put(Exception.class, Pair.of(e -> String.format("Unhadled exception %s. %s", e.getClass().getName(), e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR))
            .build();

    @Override
    public HttpResponse handle(HttpRequest httpRequest, Exception e) {
        LOGGER.error(e.getMessage(), e);

        Pair<Function<Exception, String>, HttpStatus> callbackAndStatus = callbackMap.getOrDefault(e.getClass(), callbackMap.get(Exception.class));

        ErrorBody errorBody = new ErrorBody(callbackAndStatus.getLeft().apply(e));
        ResponseWrapper<ErrorBody> responseWrapper = ResponseWrapper.error(errorBody);
        return HttpResponse.<ResponseWrapper<ErrorBody>>status(callbackAndStatus.getRight()).body(responseWrapper);
    }
}
