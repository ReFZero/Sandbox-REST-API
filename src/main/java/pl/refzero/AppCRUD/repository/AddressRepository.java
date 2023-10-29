package pl.refzero.AppCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.refzero.AppCRUD.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
