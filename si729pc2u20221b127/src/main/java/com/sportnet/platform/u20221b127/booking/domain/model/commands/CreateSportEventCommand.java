package com.sportnet.platform.u20221b127.booking.domain.model.commands;

/**
 * Command to create a sport event.
 * @param organizerId the id of the organizer.
 * @param eventName the eventName of the event.
 * @param sportType the sportType of sport.
 * @param location the location of the event.
 * @param capacity the capacity of the event.
 */
public record CreateSportEventCommand(Long organizerId, String eventName, String sportType, String location, Long capacity) {
}
