# Spring Security JWT
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.3-green)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-6.2.2-brightgreen)](https://spring.io/projects/spring-security)
[![JWT](https://img.shields.io/badge/JWT-JSON%20Web%20Token-orange)](https://jwt.io/)
[![License: GPL-3.0](https://img.shields.io/badge/License-GPL%203.0-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

This repository contains an example of authentication and access control using Spring Security and JWT (JSON Web Token). It provides customized authentication using a MySQL database instead of Spring Security's default user management.

## Features
 - Secure API access using Spring Security
 - Authentication and access control with JWT
 - User management using MySQL database
 - Example of user login and token-based authorization

How To Run
---------------

1. Clone this repository:

```bash
git clone git@github.com:emrtnm/spring-security-jwt.git
```

2. Open project settings and select BellSoft Liberica 17 SDK (Recommended).

3. Make your MySQL database connection settings by opening the `application.properties` file:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. Change your secret key in `application.properties` file (Optional):

```bash
security.jwt.token.secret-key=d32d53896a4e21855aeb0efaa23c4b5ab0721a6e23702d5eb549332d9e913d14
```

5. Open terminal in your project folder

6. Run this command

```bash
mvn spring-boot:run
```

6. Go to http://localhost:8080 from your browser.

7. You should see this message:

```json
{
  "message": "Unauthorized path"
}
```

## How To Test

1. **Open Postman:** Open the Postman application.
2. **Import File:** Click on the "File" tab in the top menu.
3. **Click on Import:** Select the "Import" option.
4. **Choose File to Import:** Click on "Upload Files" and select the `collection.json` file located in the main directory. Then click "Open" or "Choose" to import the file.
5. **Collection Created:** After importing the file, a collection named "Spring Security JWT API" will be created.
6. **Enjoy:** You can now use the newly created collection in Postman to manage your requests and test your API.

## File Structure
```bash
├── README.md
├── collection.json
├── pom.xml
── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── emrtnm
    │   │           └── jwt
    │   │               ├── Application.java
    │   │               ├── config
    │   │               │   ├── JwtAuthFilter.java
    │   │               │   ├── PasswordConfig.java
    │   │               │   ├── RestExceptionHandler.java
    │   │               │   ├── SecurityConfig.java
    │   │               │   └── UserAuthenticationEntryPoint.java
    │   │               ├── controller
    │   │               │   ├── AuthController.java
    │   │               │   └── HomeController.java
    │   │               ├── dto
    │   │               │   ├── CredentialsDto.java
    │   │               │   ├── ErrorDto.java
    │   │               │   ├── SignUpDto.java
    │   │               │   ├── UserDto.java
    │   │               │   └── UserResponse.java
    │   │               ├── entity
    │   │               │   └── User.java
    │   │               ├── enums
    │   │               │   └── Role.java
    │   │               ├── exception
    │   │               │   └── AppException.java
    │   │               ├── mapper
    │   │               │   └── UserMapper.java
    │   │               ├── repository
    │   │               │   └── UserRepository.java
    │   │               └── service
    │   │                   └── UserService.java
    │   └── resources
    │       └── application.properties
    └── test
        └── java
            └── com
                └── emrtnm
                    └── jwt
                        └── ApplicationTests.java


```

## License

This project is open-sourced software licensed under the [GPL-3.0 license](https://www.gnu.org/licenses/gpl-3.0).


### Make A Contribution!
If you think that anything here could be improved, please don't hesitate to contribute. Anyone who wants to, regardless of their ability, skill, or background, can contribute to this project. All contributions are made for the benefit of the community. Thanks very much for helping this repository become much more suitable for its purpose and more useful to a larger number of people.

**#java** **#spring** **#jwt** **#security** **#springsecurity** **#springboot** **#springframework**
**#auth** **#jsonwebtoken** **#springsecurityjwt**
