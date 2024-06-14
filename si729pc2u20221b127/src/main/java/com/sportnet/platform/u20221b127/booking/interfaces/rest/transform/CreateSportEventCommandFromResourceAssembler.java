package com.sportnet.platform.u20221b127.booking.interfaces.rest.transform;

import com.sportnet.platform.u20221b127.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u20221b127.booking.interfaces.rest.resources.CreateSportEventResource;

public class CreateSportEventCommandFromResourceAssembler {
    public static CreateSportEventCommand toCommandFromResource(CreateSportEventResource resource) {
        return new CreateSportEventCommand(
                resource.organizerId(),
                resource.name(),
                resource.type(),
                resource.location(),
                resource.capacity()
        );
    }
}
