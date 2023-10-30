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
- Dodano relacje ManyToMany unidirectional(Person -> Interest)
- Aktualizacja struktury Bazy danych
#### Dodatkowe informacje:
- Podstawowe operacje GET, POST, PUT, DELETE
- Inicjalizacja bazy danych z pliku
- Endpointy zgodne ze standardem
- Dodano Lombok
- Dodano Swagger
- Dodano relacje OneToOne - bidirectional(Person <-> Address)
- Dodano relacje OneToMany - bidirectional(Person <-> Car)
- Dodano plik tekstowy PreRequestScriptPostman w którym znajduja sie skrypty do Postmana
- Dodano Query Methods (wyszukiwanie samochodów po id osoby)

#### TO DO:
- Refaktoryzacja kodu
  - Usuniecie adnotacji Column (automatyczna zamiana camelCase na sneak_case) oraz Table
  - Usuniecie metod - repository.save(obj) (mechanizm Dirty Checking. W sytuacji gdy pobrano obiekt z bazy i Hibernate wie o nim)
- Dodanie testów jednostkowych
- Dodanie metod np.PATH
- Dodanie relacji ManyToMany (bidirectional)
- Dodanie DTO

   