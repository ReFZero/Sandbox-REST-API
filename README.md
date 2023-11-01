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
- JUnit 5
#### Zmiany w ostatnim commicie:
- Dodano Buildery
- Dodano proste testy jednostkowe
#### Dodatkowe informacje:
- Podstawowe operacje GET, POST, PUT, DELETE, PATCH
- Inicjalizacja bazy danych z pliku
- Endpointy zgodne ze standardem
- Dodano Lombok
- Dodano Swagger
- Dodano relacje OneToOne - bidirectional(Person <-> Address)
- Dodano relacje OneToMany - bidirectional(Person <-> Car)
- Dodano relacje ManyToMany unidirectional(Person -> Interest)
- Dodano plik tekstowy PreRequestScriptPostman w którym znajduja sie skrypty do Postmana
- Dodano Query Methods (wyszukiwanie samochodów po id osoby)

#### TO DO:
- Uzycie Mockito
- Dodanie relacji ManyToMany (bidirectional)
- Dodanie DTO

   