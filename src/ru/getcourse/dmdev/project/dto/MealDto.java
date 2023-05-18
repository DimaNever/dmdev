package ru.getcourse.dmdev.project.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public MealDto(Long id, String titleMeal, List<ProductDto> productDtos) {
        this.id = id;
        this.titleMeal = titleMeal;
        this.productDtos = productDtos;
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
}
