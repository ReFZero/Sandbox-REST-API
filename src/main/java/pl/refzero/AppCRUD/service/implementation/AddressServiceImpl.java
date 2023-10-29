package pl.refzero.AppCRUD.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.refzero.AppCRUD.exceptions.customExceptions.AddressNotFoundException;
import pl.refzero.AppCRUD.model.Address;
import pl.refzero.AppCRUD.repository.AddressRepository;
import pl.refzero.AppCRUD.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Address could not be found"));
    }
}
