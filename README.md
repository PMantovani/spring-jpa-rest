# Spring, Data Manipulation and REST API Challenge

### Introduction
This is a programming challenge in Spring, Data Manipulation and REST APIs developed by Pedro Mantovani Antunes.

It uses Spring Boot Data with JPA to provide an interface to the in-memory database H2, to fetch and create data in two related tables: City and Country. These tables can be manipulated in an (almost) RESTful way through webservices endpoints, as explained below. The tables are initialy populated through the db script presented src/main/resources/data.sql, and defined through the schema at /src/main/resources/schema.sql.

The project contains a main Application class (SpringJpaRestApplication.java), two RestController classes (CountryController.java and CityController.java), two POJO classes (City.java and Country.java) and two CrudRepository to talk to the database (CityRepository.java and CountryRepository.java). The project is build with Gradle.

### How to run 
Build the gradle project with the command:

    ./gradlew build

Or if you are in Windows:

    gradlew build

Run the Spring application jar with

    java -jar build/libs/spring-jpa-rest.jar

### GET Requests

Open a browser and type in the following endpoint

    http://localhost:8080/rest/cities?country=Uni

That will give you the list of cities (pre-populated) filtered by the countries that contain the letters 'Uni'. This is case-sensitive.

There is also an endpoint for retrieving all of the countries (no filter available):

    http://localhost:8080/rest/countries
    
### POST Requests

You can add new cities and countries to the in-memory H2 database. To do so, use a POST request to the same endpoints above passing a JSON.

Example of adding a country:

    curl --header "Content-Type: application/json" --request POST --data '{"name":"Argentina"}' http://localhost:8080/rest/countries

Example of adding a city:

    curl --header "Content-Type: application/json" --request POST --data '{"name":"Quatro Barras", "country":{"id":1}}' http://localhost:8080/rest/cities
    
### Tests

There are unit tests and integration tests at spring-jpa-rest/src/test/java/com/mantovani/springjparest
