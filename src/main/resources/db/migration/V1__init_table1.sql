CREATE TABLE IF NOT EXISTS "Категорії_матеріалів" (
    id SERIAL PRIMARY KEY,
    "Назва_категорії_матеріалів" VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS "категорії_матеріалів_seq";

