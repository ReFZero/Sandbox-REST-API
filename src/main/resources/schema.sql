-- WAŻNE! KOLEJNOSC DODAWANIA I WYPEŁNIANIA MA ZNACZENIE.
-- MOZE DOJSC DO SYTUACJI GDZIE:
-- 1. NIE MOZNA USTAWIC OBCEGO KLUCZA(FK) PONIEWAZ TABELA NIE ISTNIEJE
-- 2. ZOSTAC NARUSZONA REGUŁA INTEGRALNOSCI

-- KLUCZE OBCE W RELACJACH
-- @OneToOne - po stronie Encji głównej
-- @OneToMany - po stronie Encji dodatkowej

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
    id              LONG        NOT NULL AUTO_INCREMENT,
    brand           VARCHAR(50) NOT NULL,
    production_year INT         NOT NULL,
    person_id       LONG        NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_car_person FOREIGN KEY (person_id) REFERENCES Person (id)
);


