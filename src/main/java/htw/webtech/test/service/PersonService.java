package htw.webtech.test.service;

import htw.webtech.test.model.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    public List<PersonDTO> getAllPersons() {
        return List.of(
                new PersonDTO("vo" , "Sven", 21)

        );

    }
}

