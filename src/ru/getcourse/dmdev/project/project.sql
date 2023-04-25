CREATE DATABASE fresh_life;

CREATE TABLE IF NOT EXISTS users
(
    id           SERIAL PRIMARY KEY,
    first_name   VARCHAR(128)        NOT NULL,
    last_name    VARCHAR(128)        NOT NULL,
    age          INT                 NOT NULL,
    weight       NUMERIC(5, 2)       NOT NULL,
    gender       VARCHAR(12)         NOT NULL,
    email        VARCHAR(128) UNIQUE NOT NULL,
    phone_number NUMERIC(11) UNIQUE  NOT NULL,
    password     VARCHAR(32) UNIQUE  NOT NULL,
    role         VARCHAR(8)          NOT NULL
    );

CREATE TABLE IF NOT EXISTS products
(
    id                    SERIAL PRIMARY KEY,
    title                 VARCHAR(128)  NOT NULL,
    protein_in_100_grams  NUMERIC(5, 2) NOT NULL,
    fats_in_100_grams     NUMERIC(5, 2) NOT NULL,
    carbs_in_100_grams    NUMERIC(5, 2) NOT NULL,
    calories_in_100_grams NUMERIC(5, 2) NOT NULL
    );

CREATE TABLE IF NOT EXISTS meals
(
    id         SERIAL PRIMARY KEY,
    title_meal VARCHAR(128) UNIQUE NOT NULL
    --     Это пока оставил)
--     mass_of_ingredient1 NUMERIC(5, 2),
--     mass_of_ingredient2 NUMERIC(5, 2),
--     mass_of_ingredient3 NUMERIC(5, 2)
    );

CREATE TABLE IF NOT EXISTS meals_products
(
    id          SERIAL PRIMARY KEY,
    products_id INT REFERENCES products (id),
    meals_id    INT REFERENCES meals (id)
    );

CREATE TABLE IF NOT EXISTS programs
(
    id    SERIAL PRIMARY KEY,
    title VARCHAR(128) UNIQUE NOT NULL
    );

CREATE TABLE IF NOT EXISTS days
(
    id          SERIAL PRIMARY KEY,
    date        DATE,
    users_id    INT REFERENCES users (id),
    programs_id INT REFERENCES programs (id)
    );

CREATE TABLE IF NOT EXISTS days_meals
(
    id       SERIAL PRIMARY KEY,
    days_id  INT REFERENCES days (id),
    meals_id INT REFERENCES meals (id)
    )




