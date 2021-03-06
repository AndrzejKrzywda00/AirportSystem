package airport_system.rest.controllers;

import airport_system.rest.dto.Cargo;
import airport_system.rest.services.CargoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Cargo")
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService service;

    @ApiOperation(value = "Add cargo entities", notes = "There are constraints")
    @PostMapping("")
    public void post(@RequestBody List<Cargo> cargo) {
        service.save(cargo);
    }
}
