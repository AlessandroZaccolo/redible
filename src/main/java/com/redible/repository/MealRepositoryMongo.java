package com.redible.repository;

import com.mongodb.client.*;
import com.redible.model.Meal;
import com.redible.model.MealSearch;
import com.redible.util.database.MongoUtil;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MealRepositoryMongo implements MealRepository{


    private MongoCollection<Document> mealsCol;
    private long mealId;

    public MealRepositoryMongo(){
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("mealsdb");
        this.mealsCol = database.getCollection("meals");
        mealId = 0;
    }

    @Override
    public void add(Meal meal) {

        meal.setMealId(mealId);

        Document mealDoc = MongoUtil.doc()
                .append("mealId", mealId)
                .append("name", meal.getName())
                .append("price", meal.getPrice())
                .append("quantity", meal.getQuantity())
                .append("discount", meal.getDiscount());

        mealsCol.insertOne(mealDoc);

        mealId++;

    }

    // TODO implements method with mongoDB

    @Override
    public void update(Meal meal) {

        mealsCol.updateOne(eq("mealId", meal.getMealId()), new Document("$set", new Document("name", meal.getName())));
        mealsCol.updateOne(eq("mealId", meal.getMealId()), new Document("$set", new Document("price", meal.getPrice())));
        mealsCol.updateOne(eq("mealId", meal.getMealId()), new Document("$set", new Document("quantity", meal.getQuantity())));
        mealsCol.updateOne(eq("mealId", meal.getMealId()), new Document("$set", new Document("discount", meal.getDiscount())));
    }

    @Override
    public void remove(Meal meal){

    }

    public Meal getMealById(long mealId) {

        Meal meal = getMeal(mealsCol.find(eq("mealId", mealId)).first());

        return meal;
    }

    private Meal getMeal(Document mealDoc){

        long mealId = mealDoc.getLong("mealId");
        String name = mealDoc.getString("name");
        double price = mealDoc.getDouble("price");
        int quantity = mealDoc.getInteger("quantity");
        double discount = mealDoc.getDouble("discount");

        Meal meal = new Meal(mealId, name, price, quantity, discount);

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
