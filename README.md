[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

# School Management System Backend

A **Spring Boot REST API** for managing schools, students, and their profiles. Built with **Java 17**, **Spring Boot 3**, **Spring Data JPA**, and **PostgreSQL** (configurable). Includes DTO mapping, service-layer architecture, and sample tests.

---

## ✨ Features

* CRUD operations for **Schools** and **Students**
* DTO-based request/response models
* Entity-to-DTO mapping with **MapStruct**
* Service/Repository layered architecture
* Exception handling with meaningful error messages
* Unit and integration tests (JUnit 5)
* Postman collection for easy API testing

---

## 🧱 Tech Stack

* **Java 17**
* **Spring Boot 3**
* **Spring Web**
* **Spring Data JPA**
* **MapStruct**
* **PostgreSQL** (or H2 for in-memory)
* **Lombok**
* **JUnit 5**, **Mockito**

---

## 📁 Project Structure

```
School-Backend-master/
├─ src/main/java/com/alibou/example1/
│  ├─ school/          # School entity, DTO, controller, service, repository
│  ├─ student/         # Student entity, DTO, controller, service, repository
│  ├─ studentprofile/  # StudentProfile entity
│  └─ Example1Application.java
├─ src/main/resources/
│  └─ application.yml  # Spring Boot config
├─ src/test/java/com/alibou/example1/  # Unit & integration tests
├─ postman/collections/  # Postman collection JSON
├─ pom.xml
└─ README.md
```

---

## 🚀 Getting Started

### Prerequisites

* Java 17+
* Maven 3.9+
* PostgreSQL (or use H2 for in-memory testing)

### Environment Variables / Config (`application.yml`)

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/schooldb
    username: postgres
    password: password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### Run Locally

```bash
# Clone the repo
git clone <repo-url>
cd School-Backend-master

# Build and run
./mvnw spring-boot:run
```

The app runs at: `http://localhost:8080`

---

## 📜 API Endpoints

Base URL: `http://localhost:8080/api/v1`

### Schools

| Method | Endpoint      | Description         |
| ------ | ------------- | ------------------- |
| GET    | /schools      | List all schools    |
| GET    | /schools/{id} | Get school by ID    |
| POST   | /schools      | Create a new school |
| PUT    | /schools/{id} | Update school       |
| DELETE | /schools/{id} | Delete school       |

**Example Create School**

```json
POST /api/v1/schools
{
  "name": "Springfield High",
  "email": "info@springfield.edu",
  "address": "742 Evergreen Terrace"
}
```

### Students

| Method | Endpoint       | Description          |
| ------ | -------------- | -------------------- |
| GET    | /students      | List all students    |
| GET    | /students/{id} | Get student by ID    |
| POST   | /students      | Create a new student |
| PUT    | /students/{id} | Update student       |
| DELETE | /students/{id} | Delete student       |

**Example Create Student**

```json
POST /api/v1/students
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "schoolId": 1
}
```

---

## 🧪 Testing

```bash
./mvnw test
```

Includes:

* Mapper tests (`StudentMapperTest`)
* Service tests (`StudentServiceTest`)
* Application context load test

---

## 📂 Postman Collection

A ready-to-use Postman collection is available in:

```
postman/collections/<collection-name>.json
```

Import it into Postman to quickly test the API.

---

## 🐳 Docker (Optional)

**Dockerfile** example:

```dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
```

**Build & Run**

```bash
docker build -t school-api .
docker run -p 8080:8080 school-api
```

---

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/foo`)
3. Commit your changes (`git commit -m 'Add foo'`)
4. Push to the branch (`git push origin feature/foo`)
5. Open a Pull Request

---

## 📄 License

MIT License

Copyright (c) 2025 Devatva Rachit

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
