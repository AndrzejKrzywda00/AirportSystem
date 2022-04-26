package airport_system.rest.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Flight {

    @NotNull
    @Min(0)
    private Integer flightId;

    @Max(9999)
    @Min(1000)
    private Integer flightNumber;

    @Pattern(regexp = "[A-Z]{3}")
    private String departureAirportIATACode;

    @Pattern(regexp = "[A-Z]{3}")
    private String arrivalAirportIATACode;

    @NotBlank
    private String departureDate;
}
