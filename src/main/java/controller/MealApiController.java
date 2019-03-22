package controller;

import controller.errors.MealNotExistsException;
import model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MealService;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path="/api/meals")
public class MealApiController {

    private MealService mealService;

    @Autowired
    public MealApiController(MealService mealService){
        this.mealService = mealService;
    }

    @RequestMapping(method = GET, path="/{mealId}")
    public Meal getMealById(@PathVariable long mealId){

        final Meal meal = mealService.getMealById(mealId);

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



}
