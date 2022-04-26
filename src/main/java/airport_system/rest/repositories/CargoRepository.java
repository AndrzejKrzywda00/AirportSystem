package airport_system.rest.repositories;

import airport_system.rest.entities.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<CargoEntity, Integer> {

    @Query("SELECT c.baggageWeight FROM CargoEntity c WHERE c.flightId = ?1")
    double getBaggageWeightByFlightId(Integer flightId);

    @Query("SELECT c.cargoWeight FROM CargoEntity c WHERE c.flightId = ?1")
    double getCargoWeightByFlightId(Integer flightId);

    @Query("SELECT c.baggageWeight + c.cargoWeight FROM CargoEntity c WHERE c.flightId = ?1")
    double getTotalWeightByFlightId(Integer flightId);

    @Query("SELECT c.pieces FROM CargoEntity c WHERE c.flightId = ?1")
    Integer getPiecesByFlightId(Integer flightId);
}
