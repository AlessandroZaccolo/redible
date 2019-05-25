package com.redible.controller;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/api")
public class ApiController {

    private MongoCollection<Document> meals;

    @Autowired
    public ApiController(@Value("${MONGO_URI}") String mongoUri) {

        final MongoClient mongoClient = MongoClients.create(mongoUri);
        final MongoDatabase database = mongoClient.getDatabase("redible");
        this.meals = database.getCollection("meals");
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from sample app";
    }




}
