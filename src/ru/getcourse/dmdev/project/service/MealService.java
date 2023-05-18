package ru.getcourse.dmdev.project.service;

import ru.getcourse.dmdev.project.dao.MealDao;
import ru.getcourse.dmdev.project.dao.MealProductDao;
import ru.getcourse.dmdev.project.dao.ProductDao;
import ru.getcourse.dmdev.project.dto.MealDto;
import ru.getcourse.dmdev.project.dto.ProductDto;
import ru.getcourse.dmdev.project.entity.MealProductEntity;

import java.util.ArrayList;
import java.util.List;

public class MealService {

    public static final MealService INSTANCE = new MealService();

    private final MealDao mealDao = MealDao.getInstance();

    private final MealProductDao mealProductDao = MealProductDao.getInstance();
    private final ProductDao productDao = ProductDao.getInstance();


    private MealService() {
    }

    public MealDto findMealById(Long mealId) {

        var mealEntity = mealDao.findByMealId(mealId);

        List<ProductDto> productDtos = new ArrayList<>();
        List<MealProductEntity> mealProductEntityList = mealProductDao.findById(mealEntity.get().getId());
        for (MealProductEntity mealProductEntity : mealProductEntityList) {
            var productEntity = productDao.findById(mealProductEntity.getProductId());
            var productDto = ProductDto.fromEntity(productEntity);
            productDtos.add(productDto);
        }

        var mealDto = MealDto.fromEntity(mealEntity);
        mealDto.setProductDtos(productDtos);
        return mealDto;
    }

    public static MealService getInstance() {
        return INSTANCE;
    }
}
