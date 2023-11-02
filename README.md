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
- Mockito
#### Zmiany w ostatnim commicie:
- Dodano Mockito
#### Dodatkowe informacje:
- Podstawowe operacje GET, POST, PUT, DELETE, PATCH
- Inicjalizacja bazy danych z pliku
- Endpointy zgodne ze standardem
- Dodano Lombok
- Dodano Swagger
- Dodano Buildery
- Dodano proste testy jednostkowe
- Dodano relacje OneToOne - bidirectional(Person <-> Address)
- Dodano relacje OneToMany - bidirectional(Person <-> Car)
- Dodano relacje ManyToMany unidirectional(Person -> Interest)
- Dodano plik tekstowy PreRequestScriptPostman w którym znajduja sie skrypty do Postmana
#### TO DO:
- Dodanie relacji ManyToMany (bidirectional)
- Dodanie DTO

   