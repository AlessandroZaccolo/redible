package com.redible.examples;

import com.mongodb.client.*;
import com.redible.util.database.MongoUtil;
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
        Document meal2 = doc().append("name", "Capricciosa")
                .append("price", 12.0).append("quantity", 3).append("discount", 0.45);


        mealsCol.insertOne(meal2);
        */



        MongoCursor<Document> productsCursor = mealsCol.find().iterator();

        while(productsCursor.hasNext()){
            Document meal = productsCursor.next();
            String name = meal.getString("name");
            double price = meal.getDouble("price");
            int quantity = meal.getInteger("quantity");
            double discount = meal.getDouble("discount");
            ObjectId id = meal.getObjectId("_id");


            System.out.println(id +" Meal: "+ name +" Full-Price: "+ price
                    +" € Qty: " + quantity +" Discount: " + discount +"%");
        }

        productsCursor.close();



    }
}
