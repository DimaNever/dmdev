package ru.getcourse.dmdev.project.service;

import ru.getcourse.dmdev.project.dao.ProductDao;
import ru.getcourse.dmdev.project.dto.ProductDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductService {

    public static final ProductService INSTANCE = new ProductService();

    private final ProductDao productDao = ProductDao.getInstance();

    private ProductService() {
    }

    public List<ProductDto> findAll() {
        return productDao.findAll().stream()
                .map(ProductDto::fromEntity)
                .collect(toList());
    }

    public List<ProductDto> findAllByProductId(Long productId) {
        return productDao.findById(productId).stream()
                .map(ProductDto::fromEntity)
                .collect(toList());
    }

    public static ProductService getInstance() {
        return INSTANCE;
    }
}
