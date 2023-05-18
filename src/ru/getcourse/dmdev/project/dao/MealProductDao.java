package ru.getcourse.dmdev.project.dao;

import ru.getcourse.dmdev.project.dto.Filter;
import ru.getcourse.dmdev.project.entity.MealProductEntity;
import ru.getcourse.dmdev.project.exception.DaoException;
import ru.getcourse.dmdev.project.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static java.util.stream.Collectors.joining;


public class MealProductDao {

    public static final MealProductDao INSTANCE = new MealProductDao();

    public static MealProductDao getInstance() {
        return INSTANCE;
    }


    //language=PostgreSQL
    public static final String DELETE_SQL = """
            DELETE FROM meal_product
            WHERE id = ?
            """;

    //language=PostgreSQL
    public static final String SAVE_SQL = """
            INSERT INTO meal_product (meal_id, product_id, mass_of_ingredient) 
            VALUES (?,?,?)
            """;

    //language=PostgreSQL
    private static final String UPDATE_SQL = """
            UPDATE meal_product
            SET meal_id = ?,
                product_id = ?,
                mass_of_ingredient = ?
            WHERE id = ?
            """;

    //language=PostgreSQL
    public static final String FIND_ALL_SQL = """
            SELECT id, 
            meal_id, 
            product_id, 
            mass_of_ingredient
            FROM meal_product
            """;

    //language=PostgreSQL
    public static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id = ?
            """;

    private MealProductDao() {
    }

    public boolean delete(Long id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public MealProductEntity save(MealProductEntity mealProductEntity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, mealProductEntity.getMealId());
            preparedStatement.setLong(2, mealProductEntity.getProductId());
            preparedStatement.setInt(3, mealProductEntity.getMassOfIngredient());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                mealProductEntity.setId(generatedKeys.getLong("id"));
            }
            return mealProductEntity;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void update(MealProductEntity mealProductEntity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setLong(1, mealProductEntity.getMealId());
            preparedStatement.setLong(2, mealProductEntity.getProductId());
            preparedStatement.setInt(3, mealProductEntity.getMassOfIngredient());
            preparedStatement.setLong(4, mealProductEntity.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<MealProductEntity> findAll(Filter filter) {
        List<Object> params = new ArrayList<>();
        List<String > whereSql = new ArrayList<>();
        if (filter.title() != null){
            whereSql.add("title LIKE ?");
            params.add("%" + filter.title() + "%");
        }
        params.add(filter.limit());
        params.add(filter.offset());
        var where = " LIMIT ? OFFSET ? ";
        if (whereSql.size() != 0) {
            where = whereSql.stream()
                    .collect(joining(" AND ", " WHERE ", " LIMIT ? OFFSET ? "));
        }
        //language=PostgreSQL

        var sql = FIND_ALL_SQL + where;

        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.size(); i++) {
                preparedStatement.setObject(i + 1, params.get(i));
            }
            var resultSet = preparedStatement.executeQuery();
            List<MealProductEntity> mealProductEntities = new ArrayList<>();
            while (resultSet.next()){
                mealProductEntities.add(buildMealProduct(resultSet));
            }
            return mealProductEntities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<MealProductEntity> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<MealProductEntity> mealProductEntities = new ArrayList<>();
            while (resultSet.next()) {
                mealProductEntities.add(buildMealProduct(resultSet));
            }
            return mealProductEntities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Optional<MealProductEntity> findById(Long id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);) {
            preparedStatement.setLong(1, id);

            var resultSet = preparedStatement.executeQuery();
            MealProductEntity mealProductEntity = null;
            if (resultSet.next()) {
                mealProductEntity = buildMealProduct(resultSet);
            }

            return Optional.ofNullable(mealProductEntity);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private MealProductEntity buildMealProduct(ResultSet resultSet) throws SQLException {
        return new MealProductEntity(
                resultSet.getLong("id"),
                resultSet.getLong("meal_id"),
                resultSet.getLong("product_id"),
                resultSet.getInt("mass_of_ingredient")
        );
    }
}
