package model;

public class Meal {

    private long MealId;
    private String name;
    private String address;
    private double price;
    private int quantity;
    private String MealDescription;

    public Meal(String name, String address, double price, int quantity, String Mealdescriptionn) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.quantity = quantity;
        this.MealDescription = MealDescription;
        MealId++;
    }

}
