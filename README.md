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
- SpringDoc Open API
- SpringFox Swagger UI
#### Zmiany w ostatnim commicie 
- Dodano stronicowanie - Paginacje
#### Dodatkowe informacje
- Podstawowe operacje GET, POST, PUT, DELETE
- Inicjalizacja bazy danych z pliku
- Zmiana endpointów na zgodne ze standardem
- Dodanie Swaggera
- Dodanie własnego wyjatku dotyczacego pobierania danych o osobach
- Dodanie Service do aplikacji
- Refaktoryzacja metod Controllera
- Zwiekszona liczba rekordów w bazie 
- ~~Metody komnikujace sie bezposrenio z Repozytorium zwracają ResponseEntity~~
- ~~Baza wypełniana jest przy użyciu @EventListener~~

#### TO DO

- Dodanie testów jednostkowych
- Dodanie metod np.PATH
- Dodanie metod hashCode() i equals() przy implementacji relacji i uzywaniu kolekcji w polach encji
- Dodanie relacji OneToOne
- Dodanie relacji OneToMany
- Dodanie relacji ManyToMany
- Dodanie DTO
