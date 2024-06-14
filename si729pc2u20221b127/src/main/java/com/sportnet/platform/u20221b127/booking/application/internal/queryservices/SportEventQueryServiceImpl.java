package com.sportnet.platform.u20221b127.booking.application.internal.queryservices;

import com.sportnet.platform.u20221b127.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u20221b127.booking.domain.model.queries.GetSportEventById;
import com.sportnet.platform.u20221b127.booking.domain.services.SportEventQueryService;
import com.sportnet.platform.u20221b127.booking.infrastructure.persistence.jpa.repositories.SportEventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the sport event query service.
 * <p>
 *     This class is responsible for handling the queries related to sport events.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */
@Service
public class SportEventQueryServiceImpl implements SportEventQueryService {
    private final SportEventRepository sportEventRepository;

    public SportEventQueryServiceImpl(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    @Override
    public Optional<SportEvent> handle(GetSportEventById query) {
        return sportEventRepository.findById(query.id());
    }
}
