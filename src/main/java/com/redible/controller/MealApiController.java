package com.redible.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.redible.controller.errors.MealNotExistsException;
import com.redible.model.Meal;
import com.redible.model.MealSearch;
import com.redible.service.MealService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path="/api/meals")
public class MealApiController {



    private MealService mealService;

    @Autowired
    public MealApiController(MealService mealService){
        this.mealService = mealService;
    }



    @RequestMapping(method = POST)
    public void addMeal(Meal meal){

        mealService.add(meal);
    }

    @RequestMapping(method = GET, path="/{mealId}")
    public Meal getMealById(@PathVariable String mealId){

        Meal meal = mealService.getMealById(mealId);

        if(meal != null){
            return meal;
        } else {
            throw new MealNotExistsException();
        }
    }

    @RequestMapping(method= GET)
    public Collection<Meal> getAllMeals(){
        return mealService.getAllMeals();
    }

    @RequestMapping(method= GET, path ="find")
    public Collection<Meal> findMeals(@RequestBody MealSearch mealSearch){

        return mealService.find(mealSearch);
    }




}
