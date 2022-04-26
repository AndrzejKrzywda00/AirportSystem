package airport_system.rest.services;

import airport_system.rest.dto.AirportSummary;
import airport_system.rest.repositories.CargoRepository;
import airport_system.rest.repositories.FlightsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public record AirportsService(ModelMapper modelMapper,
                              FlightsRepository flightsRepository,
                              CargoRepository cargoRepository)
{

    // ------ GET ------

    public AirportSummary getSummaryOfSelectedAirport(String iata, String date) {

        // first get the flights
        var departingFlights = flightsRepository.findAllDeparturesByDateAndIATACode(iata, date);
        var arrivingFlights = flightsRepository.findAllArrivalsByIATACode(iata);

        // second, the cargo data
        var departingCargo = departingFlights.stream().map(flightEntity -> cargoRepository.getPiecesByFlightId(flightEntity.getFlightId())).toList();
        var arrivingCargo = arrivingFlights.stream().map(flightEntity -> cargoRepository.getPiecesByFlightId(flightEntity.getFlightId())).toList();

        return generateAirportSummary(
                departingFlights.size(),
                arrivingFlights.size(),
                arrivingCargo.stream().reduce(0, Integer::sum),
                departingCargo.stream().reduce(0, Integer::sum));
    }

    private AirportSummary generateAirportSummary(
            Integer numberOfDepartures,
            Integer numberOfArrivals,
            Integer numberOfBaggageArriving,
            Integer numberOfBaggageDeparting)
    {
        return AirportSummary
                .builder()
                .numberOfDepartingFlights(numberOfDepartures)
                .numberOfArrivingFlights(numberOfArrivals)
                .numberOfBaggageArriving(numberOfBaggageArriving)
                .numberOfBaggageDeparting(numberOfBaggageDeparting)
                .build();
    }

}
