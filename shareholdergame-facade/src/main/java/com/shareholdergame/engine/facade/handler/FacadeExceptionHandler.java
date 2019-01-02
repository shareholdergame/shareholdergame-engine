package com.shareholdergame.engine.facade.handler;

import com.google.common.collect.ImmutableMap;
import com.shareholdergame.engine.common.exception.ApplicationException;
import com.shareholdergame.engine.common.exception.BusinessException;
import com.shareholdergame.engine.common.support.ErrorBody;
import com.shareholdergame.engine.common.support.ResponseWrapper;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.security.authentication.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Map;
import java.util.function.Function;

/**
 * Facade exception handler.
 */
@Singleton
public class FacadeExceptionHandler implements ExceptionHandler<Exception, HttpResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeExceptionHandler.class);

    private static Map<Class<? extends Exception>, Function<Exception, String>> callbackMap = ImmutableMap
            .<Class<? extends Exception>, Function<Exception, String>>builder()
            .put(ApplicationException.class, e -> "Internal server error")
            .put(BusinessException.class, Throwable::getMessage)
            .put(AuthenticationException.class, Throwable::getMessage)
            .put(Exception.class, e -> String.format("Unhadled exception %s. %s", e.getClass().getName(), e.getMessage()))
            .build();

    @Override
    public HttpResponse handle(HttpRequest httpRequest, Exception e) {
        LOGGER.error(e.getMessage(), e);

        ErrorBody errorBody = new ErrorBody(callbackMap.getOrDefault(e.getClass(), e1 -> callbackMap.get(Exception.class).apply(e1)).apply(e));
        ResponseWrapper<ErrorBody> responseWrapper = ResponseWrapper.error(errorBody);
        return HttpResponse.<ResponseWrapper<ErrorBody>>serverError().body(responseWrapper);
    }
}
