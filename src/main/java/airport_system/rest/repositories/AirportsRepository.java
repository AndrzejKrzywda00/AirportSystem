package airport_system.rest.repositories;

import airport_system.rest.entities.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportsRepository extends JpaRepository<AirportEntity, Integer> {}
