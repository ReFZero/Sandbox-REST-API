package pl.refzero.AppCRUD.service.implementation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.refzero.AppCRUD.exceptions.customExceptions.PersonNotFoundException;
import pl.refzero.AppCRUD.model.Address;
import pl.refzero.AppCRUD.model.Person;
import pl.refzero.AppCRUD.repository.PersonRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;


    @Test
    public void personService_createPerson_returnsPerson() {
        //Arrange
        Person person = Person.builder()
                .id(1L)
                .name("John")
                .age(45)
                .carList(Collections.emptyList())
                .address(Address.builder()
                        .city("Krakow")
                        .street("Sloneczna")
                        .build())
                .interests(Collections.emptySet())
                .build();
        when(personRepository.save(Mockito.any(Person.class))).thenReturn(person);
        // Gdy(zostanie wykonana metoda save(Mockito jezeli obiekt jest klasy Person)) zwróc(obiektPerson)
        //Act
        Person savedPerson = personService.createPerson(person);
        //Assert
        Assertions.assertThat(savedPerson).isNotNull();
    }

    @Test
    public void personService_getAllPersons_returnPersonList() {
        // Arrange
        Page<Person> persons = Mockito.mock(Page.class);
        when(personRepository.findAll(Mockito.any(Pageable.class))).thenReturn(persons);
        //Act
        List<Person> personList = personService.getAllPersons(1, 10);
        //Assert
        Assertions.assertThat(personList).isNotNull();
    }

    @Test
    public void personService_getPersonById_returnNotNullPerson() {
        //Arrange
        Person person = Person.builder()
                .id(1L)
                .name("John")
                .age(45)
                .carList(Collections.emptyList())
                .address(Address.builder()
                        .city("Krakow")
                        .street("Sloneczna")
                        .build())
                .interests(Collections.emptySet())
                .build();
        when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(person));
        //Act
        Person personFromDb = personRepository.findById(1L).orElseThrow(() -> new PersonNotFoundException("Person could not be found"));
        //Assert
        Assertions.assertThat(personFromDb).isNotNull();
    }
}