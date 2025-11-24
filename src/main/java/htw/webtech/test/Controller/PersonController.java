package htw.webtech.test.Controller;

import htw.webtech.test.model.PersonDTO;
import htw.webtech.test.service.PersonService;
import htw.webtech.test.entity.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")  // ← DIESE ZEILE EINFÜGEN!
public class PersonController {
    private final PersonService personService;
    private List<Message> messages = new ArrayList<>();

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDTO>> getPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    // GET-Route für Milestone 3 - Chat
    @GetMapping("/test")
    public String test() {
        return "Hallo Wilkoomen, Backend läuft! ";
    }

    // GET-Route für Messages
    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messages;
    }

    // POST-Route für neue Messages
    @PostMapping("/messages")
    public void addMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now());
        messages.add(message);
    }
}
