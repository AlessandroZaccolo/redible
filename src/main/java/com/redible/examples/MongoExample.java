package com.redible.examples;


import com.mongodb.client.*;
import com.redible.model.Meal;
import com.redible.repository.MealRepositoryMongo;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.redible.util.database.MongoUtil.doc;

public class MongoExample {

    public static void main(String[] args) {


        // Create a client and connect to the server (by default, local server)
        MongoClient mongoClient = MongoClients.create();

        // Here we get the database
        MongoDatabase database = mongoClient.getDatabase("mealsdb");

        MongoCollection<Document> mealsCol = database.getCollection("meals");





        /*

        Document meal1 = doc().append("name", "Capricciosa")
                .append("price", 12.0).append("quantity", 3).append("discount", 0.45);

        Document meal2 = doc().append("name", "Gnocchi")
                .append("price", 6.0).append("quantity", 1).append("discount", 0.6);

        Document meal3 = doc().append("name", "Sushi")
                .append("price", 4.0).append("quantity", 4).append("discount", 0.7);


        Document meal4 = doc().append("name", "Pesto Pasta")
                .append("price", 6.0).append("quantity", 2).append("discount", 0.45);


        mealsCol.deleteOne(meal1);
        mealsCol.deleteOne(meal2);
        mealsCol.deleteOne(meal3);
        mealsCol.deleteOne(meal4);





        MealRepositoryMongo mongo = new MealRepositoryMongo();
        Meal meal1 = new Meal("Capricciosa", 12.0, 3, 0.45);
        Meal meal2 = new Meal("Gnocchi", 6.0, 1, 0.6);
        Meal meal3 = new Meal("Sushi", 4.0, 4, 0.7);
        Meal meal4 = new Meal("Pesto Pasta", 6.0, 2, 0.45);


        mongo.add(meal1);
        mongo.add(meal2);
        mongo.add(meal3);
        mongo.add(meal4);


        */


        MongoCursor<Document> mealsCursor = mealsCol.find().iterator();


        while(mealsCursor.hasNext()){
            Document meal = mealsCursor.next();


            String name = meal.getString("name");
            double price = meal.getDouble("price");
            int quantity = meal.getInteger("quantity");
            double discount = meal.getDouble("discount");
            ObjectId mongoId = meal.getObjectId("_id");





            System.out.println(mongoId +" Meal: "+ name +" Full-Price: "+ price
                    +" € Qty: " + quantity +" Discount: " + discount +"%");
        }

        mealsCursor.close();





    }
}
