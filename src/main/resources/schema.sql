-- WAŻNE! KOLEJNOSC DODAWANIA I WYPEŁNIANIA MA ZNACZENIE.
-- MOZE DOJSC DO SYTUACJI GDZIE:
-- 1. NIE MOZNA USTAWIC OBCEGO KLUCZA(FK) PONIEWAZ TABELA NIE ISTNIEJE
-- 2. ZOSTAC NARUSZONA REGUŁA INTEGRALNOSCI

-- KLUCZE OBCE W RELACJACH
-- @OneToOne - po stronie Encji głównej
-- @OneToMany - po stronie Encji dodatkowej
-- @ManyToMany - w dodatkowe tabeli gdzie 2 kolumny reprezentuja PK oraz FK
CREATE TABLE Interest
(
    id            LONG AUTO_INCREMENT,
    interest_type VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE Address
(
    id     LONG         NOT NULL AUTO_INCREMENT,
    city   VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Person
(
    id         LONG         NOT NULL AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    age        INT          NOT NULL,
    address_id LONG         NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_address_person FOREIGN KEY (address_id) REFERENCES Address (id)
);

CREATE TABLE Car
(
    id              LONG AUTO_INCREMENT,
    brand           VARCHAR(50),
    production_year INT,
    person_id       LONG,
    PRIMARY KEY (id),
    CONSTRAINT fk_car_person FOREIGN KEY (person_id) REFERENCES Person (id)
);

CREATE TABLE Person_Interest
(
    person_id   LONG,
    interest_id LONG,
    PRIMARY KEY (person_id, interest_id),
    CONSTRAINT fk_person_interest FOREIGN KEY (person_id) REFERENCES Person (id),
    CONSTRAINT fk_interest_person FOREIGN KEY (interest_id) REFERENCES Interest (id)
);




