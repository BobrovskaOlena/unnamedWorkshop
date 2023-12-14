CREATE TABLE IF NOT EXISTS Категорії_матеріалів (
    id SERIAL PRIMARY KEY,
    Назва_категорії_матеріалів VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS категорії_матеріалів_seq;

CREATE TABLE IF NOT EXISTS Матеріали_для_виробів (
    id SERIAL PRIMARY KEY,
    Назва_матеріалу VARCHAR(255) NOT NULL,
    Кількість_матеріалу VARCHAR(255),
    Чи_є_в_наявності BOOLEAN NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS матеріали_seq;

CREATE TABLE IF NOT EXISTS Матеріали_по_категоріям (
    id_матеріалу BIGINT REFERENCES Матеріали_для_виробів(id),
    id_категорії BIGINT REFERENCES Категорії_матеріалів(id),
    PRIMARY KEY (id_матеріалу, id_категорії)
);

CREATE TABLE IF NOT EXISTS Кошик (
    id SERIAL PRIMARY KEY,
    id_користувача BIGINT REFERENCES Користувачі(id)
);

CREATE SEQUENCE IF NOT EXISTS кошик_seq;

CREATE TABLE IF NOT EXISTS Деталі_замовлення (
    id SERIAL PRIMARY KEY,
    id_замовлення BIGINT REFERENCES Замовлення(id),
    id_продукта BIGINT REFERENCES Продукти(id),
    Кількість INTEGER,
    Ціна INTEGER
);

CREATE SEQUENCE IF NOT EXISTS деталі_seq;

CREATE TABLE IF NOT EXISTS Замовлення (
    id SERIAL PRIMARY KEY,
    Створено TIMESTAMP,
    Оновлено TIMESTAMP,
    id_користувача BIGINT REFERENCES Користувачі(id),
    Сума INTEGER,
    Адреса VARCHAR(255),
    Служба_доставки VARCHAR(255),
    Статус_замовлення VARCHAR(255)
);

CREATE SEQUENCE IF NOT EXISTS замовлення_seq;

CREATE TABLE IF NOT EXISTS Категорія_виробу (
    id SERIAL PRIMARY KEY,
    Назва_категорії_виробу VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS категорія_seq;

CREATE TABLE IF NOT EXISTS Вироби (
    id SERIAL PRIMARY KEY,
    Назва_товару VARCHAR(255) NOT NULL,
    Фото VARCHAR(255) NOT NULL,
    Опис VARCHAR(1000) NOT NULL,
    Ціна_виробу DECIMAL(19, 2) NOT NULL,
    Необхідні_матеріали VARCHAR(255),
    Артикль_матеріалу VARCHAR(255),
    Кількість_матеріалу DOUBLE,
    CONSTRAINT обмеження_ціни CHECK (Ціна_виробу >= 0),
    CONSTRAINT обмеження_кількості CHECK (Кількість_матеріалу >= 0)
);

CREATE SEQUENCE IF NOT EXISTS вироби_seq;

CREATE TABLE IF NOT EXISTS категорії_виробів (
    вироби_id BIGINT REFERENCES Вироби(id),
    категорія_id BIGINT REFERENCES Категорія_виробу(id),
    PRIMARY KEY (вироби_id, категорія_id)
);