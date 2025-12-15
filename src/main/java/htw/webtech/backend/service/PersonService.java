package htw.webtech.backend.service;

import htw.webtech.backend.model.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    public List<PersonDTO> getAllPersons() {
        return List.of(
                new PersonDTO(1L, "vo", "Sven", 21)

        );

    }
}

