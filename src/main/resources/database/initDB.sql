CREATE TABLE IF NOT EXISTS products
(
    id    BIGSERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    description VARCHAR(654) NOT NULL ,
    price INTEGER  NOT NULL,
    image VARCHAR(900)
);

CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    balance INTEGER
);