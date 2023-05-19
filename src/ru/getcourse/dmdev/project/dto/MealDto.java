package ru.getcourse.dmdev.project.dto;

import ru.getcourse.dmdev.project.entity.MealEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MealDto {
    private Long id;
    private String titleMeal;
    private  List<ProductDto> productDtos = new ArrayList<>();

    public MealDto(String titleMeal) {
        this.titleMeal = titleMeal;
    }

    public MealDto(Long id, String titleMeal) {
        this.id = id;
        this.titleMeal = titleMeal;
    }

    public static MealDto fromEntity(Optional<MealEntity> mealEntity) {
        return new MealDto(mealEntity.get().getId(),
                mealEntity.get().getTitleMeal()
        );
    }

    public MealDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleMeal() {
        return titleMeal;
    }

    public void setTitleMeal(String titleMeal) {
        this.titleMeal = titleMeal;
    }

    public List<ProductDto> getProductDtos() {
        return productDtos;
    }

    public void setProductDtos(List<ProductDto> productDtos) {
        this.productDtos = productDtos;
    }

    @Override
    public String toString() {
        return "MealDto{" +
               "id=" + id +
               ", titleMeal='" + titleMeal + '\'' +
               ", productDtos=" + productDtos +
               '}';
    }
}
