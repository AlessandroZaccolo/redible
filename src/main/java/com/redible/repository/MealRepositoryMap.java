package com.redible.repository;

/*
 * Store meals in memory (in a Map)
 */

import com.redible.model.Meal;

import java.util.Collection;
import java.util.Map;

public class MealRepositoryMap {


    private Map<Long, Meal> mealMap;
    private long nextId;

    public MealRepositoryMap() {
        this.mealMap = mealMap;
        nextId = 0;
    }

    public void add(Meal meal){
    }

    public Meal getById(long id){
        return mealMap.get(id);
    }

    public Collection<Meal> getAll(){
        return mealMap.values();
    }

    public long getNextId() { return nextId; }


}
