package ru.getcourse.dmdev.project.entity;

public class MealEntity {
    private Long id;
    private String titleMeal;

    public MealEntity(Long id, String titleMeal) {
        this.id = id;
        this.titleMeal = titleMeal;
    }

    public MealEntity(String titleMeal) {
        this.titleMeal = titleMeal;
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

    @Override
    public String toString() {
        return "MealEntity{" +
               "id=" + id +
               ", titleMeal='" + titleMeal + '\'' +
               '}';
    }
}
