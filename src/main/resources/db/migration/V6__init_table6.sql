CREATE TABLE IF NOT EXISTS "Замовлення" (
    id SERIAL PRIMARY KEY,
    "Створено" TIMESTAMP,
    "Оновлено" TIMESTAMP,
    "id_користувача" BIGINT REFERENCES "Користувачі"(id),
    "Сума" DECIMAL,
    "Адреса" VARCHAR(255),
    "Служба_доставки" VARCHAR(255),
    "Статус_замовлення" VARCHAR(255)
);
