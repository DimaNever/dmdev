package ru.getcourse.dmdev.project;

import ru.getcourse.dmdev.project.dao.MealDao;
import ru.getcourse.dmdev.project.dao.ProductDao;
import ru.getcourse.dmdev.project.dto.Filter;
import ru.getcourse.dmdev.project.entity.MealEntity;
import ru.getcourse.dmdev.project.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;


public class MealDaoRunner {

    public static void main(String[] args) {
//        var mealEntity1 = new MealEntity("Oatmeal with eggs");
//        var mealEntity2 = new MealEntity("Buckwheat with chicken");
//        var mealEntity3 = new MealEntity("Buckwheat with tuna");
//        var mealEntity4 = new MealEntity("Pasta with chicken");
//        var mealEntity5 = new MealEntity("Pasta with tuna");
//        var mealEntity6 = new MealEntity("Lentils with chicken");
//
//        List<MealEntity> mealEntityList = new ArrayList<>();
//        mealEntityList.add(mealEntity1);
//        mealEntityList.add(mealEntity2);
//        mealEntityList.add(mealEntity3);
//        mealEntityList.add(mealEntity4);
//        mealEntityList.add(mealEntity5);
//        mealEntityList.add(mealEntity6);
//
//        save(mealEntityList);

        var filterMeal = new Filter(10, 0, "B");
        var mealEntities = MealDao.getInstance().findAll(filterMeal);
        for (MealEntity mealEntity : mealEntities) {
            System.out.println(mealEntity);
        }

    }

    private static void save(List<MealEntity>  mealEntityList) {
        var mealDao = MealDao.getInstance();
        for (MealEntity mealEntity : mealEntityList) {
            var saveMeal = mealDao.save(mealEntity);
            System.out.println(saveMeal);
        }
    }

}
