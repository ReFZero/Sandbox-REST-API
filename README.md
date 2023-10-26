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
- Dodanie Service do aplikacji
- Refaktoryzacja metod Controllera
- Zwiekszona liczba rekordów w bazie (Przygotowanie do stronicowania - Pagination)
#### Dodatkowe informacje
- Podstawowe operacje GET, POST, PUT, DELETE
- Inicjalizacja bazy danych z pliku
- Zmiana endpointów na zgodne ze standardem
- Dodanie Swaggera
- Dodanie własnego wyjatku dotyczacego pobierania danych o osobach
- ~~Metody komnikujace sie bezposrenio z Repozytorium zwracają ResponseEntity~~
- ~~Baza wypełniana jest przy użyciu @EventListener~~

#### TO DO

- Dodanie stronicowania
- Dodanie testów jednostkowych
- Dodanie metod np.PATH
- Dodanie relacji OneToOne
- Dodanie relacji OneToMany
- Dodanie relacji ManyToMany
- Dodanie DTO
