package airport_system.rest.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public record TestService(ModelMapper modelMapper) {

    // ------ TESTING ------

    public boolean testAll() {
        return true;
    }
    // TODO -- implement this

}
