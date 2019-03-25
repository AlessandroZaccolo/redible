package com.redible.service;

import com.redible.model.Meal;
import com.redible.model.MealSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.redible.repository.MealRepositoryJdbc;

import java.util.Collection;

@Service
public class MealService {


    private MealRepositoryJdbc mealRepo;

    @Autowired
    public MealService(MealRepositoryJdbc mealRepo) { this.mealRepo = mealRepo; }


    public Meal getMealById(long id){

        return mealRepo.getById(id);
    }

    public Collection<Meal> getAllMeals(){

        return mealRepo.getAllMeals();
    }


    public Collection<Meal> find(MealSearch mealSearch){

        return mealRepo.find(mealSearch);
    }


}