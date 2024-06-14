package com.sportnet.platform.u20221b127.booking.domain.model.valueobjects;

public record SportType(String type) {
    public SportType {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Sport sportType cannot be null or empty");
        }
    }

    public String getSportType() {
        return type;
    }
}
