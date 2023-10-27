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
- Dodano relacje OneToMany - bidirectional(Person <-> Car)
#### Dodatkowe informacje:
- Podstawowe operacje GET, POST, PUT, DELETE
- Inicjalizacja bazy danych z pliku
- Endpointy zgodne ze standardem
- Dodano Lombok
- Dodano Swagger
- Dodano plik tekstowy PreRequestScriptPostman w którym znajduja sie skrypty do Postmana
- ~~Dodano relacje OneToMany - unidirectional(Person -> Car)~~

#### TO DO:
- Dodanie testów jednostkowych
- Dodanie metod np.PATH
- Dodanie relacji OneToOne (unidirectional & bidirectional)
- Dodanie relacji ManyToMany (unidirectional & bidirectional)
- Dodanie DTO
