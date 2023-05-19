package ru.getcourse.dmdev.project.entity;

public class MealProductEntity {
    private Long id;
    private Long mealId;
    private Long productId;
    private Integer massOfIngredient;

    public MealProductEntity(Long id, Long mealId, Long productId, Integer massOfIngredient) {
        this.id = id;
        this.mealId = mealId;
        this.productId = productId;
        this.massOfIngredient = massOfIngredient;
    }

    public MealProductEntity(Long mealId, Long productId, Integer massOfIngredient) {
        this.mealId = mealId;
        this.productId = productId;
        this.massOfIngredient = massOfIngredient;
    }

    public MealProductEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getMassOfIngredient() {
        return massOfIngredient;
    }

    public void setMassOfIngredient(Integer massOfIngredient) {
        this.massOfIngredient = massOfIngredient;
    }

    @Override
    public String toString() {
        return "MealProductEntity{" +
               "id=" + id +
               ", mealId=" + mealId +
               ", productId=" + productId +
               ", massOfIngredient=" + massOfIngredient +
               '}';
    }
}
