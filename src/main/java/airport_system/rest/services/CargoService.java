package airport_system.rest.services;

import airport_system.rest.util.UnitConverter;
import airport_system.rest.dto.Baggage;
import airport_system.rest.dto.Cargo;
import airport_system.rest.entities.CargoEntity;
import airport_system.rest.repositories.CargoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public record CargoService(ModelMapper modelMapper, CargoRepository repository) {

    // ------ POST ------

    public void save(List<Cargo> cargo) {
        var cargoEntities = cargo.stream().map(this::mapToCargoEntity).toList();
        repository.saveAll(cargoEntities);
    }

    private CargoEntity mapToCargoEntity(Cargo cargo) {

        int flightId = cargo.getFlightId();

        var baggageWeight = calculateSumOfWeightInKgs(cargo.getBaggage());
        var cargoWeight = calculateSumOfWeightInKgs(cargo.getCargo());

        Integer cargoPieces = countPiecesOf(cargo.getCargo());
        Integer baggagePieces = countPiecesOf(cargo.getBaggage());

        var cargoEntity =  new CargoEntity();

        cargoEntity.setFlightId(flightId);
        cargoEntity.setBaggageWeight(baggageWeight);
        cargoEntity.setCargoWeight(cargoWeight);
        cargoEntity.setPieces(baggagePieces + cargoPieces);

        return cargoEntity;
    }

    private double calculateSumOfWeightInKgs(List<Baggage> baggage) {
        return baggage
                .stream()
                .map(this::mapBaggageToWeightInKgs)
                .toList()
                .stream()
                .reduce((double)0, Double::sum);
    }

    private Integer countPiecesOf(List<Baggage> baggage) {
        return baggage
                .stream()
                .map(Baggage::getPieces)
                .toList()
                .stream()
                .reduce(0, Integer::sum);
    }

    private double mapBaggageToWeightInKgs(Baggage baggage) {
        if(Objects.equals(baggage.getWeightUnit(), "kg")) return baggage.getWeight();
        else return new UnitConverter().convertLbsToKgs(baggage.getWeight());
    }


    // ------ GET ------

    public List<CargoEntity> getAll() {
        return repository.findAll();
    }

}
