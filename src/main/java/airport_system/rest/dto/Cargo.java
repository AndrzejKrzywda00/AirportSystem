package airport_system.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Cargo {
    private Integer flightId;
    private List<Baggage> baggage;
    private List<Baggage> cargo;
}
