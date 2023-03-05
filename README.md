# Technologies Use
1. Java 17
2. Spring Boot Version 3.0.2
3. Docker
4. Keycloak

---

## Introduction
The application is using the **modular monolith** architecture it means all the code is powering a single but is seperated using different modules

---

---

### Steps
- Download the maven dependencies
```maven
mvn clean install
```
- Using the terminal and navigate the docker folder
```cmd
cd .\docker\
```
- Download all the containers to run keycloak and postgres database
```docker
docker-compose --env-file .\env_file.env up
```
- Remove all the container
```docker
docker-compose down
```

---

### Swagger
- Get access to the swagger ui
http://localhost:8080/swagger-ui/index.html

## Links
1. keycloak
    - [Keycloak and Spring Boot Security](https://medium.com/@max.mayr/keycloak-and-spring-boot-security-b069306b0fb0)
    - [Spring Boot 2 + keycloak](https://www.baeldung.com/spring-boot-keycloak)
    - [Forgot Password baeldung](https://www.baeldung.com/spring-security-registration-i-forgot-my-password)
    - [Forgot Password](https://systemweakness.com/setting-up-keycloak-and-securing-spring-boot-rest-apis-1765a85f5ac4)