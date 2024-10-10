# API Automation - ReqRes

This project is an API test automation using the **Rest Assured** library to perform HTTP requests and validate responses from the public API available at [ReqRes](https://reqres.in/).

## Technologies Used

- **Java**: The programming language used.
- **Maven**: Dependency manager and build system.
- **Rest Assured**: A library to facilitate API testing.
- **JUnit**: A testing framework to run automated tests.

## How to Run the Project

### Prerequisites

- Java 11 or higher
- Maven

### Cloning the Repository

1. Clone this repository using the command:

   ```bash
   git clone https://github.com/lucasengelmann/reqres-api-automation.git

2. Navigate to the project directory:

cd reqres-api-automation

3. Make sure Maven is installed on your machine. You can verify this by running:

mvn -v

4. In the project directory, run the command to install dependencies:
mvn clean install

5. To run the tests, use the following command:
mvn test
