CREATE TABLE IF NOT EXISTS "Деталі_замовлення" (
    id SERIAL PRIMARY KEY,
    "id_замовлення" BIGINT REFERENCES "Замовлення"(id),
    "id_продукта" BIGINT REFERENCES "Вироби"(id),
    "Кількість" BIGINT,
    "Ціна" DECIMAL
);