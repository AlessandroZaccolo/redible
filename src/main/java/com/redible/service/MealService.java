package com.redible.service;

import com.redible.model.Meal;
import com.redible.model.MealSearch;
import com.redible.repository.MealRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MealService {


    private MealRepositoryMongo mealRepo;

    @Autowired
    public MealService(MealRepositoryMongo mealRepo) { this.mealRepo = mealRepo; }

    public void add(Meal meal){
        mealRepo.add(meal);
    }


    public Meal getMealById(String mealId){

        return mealRepo.getMealById(mealId);
    }

    public Collection<Meal> getAllMeals(){

        return mealRepo.getAllMeals();
    }


    public Collection<Meal> find(MealSearch mealSearch){

        return mealRepo.find(mealSearch);
    }


}
