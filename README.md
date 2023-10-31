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
- Refaktoryzacja kodu
  - Usuniecie adnotacji Column (automatyczna zamiana camelCase na sneak_case) oraz Table 
  - Usuniecie metod - repository.save(obj) (mechanizm Dirty Checking. W sytuacji gdy pobrano obiekt z bazy i Hibernate wie o nim)
#### Dodatkowe informacje:
- Podstawowe operacje GET, POST, PUT, DELETE
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
- Dodanie testów jednostkowych
- Dodanie relacji ManyToMany (bidirectional)
- Dodanie DTO

   