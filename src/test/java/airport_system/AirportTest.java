package airport_system;

import airport_system.rest.services.AirportsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AirportTest {

    @Autowired
    private AirportsService service;

    @Test
    public void testSummaryGeneration() {

    }

}
