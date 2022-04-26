package airport_system.rest.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CargoEntity {
    @Id
    private Integer flightId;
    private Double baggageWeight;
    private Double cargoWeight;
    private Integer pieces;
}
