package com.sportnet.platform.u20221b127.booking.interfaces.rest.resources;

public record SportEventResource(
        Long id,
        Long organizerId,
        String eventName,
        String sportType,
        String location,
        Long capacity
) {
}
