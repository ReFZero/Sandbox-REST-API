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
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/getOnePerson/{id}")
    public ResponseEntity<Person> getOnePerson(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id); // Mozna uzyc orElseThrow()
        if (person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllPersons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> personList = new ArrayList<>(personRepository.findAll());
        if (personList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    @PutMapping("/updatePerson/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person personUpdated, @PathVariable Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            person.setName(personUpdated.getName());
            person.setAge(personUpdated.getAge());
            return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}




