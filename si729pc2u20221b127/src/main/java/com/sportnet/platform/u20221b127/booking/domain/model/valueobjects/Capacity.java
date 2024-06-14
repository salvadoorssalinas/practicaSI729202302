package com.sportnet.platform.u20221b127.booking.domain.model.valueobjects;

public record Capacity(Long capacity) {
    public Capacity {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
    }

    public Long getCapacity() {
        return capacity;
    }
}
