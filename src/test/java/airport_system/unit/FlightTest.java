package airport_system.unit;

import airport_system.rest.dto.Flight;
import airport_system.rest.services.FlightsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class FlightTest {

    @Autowired
    private FlightsService service;

    // testing if incorrect data will be saved in DB
    @Test
    public void testIncorrectPosting() {

        Flight noId = new Flight(null, 2302, "WWX", "RRW", "2020");
        Flight wrongId = new Flight(-1, 2302, "WWX", "RRW", "2020");
        Flight wrongFlightNumber = new Flight(1, 12331, "WWX", "WWR", "2020");
        Flight wrongIATACode = new Flight(1, 3421, "W", "WWX", "2020");

        assertThrows(RuntimeException.class, () -> service.save(List.of(noId)));
        assertThrows(RuntimeException.class, () -> service.save(List.of(wrongId)));
        assertThrows(RuntimeException.class, () -> service.save(List.of(wrongFlightNumber)));
        assertThrows(RuntimeException.class, () -> service.save(List.of(wrongIATACode)));
    }

    // test if summary was calculated correctly
    @Test
    public void testSummaryGeneration() {

    }

}
