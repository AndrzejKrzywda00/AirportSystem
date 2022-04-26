package airport_system.rest.controllers;

import airport_system.rest.dto.Cargo;
import airport_system.rest.entities.CargoEntity;
import airport_system.rest.services.CargoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(tags = "Cargo")
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService service;

    @ApiOperation(value = "Add cargo entities", notes = "There are constraints")
    @PostMapping("")
    public void post(@Validated @RequestBody List<Cargo> cargo) {
        service.save(cargo);
    }

    // testing -- to be removed
    @GetMapping("/all")
    public List<CargoEntity> getAll() {
        return service.getAll();
    }

}
