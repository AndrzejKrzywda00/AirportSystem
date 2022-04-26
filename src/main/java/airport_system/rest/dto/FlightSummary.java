package airport_system.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightSummary {
    private Weight cargoWeight;
    private Weight baggageWeight;
    private Weight totalWeight;
}
