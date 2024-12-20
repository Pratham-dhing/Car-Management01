package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private Long nextInt=1L;

    @Autowired
    private OkRepository repository;

    public List<Car> getAllCar() {
        return repository.findAll();
    }

    public void addCars(Car cars) {
        cars.setId(++nextInt);
        repository.save(cars);
    }

    public void deleteCar(Long categoryid) {
        repository.findById(categoryid);
        repository.deleteById(categoryid);
    }

    public void update(Long cid, Car updatedCars) {
        Optional<Car> cars = repository.findById(cid);
        if (cars.isPresent()) {
            Car carss = cars.get();
            carss.setCarModel(updatedCars.getCarModel());
            carss.setColour(updatedCars.getColour());
            carss.setPrice(updatedCars.getPrice());
            carss.setYear(updatedCars.getYear());
            carss.setFuelType(updatedCars.getFuelType());
            carss.setCarName(updatedCars.getCarName());
            repository.save(carss);
        }
        System.out.print("Not found");
    }
}
