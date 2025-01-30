DROP TABLE IF EXISTS url_checks;
DROP TABLE IF EXISTS urls;

CREATE TABLE urls (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(255),
    created_at timestamp
);

CREATE TABLE url_checks (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    url_id BIGINT REFERENCES urls(id),
    status_code INT,
    h1 varchar(255),
    title varchar(255),
    description text,
    created_at timestamp
);