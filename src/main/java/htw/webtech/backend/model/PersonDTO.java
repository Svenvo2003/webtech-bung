package htw.webtech.backend.model;

public class PersonDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;

    // Konstruktoren
    public PersonDTO() {}

    public PersonDTO(Long id, String firstname, String lastname, Integer age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Long getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public Integer getAge() { return age; }

    // SETTER (MÜSSEN vorhanden sein!)
    public void setId(Long id) { this.id = id; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setAge(Integer age) { this.age = age; }
}

