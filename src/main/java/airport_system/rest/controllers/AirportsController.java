package airport_system.rest.controllers;

import airport_system.rest.dto.AirportSummary;
import airport_system.rest.services.AirportsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Airport data")
@RequestMapping("/airports")
@RequiredArgsConstructor
public class AirportsController {

    private final AirportsService service;

    /*
    Implementation of task 2. of the application
     */
    @ApiOperation(value = "Get summary object of airport by IATA code and date")
    @GetMapping("/IATA={iata}/date={date}")
    public AirportSummary get(@PathVariable String iata, @PathVariable String date) {
        return service.getSummaryOfSelectedAirport(iata, date);
    }

}
