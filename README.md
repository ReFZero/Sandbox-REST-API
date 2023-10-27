# REST API
Aplikacja umożliwiająca podstawowe operacje CRUD
## Info:
- Spring Boot 3.1.5
- Java 17
- Maven
### Dependencje:
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- SpringDoc Open API
- SpringFox Swagger UI
#### Zmiany w ostatnim commicie:
- Dodano Service i Controller dla encji Car
- Dodano wyjatek dla encji Car
- Dodano plik tekstowy PreRequestScriptPostman w którym znajduja sie skrypty do Postmana
#### Dodatkowe informacje:
- Podstawowe operacje GET, POST, PUT, DELETE
- Inicjalizacja bazy danych z pliku
- Endpointy zgodne ze standardem
- Dodano Lombok
- Dodano Swagger
- Zwiekszona liczba rekordów w bazie 
- Dodano relacje OneToMany - unidirectional(Person -> Car)
- ~~Dodanie własnego wyjatku dotyczacego pobierania danych o osobach~~
- ~~Dodanie Service do aplikacji~~
- ~~Refaktoryzacja metod Controllera~~
- ~~Dodano Encje Car~~
- ~~Dodanie metod hashCode() i equals()~~
- ~~Metody komnikujace sie bezposrenio z Repozytorium zwracają ResponseEntity~~
- ~~Baza wypełniana jest przy użyciu @EventListener~~

#### TO DO:

- Dodanie testów jednostkowych
- Dodanie metod np.PATH
- Dodanie relacji OneToOne (unidirectional & bidirectional)
- Dodanie relacji OneToMany (bidirectional)
- Dodanie relacji ManyToMany (unidirectional & bidirectional)
- Dodanie DTO
