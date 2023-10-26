CREATE TABLE Person(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100)NOT NULL,
    age INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Car(
    id LONG NOT NULL AUTO_INCREMENT,
    brand VARCHAR(50) NOT NULL,
    production_year INT NOT NULL,
    person_id INT NOT NULL,
    PRIMARY KEY (id),
   CONSTRAINT fk_car_person FOREIGN KEY (person_id) REFERENCES Person(id)
);
