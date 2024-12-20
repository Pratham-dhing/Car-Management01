package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/Car")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/all")
    public List<Car> getCar(){
        return service.getAllCar();
    }

    @PostMapping("/add")
    public String addCar(@RequestBody Car cars){
        service.addCars(cars);
        return "Car added";
    }

    @DeleteMapping("/delete/{categoryid}")
    public String delete(@PathVariable Long categoryid){
        service.deleteCar(categoryid);
        return "Car deleted of:"+categoryid;
    }

    @PutMapping("/update/{Cid}")
    public String updateCategory(@PathVariable Long Cid, @RequestBody Car updatedCars){
        service.update(Cid,updatedCars);
        return "Category updated";
    }

}
