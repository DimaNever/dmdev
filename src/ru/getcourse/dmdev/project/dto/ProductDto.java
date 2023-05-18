package ru.getcourse.dmdev.project.dto;

import ru.getcourse.dmdev.project.entity.ProductEntity;

import java.util.Optional;

public class ProductDto {
    private Long id;
    private String title;
    private Double proteinIn100Grams;
    private Double fatsIn100Grams;
    private Double carbsIn100Grams;
    private Double caloriesIn100Grams;

    public ProductDto(Long id, String title, Double proteinIn100Grams, Double fatsIn100Grams, Double carbsIn100Grams, Double caloriesIn100Grams) {
        this.id = id;
        this.title = title;
        this.proteinIn100Grams = proteinIn100Grams;
        this.fatsIn100Grams = fatsIn100Grams;
        this.carbsIn100Grams = carbsIn100Grams;
        this.caloriesIn100Grams = caloriesIn100Grams;
    }

    public ProductEntity toEntity() {
        return new ProductEntity(id, title, proteinIn100Grams, fatsIn100Grams, carbsIn100Grams, caloriesIn100Grams);
    }

    public static ProductDto fromEntity(Optional<ProductEntity> productEntity) {
        return new ProductDto(productEntity.get().getId(),
                productEntity.get().getTitle(),
                productEntity.get().getProteinIn100Grams(),
                productEntity.get().getFatsIn100Grams(),
                productEntity.get().getCarbsIn100Grams(),
                productEntity.get().getCaloriesIn100Grams()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getProteinIn100Grams() {
        return proteinIn100Grams;
    }

    public void setProteinIn100Grams(Double proteinIn100Grams) {
        this.proteinIn100Grams = proteinIn100Grams;
    }

    public Double getFatsIn100Grams() {
        return fatsIn100Grams;
    }

    public void setFatsIn100Grams(Double fatsIn100Grams) {
        this.fatsIn100Grams = fatsIn100Grams;
    }

    public Double getCarbsIn100Grams() {
        return carbsIn100Grams;
    }

    public void setCarbsIn100Grams(Double carbsIn100Grams) {
        this.carbsIn100Grams = carbsIn100Grams;
    }

    public Double getCaloriesIn100Grams() {
        return caloriesIn100Grams;
    }

    public void setCaloriesIn100Grams(Double caloriesIn100Grams) {
        this.caloriesIn100Grams = caloriesIn100Grams;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
               "id=" + id +
               ", title='" + title + '\'' +
               '}';
    }
}
