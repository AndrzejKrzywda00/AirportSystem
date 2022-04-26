package airport_system;

import airport_system.rest.dto.Baggage;
import airport_system.rest.dto.Cargo;
import airport_system.rest.services.CargoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CargoTest {

    @Autowired
    private CargoService service;

    @Test
    public void testIncorrectPosting() {

        var wrongId = List.of(new Baggage(-1, 23, "kg", 231));
        var wrongWeight = List.of(new Baggage(1, -34, "lb", 342));
        var wrongWeightUnit = List.of(new Baggage(1, -34, "grams", 342));
        var wrongPiecesNum = List.of(new Baggage(1, -34, "lb", -80));

        var correctBaggage = List.of(new Baggage(1, 34, "kg", 211));

        Cargo noId = new Cargo(null, new ArrayList<>(), new ArrayList<>());
        Cargo wrongCargoId = new Cargo(-4, new ArrayList<>(), new ArrayList<>());
        Cargo wrongBaggageId = new Cargo(3, wrongId, correctBaggage);
        Cargo wrongBaggageWeight = new Cargo(3, wrongWeight, correctBaggage);
        Cargo wrongBaggageWeightUnit = new Cargo(3, wrongWeightUnit, correctBaggage);
        Cargo wrongBaggagePiecesNum = new Cargo(3, wrongPiecesNum, correctBaggage);

        assertThrows(RuntimeException.class, () -> service.save(List.of(noId)));
        assertThrows(RuntimeException.class, () -> service.save(List.of(wrongCargoId)));
        assertThrows(RuntimeException.class, () -> service.save(List.of(wrongBaggageId)));
        assertThrows(RuntimeException.class, () -> service.save(List.of(wrongBaggageWeight)));
        assertThrows(RuntimeException.class, () -> service.save(List.of(wrongBaggageWeightUnit)));
        assertThrows(RuntimeException.class, () -> service.save(List.of(wrongBaggagePiecesNum)));
    }

}
