package com.sportnet.platform.u20221b127.booking.domain.services;

import com.sportnet.platform.u20221b127.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u20221b127.booking.domain.model.commands.CreateSportEventCommand;

import java.util.Optional;

public interface SportEventCommandService {
    Optional<SportEvent> handle(CreateSportEventCommand command);
}
