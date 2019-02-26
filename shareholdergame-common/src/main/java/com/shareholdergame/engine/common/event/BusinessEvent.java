package com.shareholdergame.engine.common.event;

public class BusinessEvent<T> {

    private BusinessEventType eventType;

    private T payload;

    private BusinessEvent() {
    }

    private BusinessEvent(BusinessEventType eventType, T payload) {
        this.eventType = eventType;
        this.payload = payload;
    }

    public static <T> BusinessEvent<T> of(BusinessEventType eventType, T payload) {
        return new BusinessEvent<>(eventType, payload);
    }

    public T getPayload() {
        return payload;
    }

    public BusinessEventType getEventType() {
        return eventType;
    }
}
