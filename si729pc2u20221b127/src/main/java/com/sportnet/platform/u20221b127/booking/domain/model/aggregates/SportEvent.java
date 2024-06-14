package com.sportnet.platform.u20221b127.booking.domain.model.aggregates;

import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.Capacity;
import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.EventName;
import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.Location;
import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.SportType;
import com.sportnet.platform.u20221b127.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a sport event.
 * <p>
 *     A sport event is an event that is organized by an organizer and has a eventName, a sport sportType, a location, and a capacity.
 *     It is an aggregate root that is responsible for managing the information of a sport event.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */

@Entity
public class SportEvent extends AuditableAbstractAggregateRoot<SportEvent> {

    @NotNull(message = "Organizer ID is required")
    private Long organizerId;

    @Embedded
    @NotNull(message = "Event Name is required")
    private EventName eventName;

    @Embedded
    @NotNull(message = "Sport Type is required")
    private SportType sportType;

    @Embedded
    @NotNull(message = "Location is required")
    private Location location;

    @Embedded
    @NotNull(message = "Capacity is required")
    private Capacity capacity;

    public SportEvent() {
    }

    /**
     * Creates a new sport event.
     * @param organizerId the ID of the organizer.
     * @param eventName the eventName of the event.
     * @param sportType the sportType of sport.
     * @param location the location of the event.
     * @param capacity the capacity of the event.
     */
    public SportEvent(Long organizerId, EventName eventName, SportType sportType, Location location, Capacity capacity) {
        this.organizerId = organizerId;
        this.eventName = eventName;
        this.sportType = sportType;
        this.location = location;
        this.capacity = capacity;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public String getEventName() {
        return eventName.getEventName();
    }

    public String getSportType() {
        return sportType.getSportType();
    }

    public String getLocation() {
        return location.getLocation();
    }

    public Long getCapacity() {
        return capacity.getCapacity();
    }

}
