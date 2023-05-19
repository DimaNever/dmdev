package ru.getcourse.dmdev.project;

import ru.getcourse.dmdev.project.dto.MealDto;
import ru.getcourse.dmdev.project.service.MealService;

import java.util.List;

public class MealDtoRunner {

    public static void main(String[] args) {
        final MealService mealService = MealService.getInstance();

        var mealById1 = mealService.findMealById(1L);
        var mealById2 = mealService.findMealById(2L);
        var mealById6 = mealService.findMealById(6L);
        System.out.println(mealById1);
        System.out.println(mealById2);
        System.out.println(mealById6);
        System.out.println("***********************");

        var meals = mealService.findAllMeals();
        for (MealDto meal : meals) {
            System.out.println(meal);
        }

    }
}
