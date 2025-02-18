package com.facesdmc.facesdmc.controller;

import com.facesdmc.facesdmc.model.Car;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/api/cars")
@RestController
@CrossOrigin(origins = "*")
public class CarController {

    private static final String BASE_IMAGE_URL = "https://15d3-185-81-86-29.ngrok-free.app/api/images/";

    @GetMapping({"/cars", "/"})
    public List<Car> getCars() {
        Car car1 = new Car(
                1,
                "economy",
                generateImageUrl("Economy"),
                3,
                3,
                4.8,
                "€32.59",
                null,
                Arrays.asList("Best Value"),
                Arrays.asList("Meet & Greet included", "Free Waiting time", "Door-to-door")
        );

        Car car2 = new Car(
                2,
                "we",
                generateImageUrl("We"),
                4,
                4,
                4.5,
                "€42.00",
                "€40.00",
                Arrays.asList("Popular Choice"),
                Arrays.asList("Air Conditioning", "Free WiFi")
        );

        return Arrays.asList(car1, car2);
    }

    private String generateImageUrl(String name) {
        return BASE_IMAGE_URL + name.toLowerCase() + ".jpg";
    }
}

