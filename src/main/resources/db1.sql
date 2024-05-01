DROP TABLE IF EXISTS mytest1;

CREATE TABLE mytest1 (
                      id varchar(255) NOT NULL,
                      title varchar(255) NOT NULL,
                      slug varchar(255) NOT NULL,
                      date date NOT NULL,
                      time_to_read int NOT NULL,
                      tags varchar(255),
                      PRIMARY KEY (id)
);

INSERT INTO mytest1
(id, title, slug, date, time_to_read, tags)
VALUES (1,'Hello, World!','hello-world',CURRENT_DATE, 5, 'Spring Boot, Java');