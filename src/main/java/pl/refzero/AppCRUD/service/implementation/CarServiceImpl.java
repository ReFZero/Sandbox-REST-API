package pl.refzero.AppCRUD.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.refzero.AppCRUD.exceptions.customExceptions.CarNotFoundException;
import pl.refzero.AppCRUD.model.Car;
import pl.refzero.AppCRUD.repository.CarRepository;
import pl.refzero.AppCRUD.service.CarService;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car could not be found"));
    }

    @Override
    public List<Car> getAllCars(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Car> cars = carRepository.findAll(pageable);
        return new ArrayList<>(cars.getContent());
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Car car, Long id) {
        Car carFromDB = carRepository.findById(id).orElseThrow(
                () -> new CarNotFoundException("Car could not be found"));
        carFromDB.setBrand(car.getBrand());
        carFromDB.setProductionYear(car.getProductionYear());
        carFromDB.setPerson(car.getPerson());
        return carRepository.save(carFromDB);
    }

    @Override
    public void deleteCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car could not be found"));
        carRepository.delete(car);
    }
}
