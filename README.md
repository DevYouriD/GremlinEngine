# Welcome to the Gremlin Engine

This is the backend for the project.

Frontend: https://github.com/ketgjini/GremlinEngineFE

# General TODO
- [ ] Features
  - [x] Add Lombok
  - [ ] Add Swagger
  - [ ] Implement Continuous Integrations (CI) with GitHub Actions
  - [ ] Add ...
  - [ ] Add ...
  - [ ] Add ...

# Keycloak TODO
- [ ] Features
  - [x] Figure out how keycloak works
  - [x] Figure out how to implement
  - [x] Write configuration 
  - [ ] Figure out what (and what else) we can do with it
  - [ ] Enable Keycloak again
  - [ ] Write tests

- [x] I am done goal example
  - [x] I am done sub-goal example

# Roadmap
A roadmap that lays out a high level plan for the development process of the project can be found [here](./documentation/project_roadmap.md).

## Description
Tool to generate files (for example cv) based on user input.

## Index

* [Backend](#backend)
  * [Functional](#functional) 
    * [Login](#login)
    * [File generating](#file-generating)
    * [Downloadable content](#downloadable-content)
    * [Security](#security)
  * [Optimization](#optimization)
    * [Code Quality](#code-quality)

* [Frontend](#frontend)
    * [Design](#design)
    * [Angular Material](#angular-material)

* [Tools](#tools)

# Backend

## Functional

---

## API Instructions
### Example Curls
GET All Entities:
```bash
curl -X GET http://localhost:8080/api/get-all-cv
```

GET Entity by ID:
```bash
curl -X GET http://localhost:8080/api/get-cv/1
```

POST Entity:
```bash
curl -X POST http://localhost:8080/api/create-cv -H "Content-Type: application/json" -d "{\"firstName\": \"Ketrina\", \"lastName\": \"Gjini\"}"
```

DELETE Entity by ID:
```bash
curl -X DELETE http://localhost:8080/api/delete-cv/1
```

<br>

---

## Login
**Description:**  
Streams are a sequence of elements from a data source that supports functional-style operations to perform aggregate, filter, and transform operations declaratively.

### Keycloak

**Links:**  
[Link](https://www.google.com)

---

<br>

## File generating
**Description:**  
Streams are a sequence of elements from a data source that supports functional-style operations to perform aggregate, filter, and transform operations declaratively.

**Links:**  
[Link](https://www.google.com)

---

<br>

## Downloadable content
**Description:**  
Streams are a sequence of elements from a data source that supports functional-style operations to perform aggregate, filter, and transform operations declaratively.

**Links:**  
[Link](https://www.google.com)

---

<br>

## Security
**Description:**  
Streams are a sequence of elements from a data source that supports functional-style operations to perform aggregate, filter, and transform operations declaratively.

### 2 step verification

**Links:**  
[Link](https://www.google.com)

---

## Optimization

---

## Code Quality
**Description:**  
Streams are a sequence of elements from a data source that supports functional-style operations to perform aggregate, filter, and transform operations declaratively.

**Links:**  
[Link](https://www.google.com)

---

<br>

<!-- ==================================================================================================================================== -->

# Frontend

## Design
**Description:**  
Streams are a sequence of elements from a data source that supports functional-style operations to perform aggregate, filter, and transform operations declaratively.

**Links:**  
[Link](https://www.google.com)

---

## Angular Material
**Description:**  
Streams are a sequence of elements from a data source that supports functional-style operations to perform aggregate, filter, and transform operations declaratively.

**Links:**  
[Link](https://www.google.com)

---

<br>

<!-- ==================================================================================================================================== -->

# Tools
- [Trello](https://trello.com/b/NXEOcRJu/template-engine)
- Docker
- Jenkins / Gitlab / GitHub
- Hosting
- Dbeaver SQL/NOSQL?
- Figma
- Keycloak
- [PlantUML](https://plantuml.com/en-dark/) 
- Junit

# Git Strategy (Git Flow)
**Why Git Flow**  
We chose the Git Flow strategy because it is easy to use, easy to understand and fits perfect with 
the smaller scope of this project.

![image info](https://miro.medium.com/v2/resize:fit:1400/1*3-0EDzE63S_UZx2KbIz_dg.png)

# Example Project Structure
```text
src
├── main
│   ├── java
│   │   └── com.example.chatapp
│   │       ├── config
│   │       ├── controller
│   │       ├── model
│   │       ├── repository
│   │       ├── service
│   │       └── ChatApplication.java
│   ├── resources
│   │   ├── static
│   │   ├── templates
│   │   ├── application.properties
│   │   └── application-dev.properties
│   └── webapp
│       └── WEB-INF
│           └── thymeleaf
│               └── *.html
└── test
    └── java
        └── com.example.chatapp
            ├── controller
            ├── service
            └── ChatApplicationTests.java
```

<!-- CONTENT EXAMPLE 
*Title*
---------------------

**Description:**  
Content content content.

<br>

---

<br> -->

<!-- 

Architecture
    Design Patterns/ Software Patterns

Cloud
    AWS

 -->

![image info](https://img.freepik.com/free-vector/simple-vibing-cat-square-meme_742173-4493.jpg)
