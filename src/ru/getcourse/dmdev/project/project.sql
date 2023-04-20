CREATE DATABASE fresh_life;

CREATE TABLE IF NOT EXISTS component
(
    id                    SERIAL PRIMARY KEY,
    title                 VARCHAR(128)  NOT NULL,
    protein_in_100_grams  NUMERIC(5, 2) NOT NULL,
    fats_in_100_grams     NUMERIC(5, 2) NOT NULL,
    carbs_in_100_grams    NUMERIC(5, 2) NOT NULL,
    calories_in_100_grams NUMERIC(5, 2) NOT NULL
    );

CREATE TABLE IF NOT EXISTS meal
(
    id                  SERIAL PRIMARY KEY,
    title_meal          VARCHAR(128) UNIQUE NOT NULL,
--     ingredient1_id      INT REFERENCES component (id),
    mass_of_ingredient1 NUMERIC(5, 2),
--     ingredient2_id      INT REFERENCES component (id),
    mass_of_ingredient2 NUMERIC(5, 2),
--     ingredient3_id      INT REFERENCES component (id),
    mass_of_ingredient3 NUMERIC(5, 2)
    );

CREATE TABLE IF NOT EXISTS meal_component
(
    component_id INT REFERENCES component (id),
    meal_id      INT REFERENCES meal (id)

    );

CREATE TABLE IF NOT EXISTS diary
(
    id    SERIAL PRIMARY KEY,
    date  DATE,
    meal1 VARCHAR(128) REFERENCES meal (title_meal),
    meal2 VARCHAR(128) REFERENCES meal (title_meal),
    meal3 VARCHAR(128) REFERENCES meal (title_meal),
    meal4 VARCHAR(128) REFERENCES meal (title_meal),
    meal5 VARCHAR(128) REFERENCES meal (title_meal)
    );

CREATE TABLE IF NOT EXISTS program
(
    id    SERIAL PRIMARY KEY,
    title VARCHAR(128) UNIQUE NOT NULL
    );

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
    role         VARCHAR(8) UNIQUE   NOT NULL,
    id_program   INT REFERENCES program (id),
    id_diary     INT REFERENCES diary (id),
    id_meal      INT REFERENCES meal (id)
    );
