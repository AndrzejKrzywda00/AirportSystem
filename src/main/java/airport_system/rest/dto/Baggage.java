package airport_system.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Baggage {
    private Integer id;
    private Integer weight;
    private String weightUnit;
    private Integer pieces;
}
