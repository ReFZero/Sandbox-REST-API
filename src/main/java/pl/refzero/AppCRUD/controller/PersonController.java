package pl.refzero.AppCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.refzero.AppCRUD.model.Person;
import pl.refzero.AppCRUD.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getOnePerson(@PathVariable Long id) {
        return new ResponseEntity<>(personService.getPersonById(id),HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
       return new ResponseEntity<>(personService.getAllPersons(),HttpStatus.OK);
    }

    @PostMapping("/persons/create")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

    @PutMapping("/persons/{id}/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person personUpdated, @PathVariable Long id) {
    return new ResponseEntity<>(personService.updatePerson(personUpdated,id),HttpStatus.OK);
    }

    @DeleteMapping("/persons/{id}/delete")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
   return new ResponseEntity<>("Person deleted",HttpStatus.OK);
    }
}




