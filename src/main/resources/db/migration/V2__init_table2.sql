CREATE TABLE IF NOT EXISTS "Матеріали_для_виробів" (
    id SERIAL PRIMARY KEY,
    "Назва_матеріалу" VARCHAR(255) NOT NULL,
    "Кількість_матеріалу" BIGINT,
    "Чи_є_в_наявності" BOOLEAN NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS "матеріали_seq";