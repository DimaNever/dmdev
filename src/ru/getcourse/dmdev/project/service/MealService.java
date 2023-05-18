package ru.getcourse.dmdev.project.service;

import ru.getcourse.dmdev.project.dao.MealDao;
import ru.getcourse.dmdev.project.dto.MealDto;

import java.util.List;

public class MealService {

    public static final MealService INSTANCE = new MealService();

    private final MealDao mealDao = MealDao.getInstance();

    private MealService() {
    }

//    public List<MealDto> findAll() {
//        return mealDao.findAll().stream()
//                .map(mealEntity -> new MealDto(
//                        mealEntity.getId(),
//
//                ))
//    }

    public static MealService getInstance() {
        return INSTANCE;
    }
}
