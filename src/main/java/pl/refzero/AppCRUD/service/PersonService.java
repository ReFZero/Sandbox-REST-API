package pl.refzero.AppCRUD.service;

import pl.refzero.AppCRUD.model.Person;

import java.util.List;

public interface PersonService {
Person getPersonById(Long id);
List<Person> getAllPersons();
Person createPerson(Person person);
Person updatePerson(Person person, Long id);
void deletePersonById(Long id);
}
