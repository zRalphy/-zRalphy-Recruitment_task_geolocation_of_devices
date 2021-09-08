# REST Currency Converter

## Opis 
Usługa REST umożliwiająca odbieranie, zapisywanie i usuwanie informacji o pozycjach (geolokalizacji) z urządzeń mobilnych np. telefon/lokalizator GPS. 

Parametry:
- id
- deviceId – numer urządzenia
- latitiude – współrzędna szerokość geograficzna
- longitude – wspórzędna długość geograficzna

## Technologie
Technologie i biblioteki wykorzystane przy budowie aplikacji:
- JAVA
- Spring Boot
- Hibernate
- Swagger
- Loombook
- Cache
- Liquibase
- Maven
- jUnit
- H2Database

## Budowanie i uruchamianie aplikacji
### 
Aby zbudować aplikację w katalogu projektu w konsoli należy wpisać polecenie:

`mvn install`

Po pomyślnym przejściu całego procesu budowania projektu w folder /target powinien Ci się pojawić plik z roszerzenie JAR.

Można go uruchomić wszędzie, wystarczy, że jest tam zainstalowany JRE. Należy wpisać polecenie:

`java -jar .jar`

## Dostępne serwisy REST
### GET GEOLOCATIONS
Ścieżka: `/geolocations/`

Przykładowe zapytanie:

'http://localhost:8080/geolocations/'


### GET SINGLEGEOLOCATION
Ścieżka: `/geolocations/{geolocationId}`

Przykładowe zapytanie:

'http://localhost:8080/geolocations/1'


### POST
Ścieżka: `/geolocations/`

Przykładowe zapytanie:
'http://localhost:8080/geolocations'

POST ADDGEOLOCATION
{
	"deviceId": 211124,
  	"id": 10,
	"latitiude": 234677,
	"longitude": 123466
}


### DELETE GEOLOCATION
Ścieżka: `/geolocations/{geolocationId}`

Przykładowe zapytanie:
'http://localhost:8080/geolocations/1'
```
