
# Architectural or high level decisions
This file describes the architectural decisions we made during the development of the application.

## Backend and frontend frameworks (Spring Boot / Angular)
### Spring Boot
We decided to choose Spring Boot for a few reasons. Apart from wanting to learn more about it there are a few advantages
we considered. 
#### 1. **Fast Development**
- Spring Boot speeds up development through **starter dependencies** and **auto-configuration**. 
Starter dependencies simplify adding common features (like web, data, and security), while auto-configuration sets up these features based on the project’s dependencies, saving setup time.
- It offers a ready-to-go server (usually Tomcat or Jetty) built into the app. We can just run our app as a standalone Java application, 
which makes testing and deployment faster.

#### 2. **Flexible and Scalable**
- Spring Boot's modular nature makes it well-suited for microservices, which require components to be easily deployable, maintainable, and scalable.

#### 3. **Rich Ecosystem and Community Support**
- Spring Boot builds on the Spring Framework, providing us access to a huge ecosystem of tools and libraries (data management, security, messaging, etc.) that can be easily integrated.
- It has extensive documentation and an active community, so finding tutorials, solutions, and discussions is relatively easy.

#### 4. **Simplified Configuration and DevOps**
- Spring Boot simplifies managing multiple environments (e.g., dev, test, prod) with externalized configuration. This makes it easier to manage settings and secrets securely.
- It also offers metrics and health checks which are essential for a reliable prod environment.

#### 5. **Good Support for Databases and APIs**
- Spring Data JPA (also accompanied by Hibernate) makes working with databases easier by providing abstractions for data repositories.
- Thanks to REST controllers it simplifies REST API creation, and integrates smoothly with tools like Swagger for documentation.

### Angular
We made the choice to couple Spring Boot with Angular to have clear separation of concerns, resulting in a clean architecture that’s easier to maintain and extend.
#### 1. **Component-Based Architecture**
- Since Angular has a component-based structure, it allows us to build reusable UI elements, which leads to a more organized, maintainable, and scalable codebase.
- Each component can be developed, tested, and maintained independently.

#### 2. **Strong Typing with TypeScript**
- Angular is built with TypeScript, a superset of JavaScript, which introduces static typing. 
This reduces runtime errors and makes code easier to understand and maintain.
- TypeScript’s features, like interfaces and enums, make it easier to manage applications especially when the backend is built on Java, so the similarities make it easier to understand.

#### 3. **Built-In Testing Support**
- Protractor, Angular's built-in e2e testing tool, allows us to write end-to-end tests that simulate user interactions, ensuring the application works as intended.

#### 4. **Scalability and Maintainability**
- Angular’s architecture is designed for large applications, with a well-defined structure that separates concerns.
- Its DI framework promotes modular and testable code, making it easier to scale and maintain our application as it grows.

#### 5. **Clear Documentation and Learning Resources**
- Angular has extensive & understandable documentation, tutorials, and learning resources that make it easier to learn and troubleshoot.
- This is particularly valuable for us since we're just getting started with it and have no previous experience.


## Database (SQL / NoSql)
We discussed whether we had to use SQL or NoSQL for this project. At the end we came to the conclusion that an SQL database would be more 
suitable for our use-case. It efficiently handles structured, relational data—like user profiles, work history, and education. 
SQL databases support complex queries and data integrity constraints (which we will need to do), which ensure that data remains consistent and reliable across multiple entries.
It also integrates seamlessly with Spring Boot via JPA and Hibernate, making database interactions straightforward and programmatic which is easier for us to develop.
Additionally, SQL databases offer robust security, backup options, and scalability to manage growing user data while maintaining performance.

## Identity and access management (login and privileges)


## Generating the PDFs in the front or back-end.
Placing CV generation in the backend is often preferred due to better control over formatting, 
enhanced data privacy, and more consistent performance. Backend generation also supports 
complex layouts and error handling, which can be challenging for frontend libraries.
