package pl.refzero.AppCRUD.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.refzero.AppCRUD.exceptions.PersonNotFoundException;
import pl.refzero.AppCRUD.model.Person;
import pl.refzero.AppCRUD.repository.PersonRepository;
import pl.refzero.AppCRUD.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person could not be found"));
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person, Long id) {
        Person personToUpdate = personRepository.findById(id).orElseThrow(
                () -> new PersonNotFoundException("Person could not be found"));
        personToUpdate.setName(person.getName());
        personToUpdate.setAge(person.getAge());
        personRepository.save(personToUpdate);
        return personToUpdate;
    }

    @Override
    public void deletePersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person could not be found"));
        personRepository.delete(person);
    }

}
