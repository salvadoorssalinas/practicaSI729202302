package com.sportnet.platform.u20221b127.booking.domain.model.valueobjects;

public record EventName(String name) {
    public EventName {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Event eventName cannot be null or empty");
        }
    }

    public String getEventName() {
        return name;
    }
}
