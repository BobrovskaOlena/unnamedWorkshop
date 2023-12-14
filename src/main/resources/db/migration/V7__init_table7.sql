CREATE TABLE IF NOT EXISTS "Вироби" (
    id SERIAL PRIMARY KEY,
    "Назва_товару" VARCHAR(255) NOT NULL,
    "Фото" VARCHAR(255),
    "Опис" VARCHAR(1000) NOT NULL,
    "Ціна_виробу" DECIMAL NOT NULL,
    "Необхідні_матеріали" VARCHAR(255),
    "Артикль_матеріалу" VARCHAR(255),
    "Кількість_матеріалу" BIGINT
);
