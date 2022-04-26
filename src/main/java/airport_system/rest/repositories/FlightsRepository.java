package airport_system.rest.repositories;

import airport_system.rest.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FlightsRepository extends JpaRepository<FlightEntity, Integer> {

    @Query("SELECT f FROM FlightEntity f WHERE f.departureAirportIATACode = ?1 AND f.departureDate = ?2")
    List<FlightEntity> findAllDeparturesByDateAndIATACode(String iata, String date);

    @Query("SELECT f FROM FlightEntity f WHERE f.arrivalAirportIATACode = ?1")
    List<FlightEntity> findAllArrivalsByIATACode(String iata);

    @Query("SELECT f FROM FlightEntity f WHERE f.flightNumber = ?1 AND f.departureDate = ?2")
    FlightEntity findByFlightNumberAndDate(Integer flightNumber, String date);

    @Query("SELECT f FROM FlightEntity f WHERE f.flightNumber = ?1")
    FlightEntity findByFlightNumber(Integer flightNumber);
}
