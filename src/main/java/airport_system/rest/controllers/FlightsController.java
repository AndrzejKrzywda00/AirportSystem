package airport_system.rest.controllers;

import airport_system.rest.dto.FlightSummary;
import airport_system.rest.dto.Flight;
import airport_system.rest.services.FlightsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(tags = "Flight")
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightsController {

    private final FlightsService service;

    @GetMapping("/all")
    public List<Flight> get() {
        return service.getAll();
    }

    /*
    Implementation of task 1. of the application
     */
    @ApiOperation(value = "Get summary object of flight")
    @GetMapping("/number={flightNumber}/date={date}")
    public FlightSummary getFlightSummary(@PathVariable Integer flightNumber, @PathVariable String date) {
        return service.getSummaryByFlightNumberAndDate(flightNumber, date);
    }

    @ApiOperation(value = "Add flight entities")
    @PostMapping("")
    public void post(@Validated @RequestBody List<Flight> flights) {
        service.save(flights);
    }

}
