package com.redible.model;

public class Meal {

    private long mealId;
    private String name;
    private double price;
    private int quantity;
    private double discount;
    private double rating;

    public Meal (String name, double price, int quantity, double discount) {
        this.mealId = mealId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.rating = 0.0;
    }


    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
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

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountedPrice() {

        return price * (1 - discount);
    }


    @Override
    public String toString(){
        return "id: "+ mealId + " name: " + name;
    }




}
