package htw.webtech.backend.Controller;

import htw.webtech.backend.model.PersonDTO;
import htw.webtech.backend.service.PersonService;
import htw.webtech.backend.entity.Message;
import htw.webtech.backend.entity.User;
import htw.webtech.backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:5173", "https://bibs-chat-frontend.onrender.com"})
public class PersonController {
    private final PersonService personService;
    private final UserRepository userRepository;
    private List<Message> messages = new ArrayList<>();

    // Konstruktor mit beiden Abhängigkeiten
    public PersonController(PersonService personService, UserRepository userRepository) {
        this.personService = personService;
        this.userRepository = userRepository;
    }

    // GET: Alle Personen abrufen
    @GetMapping("/persons")
    public ResponseEntity<List<User>> getPersons() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    // POST: Neue Person (User) erstellen
    @PostMapping("/persons")
    public ResponseEntity<String> createUser(@RequestBody PersonDTO personDTO) {
        System.out.println("🚀 POST /persons empfangen:");
        System.out.println("  Vorname: " + personDTO.getFirstname());
        System.out.println("  Nachname: " + personDTO.getLastname());
        System.out.println("  Alter: " + personDTO.getAge());

        // User-Objekt erstellen
        User user = new User();
        user.setFirstname(personDTO.getFirstname());
        user.setLastname(personDTO.getLastname());
        user.setAge(personDTO.getAge());

        // In Datenbank speichern
        User savedUser = userRepository.save(user);

        // Erfolgsmeldung zurückgeben
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("✅ User '" + savedUser.getFirstname() +
                        " " + savedUser.getLastname() +
                        "' gespeichert (ID: " + savedUser.getId() + ")");
    }

    // GET: Test-Endpunkt
    @GetMapping("/test")
    public String test() {
        return "Hallo Wilkoomen, Backend läuft! ";
    }

    // GET: Alle Nachrichten
    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messages;
    }

    // POST: Neue Nachricht
    @PostMapping("/messages")
    public void addMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now());
        messages.add(message);
    }
}