CREATE SEQUENCE IF NOT EXISTS "користувач_seq";
CREATE SEQUENCE IF NOT EXISTS "деталі_seq";
CREATE SEQUENCE IF NOT EXISTS "замовлення_seq";
CREATE SEQUENCE IF NOT EXISTS "категорія_seq";
CREATE SEQUENCE IF NOT EXISTS "вироби_seq";
CREATE SEQUENCE IF NOT EXISTS "кошик_seq";

CREATE TABLE IF NOT EXISTS "Користувачі" (
    id SERIAL PRIMARY KEY,
    "Створено" TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "Оновлено" TIMESTAMP,
    "Логін" VARCHAR(255) NOT NULL,
    "Email" VARCHAR(255),
    "Пароль" VARCHAR(255) NOT NULL,
    "Прізвище" VARCHAR(255),
    "Ім'я" VARCHAR(255),
    "По-батькові" VARCHAR(255),
    "Дата_народження" DATE,
    "Телефон" VARCHAR(255),
    "Місто" VARCHAR(255),
    "Поштовий_індекс" VARCHAR(255),
    "Служба_доставки" VARCHAR(255),
    "Відділення" VARCHAR(255),
    "Архівовано" BOOLEAN,
    "Роль" VARCHAR(255),
    "кошик_id" BIGINT
);

CREATE TABLE IF NOT EXISTS "Кошик" (
    id SERIAL PRIMARY KEY,
    "id_користувача" BIGINT REFERENCES "Користувачі"(id)
);
