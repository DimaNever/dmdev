package ru.getcourse.dmdev.project.entity;

public class MealProductEntity {
    private Long id;
    private Long productId;
    private Long mealId;
    private Integer weight;

    public MealProductEntity(Long id, Long productId, Long mealId, Integer weight) {
        this.id = id;
        this.productId = productId;
        this.mealId = mealId;
        this.weight = weight;
    }

    public MealProductEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
