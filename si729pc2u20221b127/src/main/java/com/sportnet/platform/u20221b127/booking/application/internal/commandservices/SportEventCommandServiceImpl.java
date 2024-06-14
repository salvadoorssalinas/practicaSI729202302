package com.sportnet.platform.u20221b127.booking.application.internal.commandservices;

import com.sportnet.platform.u20221b127.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u20221b127.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.Capacity;
import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.EventName;
import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.Location;
import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.SportType;
import com.sportnet.platform.u20221b127.booking.domain.services.SportEventCommandService;
import com.sportnet.platform.u20221b127.booking.infrastructure.persistence.jpa.repositories.SportEventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the sport event command service.
 * <p>
 *     This class is responsible for handling the commands related to sport events.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */
@Service
public class SportEventCommandServiceImpl implements SportEventCommandService {
    private final SportEventRepository sportEventRepository;

    public SportEventCommandServiceImpl(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    @Override
    public Optional<SportEvent> handle(CreateSportEventCommand command) {
        // Check if there's another sport event with the same event eventName, sport sportType and location
        var eventName = new EventName(command.eventName());
        var sportType = new SportType(command.sportType());
        var location = new Location(command.location());

        var existingSportEvent = sportEventRepository.findByEventNameAndSportTypeAndLocation(eventName, sportType, location);
        if (existingSportEvent.isPresent()) {
            throw new IllegalArgumentException("Sport event with the same event name, sport sportType and location already exists");
        }

        // Check if there's another sport event with the same organizer ID
        var existingSportEventByOrganizerId = sportEventRepository.findByOrganizerId(command.organizerId());
        if (existingSportEventByOrganizerId.isPresent()) {
            throw new IllegalArgumentException("Sport event with the same organizer ID on the same day already exists");
        }

        var capacity = new Capacity(command.capacity());
        var sportEvent = new SportEvent(command.organizerId(), eventName, sportType, location, capacity);
        sportEventRepository.save(sportEvent);
        return Optional.of(sportEvent);
    }

}
