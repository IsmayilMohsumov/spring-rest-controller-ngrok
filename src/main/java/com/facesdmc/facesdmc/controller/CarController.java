package com.facesdmc.facesdmc.controller;

import com.facesdmc.facesdmc.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class CarController {

    @GetMapping({"/cars","/"})
    public List<Car> getCars() {
        return Arrays.asList(
                new Car(1L, "Toyota", "Camry", 2021, "White", "Hybrid", 208, 30000.00),
                new Car(2L, "Honda", "Civic", 2020, "Black", "Petrol", 158, 25000.00),
                new Car(3L, "Ford", "Mustang", 2019, "Red", "Petrol", 450, 55000.00),
                new Car(4L, "Tesla", "Model S", 2022, "Blue", "Electric", 670, 80000.00),
                new Car(5L, "BMW", "M3", 2018, "Silver", "Petrol", 425, 60000.00)
        );
    }
}

