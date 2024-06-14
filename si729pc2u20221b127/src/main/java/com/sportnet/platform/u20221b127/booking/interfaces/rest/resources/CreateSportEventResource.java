package com.sportnet.platform.u20221b127.booking.interfaces.rest.resources;

public record CreateSportEventResource(
        Long organizerId,
        String name,
        String type,
        String location,
        Long capacity
) {
}
