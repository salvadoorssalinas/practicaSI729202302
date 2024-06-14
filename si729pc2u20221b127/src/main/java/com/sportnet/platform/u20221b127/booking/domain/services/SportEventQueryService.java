package com.sportnet.platform.u20221b127.booking.domain.services;

import com.sportnet.platform.u20221b127.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u20221b127.booking.domain.model.queries.GetSportEventById;

import java.util.Optional;

public interface SportEventQueryService {
    Optional<SportEvent> handle(GetSportEventById query);
}
