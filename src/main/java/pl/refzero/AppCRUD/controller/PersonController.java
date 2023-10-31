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

    @GetMapping("/persons/{personId}")
    public ResponseEntity<Person> getOnePerson(@PathVariable(value = "personId") Long personId) {
        return new ResponseEntity<>(personService.getPersonById(personId), HttpStatus.OK);
    }

    @GetMapping("/persons")
    //Np: "api/persons?pageNo=5&pageSize=20"
    public ResponseEntity<List<Person>> getAllPersons(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return new ResponseEntity<>(personService.getAllPersons(pageNo, pageSize), HttpStatus.OK);
    }

    @PostMapping("/persons/create")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

    @PutMapping("/persons/{personId}/update")
    public ResponseEntity<Person> updatePerson(
            @RequestBody Person personUpdated,
            @PathVariable(value = "personId") Long personId) {
        return new ResponseEntity<>(personService.updatePerson(personUpdated, personId), HttpStatus.OK);
    }

    @DeleteMapping("/persons/{personId}/delete")
    public ResponseEntity<String> deletePerson(@PathVariable(value = "personId") Long personId) {
        personService.deletePersonById(personId);
        return new ResponseEntity<>("Person deleted", HttpStatus.OK);
    }

    @PatchMapping("/persons/{personId}/update")
    //Np: "api/persons/5/update?personName=John"
    public ResponseEntity<Person> updatePersonName(
            @RequestParam(name = "personName") String personName,
            @PathVariable(name = "personId") Long personId) {
        return new ResponseEntity<>(personService.updatePersonName(personName, personId), HttpStatus.OK);
    }
}




