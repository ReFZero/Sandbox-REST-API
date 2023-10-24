package pl.refzero.AppCRUD.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.refzero.AppCRUD.model.Person;
import pl.refzero.AppCRUD.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartComponent {

    private final PersonRepository personRepository;

    @Autowired
    public StartComponent(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //Wypełnienie bazy danych bezposrednio z kodu
    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase(){
        List<Person> personList = new ArrayList<>(
                List.of(
                new Person("David",45),
                new Person("John",23),
                new Person("Jamie",29),
                new Person("Alvis",76)
        ));
        personRepository.saveAll(personList);
    }
}
