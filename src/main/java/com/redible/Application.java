package com.redible;


import com.redible.repository.MealRepositoryMongo;
import com.redible.service.MealService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner test(
            MealService mealService,
            MealRepositoryMongo mealRepository){
        return args -> {
            System.out.println("App started");
        };
    }

}
