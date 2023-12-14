CREATE TABLE IF NOT EXISTS "категорії_виробів" (
    "вироби_id" BIGINT REFERENCES "Вироби"(id),
    "категорія_id" BIGINT REFERENCES "Категорія_виробу"(id),
    PRIMARY KEY ("вироби_id", "категорія_id")
);

