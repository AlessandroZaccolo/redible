package com.redible.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private String type;
    private String address;
    private List<Meal> mealsList = new ArrayList<>();

    public Restaurant(String name, String type, String address) {
        this.name = name;
        this.type = type;
        this.address = address;
    }
    
    


}
