CREATE DATABASE fresh_life;

CREATE TABLE IF NOT EXISTS users
(
    id           BIGSERIAL PRIMARY KEY,
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

CREATE TABLE IF NOT EXISTS product
(
    id                    BIGSERIAL PRIMARY KEY,
    title                 VARCHAR(128)  NOT NULL,
    protein_in_100_grams  NUMERIC(5, 2) DEFAULT 0.00,
    fats_in_100_grams     NUMERIC(5, 2) DEFAULT 0.00,
    carbs_in_100_grams    NUMERIC(5, 2) DEFAULT 0.00,
    calories_in_100_grams NUMERIC(5, 2) DEFAULT 0.00
    );

CREATE TABLE IF NOT EXISTS meal
(
    id         BIGSERIAL PRIMARY KEY,
    title_meal VARCHAR(128) UNIQUE NOT NULL
    );

CREATE TABLE IF NOT EXISTS meal_product
(
    id                 BIGSERIAL PRIMARY KEY,
    products_id        INT REFERENCES product (id),
    meals_id           INT REFERENCES meal (id),
    mass_of_ingredient NUMERIC(5, 2) DEFAULT 0.00
    );

CREATE TABLE IF NOT EXISTS program
(
    id    SERIAL PRIMARY KEY,
    title VARCHAR(128) UNIQUE NOT NULL
    );

CREATE TABLE IF NOT EXISTS day
(
    id          BIGSERIAL PRIMARY KEY,
    date        DATE NOT NULL ,
    users_id    INT REFERENCES users (id),
    programs_id INT REFERENCES program (id)
    );

CREATE TABLE IF NOT EXISTS day_meal
(
    id       BIGSERIAL PRIMARY KEY,
    days_id  INT REFERENCES day (id),
    meals_id INT REFERENCES meal (id)
    )

