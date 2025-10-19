package htw.webtech.test.Controller;
import htw.webtech.test.model.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import htw.webtech.test.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/vi")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/persons")
        public ResponseEntity<List<PersonDTO>>getPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
        }

}
