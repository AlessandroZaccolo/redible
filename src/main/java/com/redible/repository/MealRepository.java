package com.redible.repository;


import com.redible.model.Meal;
import com.redible.model.MealSearch;


import java.util.Collection;

public interface MealRepository {


    void add(Meal meal);

    void update(Meal meal);

    void remove(Meal meal);

    Meal getMealById(long id);

    Collection<Meal> getAllMeals();

    Collection<Meal> find(MealSearch mealSearch);




}
