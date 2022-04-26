package airport_system.rest.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Test")
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    @ApiOperation(value = "Simple test if server is responding")
    @GetMapping("")
    public String get() {
        return "ok";
    }
}
