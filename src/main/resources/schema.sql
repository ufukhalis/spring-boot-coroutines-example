CREATE TABLE IF NOT EXISTS PERSON (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255),
    age INT,
    PRIMARY KEY (id)
);