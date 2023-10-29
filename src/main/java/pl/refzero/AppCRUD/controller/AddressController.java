package pl.refzero.AppCRUD.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.refzero.AppCRUD.model.Address;
import pl.refzero.AppCRUD.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses/{address_id}")
    public ResponseEntity<Address> getOneAddress(@PathVariable(name ="address_id" ) Long addressId){
        return new ResponseEntity<>(addressService.getAddress(addressId), HttpStatus.OK);
    }
}
