package ru.getcourse.dmdev.project.service;

import ru.getcourse.dmdev.project.dao.MealDao;
import ru.getcourse.dmdev.project.dao.MealProductDao;
import ru.getcourse.dmdev.project.dao.ProductDao;
import ru.getcourse.dmdev.project.dto.MealDto;
import ru.getcourse.dmdev.project.dto.ProductDto;
import ru.getcourse.dmdev.project.entity.MealEntity;
import ru.getcourse.dmdev.project.entity.MealProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MealService {

    public static final MealService INSTANCE = new MealService();

    private final MealDao mealDao = MealDao.getInstance();

    private final MealProductDao mealProductDao = MealProductDao.getInstance();
    private final ProductDao productDao = ProductDao.getInstance();


    private MealService() {
    }

    public MealDto findMealById(Long mealId) {
        Optional<MealEntity> mealEntity = mealDao.findByMealId(mealId);
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

    public List<MealDto> findAllMeals() {
        List<MealEntity> mealEntityList = mealDao.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        List<MealDto> mealDtoList = new ArrayList<>();

        for (MealEntity mealEntity : mealEntityList) {
            MealDto mealDto = MealDto.fromEntity(Optional.ofNullable(mealEntity));
            List<MealProductEntity> mealProductEntityList = mealProductDao.findById(mealEntity.getId());
            for (MealProductEntity mealProductEntity : mealProductEntityList) {
                var productEntity = productDao.findById(mealProductEntity.getProductId());
                var productDto = ProductDto.fromEntity(productEntity);
                productDtos.add(productDto);
                mealDto.setProductDtos(productDtos);
            }
            mealDtoList.add(mealDto);
        }
        return mealDtoList;
    }


    public static MealService getInstance() {
        return INSTANCE;
    }
}
