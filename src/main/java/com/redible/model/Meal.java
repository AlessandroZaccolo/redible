package com.redible.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Meal {

    private String mealId;
    private String name;
    private double price;
    private int quantity;
    private double discount;
    private double rating;

    public Meal (String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.rating = 0.0;
    }

    public Meal (String mealId, String name, double price, int quantity, double discount) {
        this.mealId = mealId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.rating = 0.0;
    }



    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public double getDiscountedPrice() {

        double discountedPrice = price * (1 - discount);
        double result = Math.round(discountedPrice*1000d)/1000d;
        return result;
    }


    @Override
    public String toString(){
        return "id: "+ mealId + " name: " + name;
    }




}
