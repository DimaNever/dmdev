package ru.getcourse.dmdev.project.dao;

import ru.getcourse.dmdev.project.dto.Filter;
import ru.getcourse.dmdev.project.entity.ProductEntity;
import ru.getcourse.dmdev.project.exception.DaoException;
import ru.getcourse.dmdev.project.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static java.util.stream.Collectors.joining;

public class ProductDao {

    public static final ProductDao INSTANCE = new ProductDao();

    public static ProductDao getInstance() {
        return INSTANCE;
    }

    //language=PostgreSQL
    public static final String DELETE_SQL = """
            DELETE FROM product
            WHERE id = ?
            """;

    //language=PostgreSQL
    public static final String SAVE_SQL = """
            INSERT INTO product (title, protein_in_100_grams, fats_in_100_grams, carbs_in_100_grams, calories_in_100_grams) 
            VALUES (?,?,?,?,?)
            """;

    //language=PostgreSQL
    private static final String UPDATE_SQL = """
            UPDATE product
            SET title = ?,
                protein_in_100_grams = ?,
                fats_in_100_grams = ?,
                carbs_in_100_grams = ?,
                calories_in_100_grams = ?
            WHERE id = ?
            """;

    //language=PostgreSQL
    public static final String FIND_ALL_SQL = """
            SELECT id,
            title,
            protein_in_100_grams,
            fats_in_100_grams,
            carbs_in_100_grams,
            calories_in_100_grams
            FROM product
            """;

    //language=PostgreSQL
    public static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id = ?
            """;

    private ProductDao() {
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

    public ProductEntity save(ProductEntity productEntity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, productEntity.getTitle());
            preparedStatement.setDouble(2, productEntity.getProteinIn100Grams());
            preparedStatement.setDouble(3, productEntity.getFatsIn100Grams());
            preparedStatement.setDouble(4, productEntity.getCarbsIn100Grams());
            preparedStatement.setDouble(5, productEntity.getCaloriesIn100Grams());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                productEntity.setId(generatedKeys.getLong("id"));
            }
            return productEntity;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void update(ProductEntity productEntity) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, productEntity.getTitle());
            preparedStatement.setDouble(2, productEntity.getProteinIn100Grams());
            preparedStatement.setDouble(3, productEntity.getFatsIn100Grams());
            preparedStatement.setDouble(4, productEntity.getCarbsIn100Grams());
            preparedStatement.setDouble(5, productEntity.getCaloriesIn100Grams());
            preparedStatement.setLong(6, productEntity.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<ProductEntity> findAll(Filter filter) {
        List<Object> params = new ArrayList<>();
        List<String > whereSql = new ArrayList<>();
        if (filter.getTitle() != null){
            whereSql.add("title LIKE ?");
            params.add("%" + filter.getTitle() + "%");
        }
        params.add(filter.getLimit());
        params.add(filter.getOffset());
        String where = " LIMIT ? OFFSET ? ";
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
            List<ProductEntity> productEntityList = new ArrayList<>();
            while (resultSet.next()){
                productEntityList.add(buildProduct(resultSet));
            }
            return productEntityList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<ProductEntity> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<ProductEntity> productEntityList = new ArrayList<>();
            while (resultSet.next()) {
                productEntityList.add(buildProduct(resultSet));
            }
            return productEntityList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Optional<ProductEntity> findById(Long id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);) {
            preparedStatement.setLong(1, id);

            var resultSet = preparedStatement.executeQuery();
            ProductEntity productEntity = null;
            if (resultSet.next()) {
                productEntity = buildProduct(resultSet);
            }

            return Optional.ofNullable(productEntity);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private ProductEntity buildProduct(ResultSet resultSet) throws SQLException {
        return new ProductEntity(
                resultSet.getLong("id"),
                resultSet.getString("title"),
                resultSet.getDouble("protein_in_100_grams"),
                resultSet.getDouble("fats_in_100_grams"),
                resultSet.getDouble("carbs_in_100_grams"),
                resultSet.getDouble("calories_in_100_grams")
        );
    }


}
