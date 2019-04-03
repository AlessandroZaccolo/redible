package com.redible.repository;

import com.mongodb.client.*;
import com.redible.model.Meal;
import com.redible.model.MealSearch;
import com.redible.util.database.MongoUtil;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class MealRepositoryMongo implements MealRepository{


    private MongoCollection<Document> mealsCol;

    public MealRepositoryMongo(){
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("redible");
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

        MealRepositoryMap mealRepoMap = new MealRepositoryMap();

        mealRepoMap.add(meal);

    }

    @Override
    public void update(Meal meal) {

    }

    @Override
    public Meal getById(long id) {
        return null;
    }

    @Override
    public Collection<Meal> getAllMeals() {

        return null;
    }

    @Override
    public Collection<Meal> find(MealSearch mealSearch) {
        return null;
    }
}
