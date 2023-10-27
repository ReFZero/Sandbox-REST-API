package pl.refzero.AppCRUD.service;

import pl.refzero.AppCRUD.model.Car;

import java.util.List;

public interface CarService {
    Car getCarById(Long id);
    List<Car> getAllCars(int pageNo, int pageSize);
    Car createCar(Car car);
    Car updateCar(Car car, Long id);
    void deleteCarById(Long id);
}
