package com.sportnet.platform.u20221b127.booking.infrastructure.persistence.jpa.repositories;

import com.sportnet.platform.u20221b127.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.EventName;
import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.Location;
import com.sportnet.platform.u20221b127.booking.domain.model.valueobjects.SportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SportEventRepository extends JpaRepository<SportEvent, Long> {
    Optional<SportEvent> findByEventNameAndSportTypeAndLocation(EventName eventName, SportType sportType, Location location);
    Optional<SportEvent> findByOrganizerId(Long organizerId);

}
