package ru.getcourse.dmdev.project.dao;

import ru.getcourse.dmdev.project.entity.ProductEntity;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MealProductDao {

    public static final MealProductDao INSTANCE = new MealProductDao();

    public static MealProductDao getInstance() {
        return INSTANCE;
    }



}
