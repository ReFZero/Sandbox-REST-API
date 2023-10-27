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

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
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

    @PutMapping("cars/{id}/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathVariable Long id) {
        return new ResponseEntity<>(carService.updateCar(car, id), HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}/delete")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
        return new ResponseEntity<>("Car deleted", HttpStatus.OK);
    }
}
