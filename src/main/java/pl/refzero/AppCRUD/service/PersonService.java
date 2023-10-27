package pl.refzero.AppCRUD.service;

import pl.refzero.AppCRUD.model.Person;

import java.util.List;

public interface PersonService {
Person getPersonById(Long personId);
List<Person> getAllPersons(int pageNo, int pageSize);
Person createPerson(Person person);
Person updatePerson(Person person, Long personId);
void deletePersonById(Long personId);
}
