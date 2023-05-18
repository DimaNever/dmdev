package ru.getcourse.dmdev.project;

import ru.getcourse.dmdev.project.service.MealService;

public class MealDtoRunner {

    public static void main(String[] args) {
        final MealService mealService = MealService.getInstance();

        var mealById1 = mealService.findMealById(1L);
        var mealById6 = mealService.findMealById(6L);
        System.out.println(mealById1);
        System.out.println(mealById6);

    }
}
