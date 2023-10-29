package pl.refzero.AppCRUD.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.refzero.AppCRUD.model.Car;
import pl.refzero.AppCRUD.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "carId") Long carId) {
        return new ResponseEntity<>(carService.getCarById(carId), HttpStatus.OK);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "20", required = false) int pageSize) {
        return new ResponseEntity<>(carService.getAllCars(pageNo, pageSize), HttpStatus.OK);
    }

    @PostMapping("/cars/create")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.CREATED);
    }

    @PutMapping("cars/{carId}/update")
    public ResponseEntity<Car> updateCar(
            @RequestBody Car car,
            @PathVariable(value = "carId") Long carId) {
        return new ResponseEntity<>(carService.updateCar(car, carId), HttpStatus.OK);
    }

    @DeleteMapping("/cars/{carId}/delete")
    public ResponseEntity<String> deleteCar(@PathVariable(value = "carId") Long carId) {
        carService.deleteCarById(carId);
        return new ResponseEntity<>("Car deleted", HttpStatus.OK);
    }

    @GetMapping("/persons/{personId}/cars")
    public ResponseEntity<List<Car>> getCarsByPersonId(@PathVariable(value = "personId") Long personId) {
        return new ResponseEntity<>(carService.getCarsByPersonId(personId), HttpStatus.OK);
    }

    @GetMapping("/persons/{personId}/cars/{carId}")
    public ResponseEntity<Car> getOneCarByPersonId(@PathVariable(value = "carId") Long carId,
                                                   @PathVariable(value = "personId") Long personId) {
        return new ResponseEntity<>(carService.getCarById(carId, personId), HttpStatus.OK);
    }
}
