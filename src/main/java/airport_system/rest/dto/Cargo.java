package airport_system.rest.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Cargo {

    @NotNull
    private Integer flightId;

    @NotNull
    private List<Baggage> baggage;

    @NotNull
    private List<Baggage> cargo;
}
