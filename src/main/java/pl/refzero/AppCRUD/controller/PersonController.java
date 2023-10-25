package pl.refzero.AppCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.refzero.AppCRUD.model.Person;
import pl.refzero.AppCRUD.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getOnePerson(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id); // Mozna uzyc orElseThrow()
        if (person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/persons/")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> personList = new ArrayList<>(personRepository.findAll());
        if (personList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @PostMapping("/persons/create")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    @PutMapping("/persons/{id}/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person personUpdated, @PathVariable Long id) {
        Optional<Person> personFromDB = personRepository.findById(id);
        if (personFromDB.isPresent()) {
            Person person = personFromDB.get();
            person.setName(personUpdated.getName());
            person.setAge(personUpdated.getAge());
            return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/persons/{id}/delete")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}




