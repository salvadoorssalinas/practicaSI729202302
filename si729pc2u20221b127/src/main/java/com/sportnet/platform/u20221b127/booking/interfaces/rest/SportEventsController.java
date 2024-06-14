package com.sportnet.platform.u20221b127.booking.interfaces.rest;

import com.sportnet.platform.u20221b127.booking.domain.model.queries.GetSportEventById;
import com.sportnet.platform.u20221b127.booking.domain.services.SportEventCommandService;
import com.sportnet.platform.u20221b127.booking.domain.services.SportEventQueryService;
import com.sportnet.platform.u20221b127.booking.interfaces.rest.resources.CreateSportEventResource;
import com.sportnet.platform.u20221b127.booking.interfaces.rest.resources.SportEventResource;
import com.sportnet.platform.u20221b127.booking.interfaces.rest.transform.CreateSportEventCommandFromResourceAssembler;
import com.sportnet.platform.u20221b127.booking.interfaces.rest.transform.SportEventResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing sport events.
 * <p>
 *     This controller is responsible for handling requests related to sport events.
 *     It provides endpoints for creating sport events.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/sport-events", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Sport Events Controller", description = "Controller for sport events management.")
public class SportEventsController {
    private final SportEventCommandService sportEventCommandService;
    private final SportEventQueryService sportEventQueryService;

    public SportEventsController(SportEventCommandService sportEventCommandService, SportEventQueryService sportEventQueryService) {
        this.sportEventCommandService = sportEventCommandService;
        this.sportEventQueryService = sportEventQueryService;
    }

    /**
     * Create a new sport event.
     * @param resource the resource with the information of the sport event.
     * @return the created sport event.
     */
    @Operation(summary = "Create a new sport event", description = "Create a new sport event with the given information.")
    @PostMapping
    public ResponseEntity<SportEventResource> createBusiness(@RequestBody CreateSportEventResource resource) {
        var createSportEventCommand = CreateSportEventCommandFromResourceAssembler.toCommandFromResource(resource);
        var sportEvent = sportEventCommandService.handle(createSportEventCommand);
        if (sportEvent.isEmpty()) {
            return ResponseEntity.badRequest().build(); // 400
        }
        var sportEventResource = SportEventResourceFromEntityAssembler.toResourceFromEntity(sportEvent.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(sportEventResource); // 201
    }

    /**
     * Get a sport event by its id.
     * @param id the id of the sport event.
     * @return the sport event.
     */
    @Operation(summary = "Get a sport event by its id", description = "Get a sport event by its id.")
    @GetMapping("/{id}")
    public ResponseEntity<SportEventResource> getSportEventById(@PathVariable Long id) {
        var getSportEventByIdQuery = new GetSportEventById(id);
        var sportEvent = sportEventQueryService.handle(getSportEventByIdQuery);
        if (sportEvent.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        }
        var sportEventResource = SportEventResourceFromEntityAssembler.toResourceFromEntity(sportEvent.get());
        return ResponseEntity.ok(sportEventResource); // 200
    }

}
