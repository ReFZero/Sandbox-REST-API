package pl.refzero.AppCRUD.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.refzero.AppCRUD.exceptions.customExceptions.CarNotFoundException;
import pl.refzero.AppCRUD.exceptions.customExceptions.PersonNotFoundException;
import pl.refzero.AppCRUD.model.Car;
import pl.refzero.AppCRUD.model.Person;
import pl.refzero.AppCRUD.repository.CarRepository;
import pl.refzero.AppCRUD.repository.PersonRepository;
import pl.refzero.AppCRUD.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
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
        return carFromDB; // Dirty Checking
    }

    @Override
    public void deleteCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car could not be found"));
        carRepository.delete(car);
    }

    @Override
    public List<Car> getCarsByPersonId(Long personId) {
        return carRepository.findByPersonId(personId).stream().collect(Collectors.toList());
    }

    @Override
    public Car getCarById(Long carId, Long personId) {
        Person person = personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException("Person could not be found"));
        Car car = carRepository.findById(carId).orElseThrow(() -> new CarNotFoundException("Car with associate person not found"));
        if (!car.getPerson().getId().equals(person.getId())) {
            throw new CarNotFoundException("This car does not belong to a person");
        }
        return car;
    }
}
