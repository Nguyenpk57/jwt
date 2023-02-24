# 1. how it works

The application uses technologies and lombox

![image](https://user-images.githubusercontent.com/10681453/221156796-f593e537-0b8e-4105-af9c-cd58495d4eb4.png)


    + config/
        Add config about spring security, Auditing for Db, and enable WebMvcConfig
    + controller/
        Spring controllers
    + exception/
        Exceptions by the application
    + model/
        JPA models
    + payload/
        Object for REST in/out operations
    + repository/
        + specification/
            Some specifications for JPA
        Spring repositories
    + security/
        using jwt to generate jwt key and validate jwt from request
    + service/
        Spring services


**1. DB**

**1.1. Init Db**

```sql
create database jwtdb;
CREATE USER 'jwtuser'@'%' identified by 'jwtpass';
grant all privileges on jwtdb.* to jwtuser@'%';
flush privileges;

```

**1.2 insert role **

```sql
INSERT IGNORE INTO roles(name) VALUES('ROLE_USER');
INSERT IGNORE INTO roles(name) VALUES('ROLE_ADMIN');
```

**1.3. DB diagram**


![image](https://user-images.githubusercontent.com/10681453/221155093-aadcf26f-f03c-466f-9d35-2caace7786ff.png)


**2. Run the app**

You can run the spring boot app by typing the following command -

```bash
mvn spring-boot:run
```

The server will start on port 8080.

You can also package the application in the form of a `jar` file and then run it like so -

```bash
mvn package
```

**3. api**

**3.1. api/auth/signup**

- REQUEST

```json
{
"name": "nguyenpk1",
"username":"nguyenk1",
"email":"nguyenpk1@gmail.com",
"password":"Secret1"
}
```

- RESPONSE

```json
{
"success": true,
"message": "User registered successfully"
}
```

**3.2. api/auth/signin**

- REQUEST

```json
{
"usernameOrEmail": "nguyenk",
"password":"Secret"
}
```
  - RESPONSE

```json
{
"accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjc3MjMyMjU2LCJleHAiOjE2Nzc4MzcwNTZ9.kpfbb8mHLJeSAnRcwS4VfDhlEgdor1-bIfcCheoS92C0plGfKNJm5K4PYTUFQFwVbz3JOg4ctcfK8MLRgI2oxw",
"tokenType": "Bearer"
}
```
