package com.redible.repository;

import com.mongodb.client.*;
import com.redible.model.Meal;
import com.redible.model.MealSearch;
import com.redible.util.database.MongoUtil;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MealRepositoryMongo implements MealRepository{


    private MongoCollection<Document> mealsCol;
    private MealRepository mealsMap;

    public MealRepositoryMongo(){
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("mealsdb");
        this.mealsCol = database.getCollection("meals");

    }

    @Override
    public void add(Meal meal) {

        Document mealDoc = MongoUtil.doc()
                .append("name", meal.getName())
                .append("price", meal.getPrice())
                .append("quantity", meal.getQuantity())
                .append("discount", meal.getDiscount());

        mealsCol.insertOne(mealDoc);

        mealsMap.add(meal);


    }

    // TODO implements method with mongoDB

    @Override
    public void update(Meal meal) {

    }

    @Override
    public Meal getById(long id) {
        return null;
    }

    private Meal getMeal(Document mealDoc){

        String name = mealDoc.getString("name");
        double price = mealDoc.getDouble("price");
        int quantity = mealDoc.getInteger("quantity");
        double discount = mealDoc.getDouble("discount");

        Meal meal = new Meal(name, price, quantity,discount);

        return meal;

    }

    @Override
    public Collection<Meal> getAllMeals() {

        Iterator<Document> mealsCursor = mealsCol.find().iterator();


        Collection<Meal> collMeals = new ArrayList<>();

        while (mealsCursor.hasNext()){

            Document meal = mealsCursor.next();

            collMeals.add(getMeal(meal));

        }
        return collMeals;
    }

    @Override
    public Collection<Meal> find(MealSearch mealSearch) {
        return null;
    }
}
