package com.shareholdergame.engine.common.event;

public class BusinessEvent<E extends Enum, T> {

    private E eventType;

    private T payload;

    protected BusinessEvent(E eventType, T payload) {
        this.eventType = eventType;
        this.payload = payload;
    }

    public T getPayload() {
        return payload;
    }

    public E getEventType() {
        return eventType;
    }
}
