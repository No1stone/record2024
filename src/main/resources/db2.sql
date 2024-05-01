DROP TABLE IF EXISTS mytest2;

CREATE TABLE mytest2 (
                            id int NOT NULL,
                            name varchar(255) NOT NULL,
                            email varchar(255) NOT NULL,
                            PRIMARY KEY (id)
);

INSERT INTO mytest2
(id, name, email) values ( 1, 'Dan Vega', 'danvega@gmaillcom' )