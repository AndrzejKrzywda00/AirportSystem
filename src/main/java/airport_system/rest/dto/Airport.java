package airport_system.rest.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Airport {
    private Integer id;
    private Integer IATACode;
    private List<Flight> flightsArriving;
    private List<Flight> flightsDeparting;
}
