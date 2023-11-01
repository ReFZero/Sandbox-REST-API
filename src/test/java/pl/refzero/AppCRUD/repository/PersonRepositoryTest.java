package pl.refzero.AppCRUD.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.refzero.AppCRUD.model.Address;
import pl.refzero.AppCRUD.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void personRepository_Save_ReturnSavedPerson() {
        //Arrange - given
        Person person = Person.builder()
                .name("John")
                .age(45)
                .address(Address.builder()
                        .city("Krakow")
                        .street("Sloneczna")
                        .build())
                .build();
        //Act - when
        Person savedPerson = personRepository.save(person);
        //Assert - then
        Assertions.assertThat(savedPerson).isNotNull();
        Assertions.assertThat(savedPerson.getId()).isGreaterThan(0);
    }

    @Test
    void personRepository_findAll_returnMoreThanOnePerson() {
        //Arrange - given
        Person person1 = Person.builder()
                .name("John")
                .age(45)
                .address(Address.builder()
                        .city("Krakow")
                        .street("Sloneczna")
                        .build())
                .build();

        Person person2 = Person.builder()
                .name("David")
                .age(23)
                .address(Address.builder()
                        .city("Poznan")
                        .street("Kwiatowa")
                        .build())
                .build();
        personRepository.save(person1);
        personRepository.save(person2);
        //Act - When
        List<Person> personList = new ArrayList<>(personRepository.findAll());
        //Assert
        Assertions.assertThat(personList).isNotEmpty();
        Assertions.assertThat(personList.size()).isGreaterThan(1);
    }

    @Test
    void personRepository_findById_returnOnePersonWithSpecificId() {
        //Arrange - given
        Person person1 = Person.builder()
                .name("John")
                .age(45)
                .address(Address.builder()
                        .city("Krakow")
                        .street("Sloneczna")
                        .build())
                .build();

        personRepository.save(person1);
        //Act - When
        Person person2 = personRepository.findById(person1.getId()).get();
        //Assert
        Assertions.assertThat(person1).isNotNull();
        Assertions.assertThat(person1.getId()).isEqualTo(person2.getId());
    }

    @Test
    void personRepository_findPersonByName_returnPersonNotNull() {
        //Arrange - given
        Person person = Person.builder()
                .name("John")
                .age(45)
                .address(Address.builder()
                        .city("Krakow")
                        .street("Sloneczna")
                        .build())
                .build();
        //Act - when
        personRepository.save(person);

        Person resultPerson = personRepository.findPersonByName(person.getName()).get();
        //Assert
        Assertions.assertThat(resultPerson).isNotNull();
    }

    @Test
    void personRepository_updatePerson_returnPersonNotNull(){
        //Arrange - given
        Person person = Person.builder()
                .name("John")
                .age(45)
                .address(Address.builder()
                        .city("Krakow")
                        .street("Sloneczna")
                        .build())
                .build();
        //Act - when
        personRepository.save(person);

        Person savedPerson = personRepository.findById(person.getId()).get();
        savedPerson.setName("David");
        savedPerson.setAge(37);

        Person updatedPerson = personRepository.save(savedPerson);
        //Assert - then

        Assertions.assertThat(updatedPerson.getName()).isNotNull();
        Assertions.assertThat(updatedPerson.getAge()).isNotNull();

    }

    @Test
    void personRepository_deletePersonById_personIsEmpty(){
        //Arrange - given
        Person person = Person.builder()
                .name("John")
                .age(45)
                .address(Address.builder()
                        .city("Krakow")
                        .street("Sloneczna")
                        .build())
                .build();
        personRepository.save(person);
        //Act - when
        Person personToDelete = personRepository.findById(person.getId()).get();
        personRepository.delete(personToDelete);

        Optional<Person> personFromDb = personRepository.findById(personToDelete.getId());
        //Assert - then
        Assertions.assertThat(personFromDb).isEmpty();
    }
}
