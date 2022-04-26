package airport_system.rest.dto;

import airport_system.rest.util.UnitConverter;
import lombok.Data;

@Data
public class Weight {

    private double weightInKgs;
    private double weightInLbs;

    public Weight(double weightInKgs) {
        this.weightInKgs = weightInKgs;
        this.weightInLbs = new UnitConverter().convertKgsToLbs(weightInKgs);
    }

}
