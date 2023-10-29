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
- Dodano relacje OneToOne bidirectional(Person <-> Address)
- Dodano Repository, Service, Controller oraz wyjatek dla encji Address
#### Dodatkowe informacje:
- Podstawowe operacje GET, POST, PUT, DELETE
- Inicjalizacja bazy danych z pliku
- Endpointy zgodne ze standardem
- Dodano Lombok
- Dodano Swagger
- Dodano relacje OneToMany - bidirectional(Person <-> Car)
- Dodano plik tekstowy PreRequestScriptPostman w którym znajduja sie skrypty do Postmana
- Dodano Query Methods (wyszukiwanie samochodów po id osoby)
- ~~Dodano relacje OneToOne - unidirectional(Person -> Address)~~

#### TO DO:
- Dodanie testów jednostkowych
- Dodanie metod np.PATH
- Dodanie relacji ManyToMany (unidirectional & bidirectional)
- Dodanie DTO

   