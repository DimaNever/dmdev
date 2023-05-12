package ru.getcourse.dmdev.project.dao;

import ru.getcourse.dmdev.project.entity.MealEntity;

import ru.getcourse.dmdev.project.exception.DaoException;
import ru.getcourse.dmdev.project.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static java.util.stream.Collectors.joining;

public class MealDao {

    public static final MealDao INSTANCE = new MealDao();

    public static MealDao getInstance() {
        return INSTANCE;
    }

    //language=PostgreSQL
    public static final String DELETE_SQL = """
            DELETE FROM meal
            WHERE id = ?
            """;

    //language=PostgreSQL
    public static final String SAVE_SQL = """
            INSERT INTO meal (title_meal) 
            VALUES (?)
            """;

    //language=PostgreSQL
    private static final String UPDATE_SQL = """
            UPDATE meal
            SET title_meal = ?
            WHERE id = ?
            """;

    //language=PostgreSQL
    public static final String FIND_ALL_SQL = """
            SELECT meal.id,
            title_meal,
            p.id,
            p.title,
            p.protein_in_100_grams,
            p.fats_in_100_grams,
            p.carbs_in_100_grams,
            p.calories_in_100_grams
            FROM meal
                 JOIN meal_product mp on meal.id = mp.meals_id
                 JOIN product p on p.id = mp.products_id
            """;

    //language=PostgreSQL
    public static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id = ?
            """;

    private MealDao() {
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

    public MealEntity save(MealEntity mealEntity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, mealEntity.getTitleMeal());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                mealEntity.setId(generatedKeys.getLong("id"));
            }
            return mealEntity;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void update(MealEntity mealEntity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, mealEntity.getTitleMeal());
            preparedStatement.setLong(2, mealEntity.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

//    public List<MealEntity> findAll(MealEntity filter) {
//        List<Object> params = new ArrayList<>();
//        List<String > whereSql = new ArrayList<>();
//        if (filter.title() != null){
//            whereSql.add("title LIKE ?");
//            params.add("%" + filter.title() + "%");
//        }
//        params.add(filter.limit());
//        params.add(filter.offset());
//        var where = " LIMIT ? OFFSET ? ";
//        if (whereSql.size() != 0) {
//            where = whereSql.stream()
//                    .collect(joining(" AND ", " WHERE ", " LIMIT ? OFFSET ? "));
//        }
//        //language=PostgreSQL
//
//        var sql = FIND_ALL_SQL + where;
//
//        try (var connection = ConnectionManager.get();
//             var preparedStatement = connection.prepareStatement(sql)) {
//            for (int i = 0; i < params.size(); i++) {
//                preparedStatement.setObject(i + 1, params.get(i));
//            }
//            var resultSet = preparedStatement.executeQuery();
//            List<MealEntity> mealEntityList = new ArrayList<>();
//            while (resultSet.next()){
//                mealEntityList.add(buildMeal(resultSet));
//            }
//            return mealEntityList;
//        } catch (SQLException e) {
//            throw new DaoException(e);
//        }
//    }

    public List<MealEntity> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<MealEntity> mealEntityList = new ArrayList<>();
            while (resultSet.next()) {
                mealEntityList.add(buildMeal(resultSet));
            }
            return mealEntityList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Optional<MealEntity> findById(Long id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);) {
            preparedStatement.setLong(1, id);

            var resultSet = preparedStatement.executeQuery();
            MealEntity mealEntity = null;
            if (resultSet.next()) {
                mealEntity = buildMeal(resultSet);
            }

            return Optional.ofNullable(mealEntity);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private MealEntity buildMeal(ResultSet resultSet) throws SQLException {
        return new MealEntity(
                resultSet.getLong("id"),
                resultSet.getString("title_meal")
        );
    }
}
