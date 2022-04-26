package airport_system.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirportSummary {
    private Integer numberOfDepartingFlights;
    private Integer numberOfArrivingFlights;
    private Integer numberOfBaggageArriving;
    private Integer numberOfBaggageDeparting;
}
