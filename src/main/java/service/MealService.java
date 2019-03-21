package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MealRepositoryJdbc;

@Service
public class MealService {


    private MealRepositoryJdbc mealRepo;

    @Autowired
    public MealService(MealRepositoryJdbc mealRepo) { this.mealRepo = mealRepo; }


}