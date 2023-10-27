package pl.refzero.AppCRUD.service;

import pl.refzero.AppCRUD.model.Car;

import java.util.List;

public interface CarService {
    Car getCarById(Long carId);
    List<Car> getAllCars(int pageNo, int pageSize);
    Car createCar(Car car);
    Car updateCar(Car car, Long carId);
    void deleteCarById(Long carId);
    List<Car> getCarsByPersonId(Long personId);
}
