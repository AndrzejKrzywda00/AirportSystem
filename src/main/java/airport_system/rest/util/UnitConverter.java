package airport_system.rest.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UnitConverter {

    // 1 kg is {ratio} lbs
    private final static double ratio = 2.2046226218;

    public double convertLbsToKgs(double weightInLbs) {
        return weightInLbs / ratio;
    }

    public double convertKgsToLbs(double weightInKgs) {
        return weightInKgs * ratio;
    }

}
