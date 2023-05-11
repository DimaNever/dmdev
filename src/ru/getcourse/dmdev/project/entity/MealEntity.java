package ru.getcourse.dmdev.project.entity;

import java.util.ArrayList;
import java.util.List;

public class MealEntity {
    private Long id;
    private String titleMeal;

    private List<ProductEntity> productEntityList = new ArrayList<>();

    public MealEntity(Long id, String titleMeal, List<ProductEntity> productEntityList) {
        this.id = id;
        this.titleMeal = titleMeal;
        this.productEntityList = productEntityList;
    }

    public MealEntity(String titleMeal, List<ProductEntity> productEntityList) {
        this.titleMeal = titleMeal;
        this.productEntityList = productEntityList;
    }

    public MealEntity() {
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

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

    @Override
    public String toString() {
        return "MealEntity{" +
               "id=" + id +
               ", titleMeal='" + titleMeal + '\'' +
               ", productEntityList=" + productEntityList +
               '}';
    }
}
