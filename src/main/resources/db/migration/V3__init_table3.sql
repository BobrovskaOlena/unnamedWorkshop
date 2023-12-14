CREATE TABLE IF NOT EXISTS "Матеріали_по_категоріям" (
    "id_матеріалу" BIGINT REFERENCES "Матеріали_для_виробів"(id),
    "id_категорії" BIGINT REFERENCES "Категорії_матеріалів"(id),
    PRIMARY KEY ("id_матеріалу", "id_категорії")
);

