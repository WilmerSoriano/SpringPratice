#We are having SpringBoot look for schema and data using a special applicatio.properties
DROP TABLE IF EXISTS widgets;

CREATE TABLE widgets (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name TEXT,
    purpose TEXT,
    PRIMARY KEY (id)
);