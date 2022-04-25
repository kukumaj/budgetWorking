DROP DATABASE IF EXISTS budget;
CREATE DATABASE budget CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci;
USE budget;

CREATE TABLE budget_item (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             description VARCHAR(255) NOT NULL,
                             value DECIMAL(10,2) NOT NULL,
                             type ENUM('INCOME', 'EXPENSE') NOT NULL
);
CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       area_code    VARCHAR(3) NOT NULL,
                       phone_number VARCHAR(10) NOT NULL,
                       first_name   VARCHAR(20) NOT NULL,
                       last_name    VARCHAR(20),
                       birth_date   DATE,
                       password     VARCHAR(256)
);
