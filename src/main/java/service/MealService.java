package service;

import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MealRepositoryJdbc;

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

}