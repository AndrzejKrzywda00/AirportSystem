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
import java.util.stream.Collectors;

@Service
public record CargoService(ModelMapper modelMapper, CargoRepository repository) {

    // ------ POST ------

    public void save(List<Cargo> cargo) {
        if(validate(cargo))
        {
            var cargoEntities = cargo.stream().map(this::mapToCargoEntity).toList();
            repository.saveAll(cargoEntities);
        }
        else throw new RuntimeException("Provided data does not pass validation requirements");
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

    private boolean validate(List<Cargo> cargo) {
        return cargo.stream().map(this::validateCargo).reduce(Boolean::logicalAnd).get();
    }

    private boolean validateCargo(Cargo cargo) {
        return
        cargo.getFlightId() >= 0 &&
        validateBaggageList(cargo.getBaggage()) &&
        validateBaggageList(cargo.getCargo());
    }

    private boolean validateBaggageList(List<Baggage> baggage) {
        return baggage.stream().map(this::validateBaggage).reduce(Boolean::logicalAnd).get();
    }

    private boolean validateBaggage(Baggage baggage) {
        return
        baggage.getId() >= 0 &&
        baggage.getWeight() >= 1 &&
        baggage.getWeight() <= 999 &&
        baggage.getWeightUnit().matches("(kg|lb)") &&
        baggage.getPieces() >= 1 &&
        baggage.getPieces() <= 999;
    }

    // ------ GET ------

    public List<CargoEntity> getAll() {
        return repository.findAll();
    }

}
