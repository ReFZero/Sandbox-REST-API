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
- Dodano relacje OneToOne - unidirectional(Person -> Address)
#### Dodatkowe informacje:
- Podstawowe operacje GET, POST, PUT, DELETE
- Inicjalizacja bazy danych z pliku
- Endpointy zgodne ze standardem
- Dodano Lombok
- Dodano Swagger
- Dodano relacje OneToMany - bidirectional(Person <-> Car)
- Dodano plik tekstowy PreRequestScriptPostman w którym znajduja sie skrypty do Postmana
- Dodano Query Methods (wyszukiwanie samochodów po id osoby)

#### TO DO:
- Dodanie testów jednostkowych
- Dodanie metod np.PATH
- Dodanie relacji OneToOne (bidirectional)
- Dodanie relacji ManyToMany (unidirectional & bidirectional)
- Dodanie DTO

   