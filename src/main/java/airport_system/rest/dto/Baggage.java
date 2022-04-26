package airport_system.rest.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RequiredArgsConstructor
@Data
public class Baggage {

    @NotNull
    @Min(0)
    private Integer id;

    @Max(999)
    @Min(1)
    private Integer weight;

    @Pattern(regexp = "(kg|lb)")
    private String weightUnit;

    @Max(999)
    @Min(1)
    private Integer pieces;
}
