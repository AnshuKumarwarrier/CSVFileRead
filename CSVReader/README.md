
# Spring Boot Order Processing Application

A brief description of what this project does and who it's for


## Documentation



This is a Spring Boot application that processes a CSV file containing orders, splits them by country based on the client phone number, and stores them in a database.
## ## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Maven
## ## CSV File Format
The CSV file should have the following columns:
- id
- email
- phone_number
- parcel_weight
## ## Country Determination
The country is determined based on the client phone number using regular expressions (regex). Here are the regex patterns for each country:

- Cameroon:
    - Country code: +237
    - Regex pattern: \(237\)\ ?[2368]\d{7,8}$

- Ethiopia:
    - Country code: +251
    - Regex pattern: \(251\)\ ?[1-59]\d{8}$

- Morocco:
    - Country code: +212
    - Regex pattern: \(212\)\ ?[5-9]\d{8}$

- Mozambique:
    - Country code: +258
    - Regex pattern: \(258\)\ ?[28]\d{7,8}$

- Uganda:
    - Country code: +256
    - Regex pattern: \(256\)\ ?\d{9}$
## ## How to Run
1. Clone this repository.
2. Set up your database configuration in `application.properties`.
3. Build the project using Maven: `mvn clean install`.
4. Run the application: `mvn spring-boot:run`.
5. Access the application at `http://localhost:9083`.
## ## API Endpoints
- POST `/import`
    - Parameters:
        - `file`: CSV file containing the orders to import.
    - Description: Imports orders from the CSV file and saves them in the database.
    - Response:
        - 200 OK: Orders imported successfully.
        - 500 Internal Server Error: Error importing orders.

- GET `/orders`
    - Description: Retrieves all orders from the database.

##  ## Exception Handling
The application handles exceptions related to importing orders from the CSV
## ## Unit Tests
Unit tests are provided for the `OrderService` class using Mockito and JUnit.

To run the unit tests, use the following command: `mvn test`.