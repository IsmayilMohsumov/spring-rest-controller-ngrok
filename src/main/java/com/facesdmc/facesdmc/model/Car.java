package com.facesdmc.facesdmc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int id;
    private String name;
    private String image;
    private int passengers;
    private int suitcases;
    private double rating;
    private String price;

    @JsonProperty("discounted_price")
    private String discountedPrice;
    private List<String> tags;
    private List<String> features;
}