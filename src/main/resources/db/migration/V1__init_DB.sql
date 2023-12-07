CREATE TABLE IF NOT EXISTS "Категорії_матеріалів" (
    id SERIAL PRIMARY KEY,
    "Назва_категорії_матеріалів" VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS категорії_матеріалів_seq;

CREATE TABLE IF NOT EXISTS "Матеріали для виробів" (
    id SERIAL PRIMARY KEY,
    "Назва матеріалу" VARCHAR(255) NOT NULL,
    "Кількість матеріалу" VARCHAR(255),
    "Чи є в наявності" BOOLEAN NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS матеріали_seq;

CREATE TABLE IF NOT EXISTS "Матеріали_по_категоріям" (
    id_матеріалу BIGINT REFERENCES "Матеріали для виробів"(id),
    id_категорії BIGINT REFERENCES "Категорії_матеріалів"(id),
    PRIMARY KEY (id_матеріалу, id_категорії)
);

