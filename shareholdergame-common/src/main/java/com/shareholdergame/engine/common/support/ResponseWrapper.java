package com.shareholdergame.engine.common.support;

public class ResponseWrapper<T> {

    private ResponseStatus status;

    private T body;

    private ResponseWrapper(ResponseStatus status, T body) {
        this.status = status;
        this.body = body;
    }

    public static ResponseWrapper<?> ok() {
        return new ResponseWrapper<>(ResponseStatus.OK, null);
    }

    public static <T1> ResponseWrapper<T1> ok(T1 body) {
        return new ResponseWrapper<>(ResponseStatus.OK, body);
    }

    public static ResponseWrapper<ErrorBody> error(ErrorBody errorBody) {
        return new ResponseWrapper<>(ResponseStatus.ERROR, errorBody);
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public T getBody() {
        return body;
    }
}
