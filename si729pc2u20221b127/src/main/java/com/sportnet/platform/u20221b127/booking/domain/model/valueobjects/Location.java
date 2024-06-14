package com.sportnet.platform.u20221b127.booking.domain.model.valueobjects;

public record Location(String location) {
    public Location {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location cannot be null or empty");
        }
    }

    public String getLocation() {
        return location;
    }
}
