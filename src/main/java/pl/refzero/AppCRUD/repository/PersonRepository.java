package pl.refzero.AppCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.refzero.AppCRUD.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
