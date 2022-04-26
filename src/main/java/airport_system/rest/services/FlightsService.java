package airport_system.rest.services;

import airport_system.rest.dto.FlightSummary;
import airport_system.rest.dto.Weight;
import airport_system.rest.dto.Flight;
import airport_system.rest.entities.FlightEntity;
import airport_system.rest.repositories.CargoRepository;
import airport_system.rest.repositories.FlightsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public record FlightsService(ModelMapper modelMapper,
                             FlightsRepository flightsRepository,
                             CargoRepository cargoRepository)
{

    // ------ GET ------

    public List<Flight> getAll() {
        return flightsRepository
                .findAll()
                .stream()
                .map(flightEntity -> modelMapper.map(flightEntity, Flight.class))
                .collect(Collectors.toList());
    }

    public FlightSummary getSummaryByFlightNumberAndDate(Integer flightNumber, String date) {
        var flight = flightsRepository.findByFlightNumberAndDate(flightNumber, date);
        return generateFlightSummary(flight.getFlightId());
    }

    private FlightSummary generateFlightSummary(Integer flightId) {
        return FlightSummary
                .builder()
                .baggageWeight(new Weight(cargoRepository.getBaggageWeightByFlightId(flightId)))
                .cargoWeight(new Weight(cargoRepository.getCargoWeightByFlightId(flightId)))
                .totalWeight(new Weight(cargoRepository.getTotalWeightByFlightId(flightId)))
                .build();
    }


    // ------ POST -------

    public void save(List<Flight> flights) {
         flightsRepository.saveAll(flights.stream().map(flight -> modelMapper.map(flight, FlightEntity.class)).collect(Collectors.toList()));
    }

}
