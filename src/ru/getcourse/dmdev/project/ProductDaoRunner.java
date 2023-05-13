package ru.getcourse.dmdev.project;

import ru.getcourse.dmdev.project.dao.ProductDao;
import ru.getcourse.dmdev.project.dto.Filter;
import ru.getcourse.dmdev.project.entity.ProductEntity;

import java.util.List;

public class ProductDaoRunner {

    public static void main(String[] args) {
//         var productEntity1 = new ProductEntity("Buckwheat", 0.0, 2.6, 68.0, 329.0);
//        var productEntityList = List.of(new ProductEntity("ChickenBreast", 22.6, 2.8, 0.0, 115.6),
//                new ProductEntity("Macaroni", 0.0, 1.3, 70.5, 338.0),
//                new ProductEntity("Tuna", 23.0, 1.0, 0.0, 101.0),
//                new ProductEntity("Oatmeal", 0.0, 6.0, 62.0, 360.0),
//                new ProductEntity("Lentils", 0.0, 1.5, 53.0, 319.0),
//                new ProductEntity("Eggs", 12.7, 11.5, 0.0, 157.0));

        var productFilter = new Filter(10, 0, "e");
        var productEntities = ProductDao.getInstance().findAll(productFilter);

        for (ProductEntity productEntity : productEntities) {
            System.out.println(productEntity);
        }

    }

    private static void update() {
        var productDao = ProductDao.getInstance();
        var maybeProduct = productDao.findById(7L);
        System.out.println(maybeProduct);

        maybeProduct.ifPresent(productEntity -> {
            productEntity.setCaloriesIn100Grams(157.0);
            productDao.update(productEntity);
        });

        System.out.println(maybeProduct);
    }

    private static void delete(Long id) {
        var productDao = ProductDao.getInstance();
        var deleted = productDao.delete(id);
        System.out.println(deleted);
    }

    private static void save(List<ProductEntity> productEntityList) {
        var productDao = ProductDao.getInstance();
        for (ProductEntity product : productEntityList) {
            var saveProduct = productDao.save(product);
            System.out.println(saveProduct);
        }
    }

    private static void save(ProductEntity productEntity) {
        var productDao = ProductDao.getInstance();
        var saveProduct = productDao.save(productEntity);
        System.out.println(saveProduct);
    }
}

