# 1. how it works

**1.1. The application uses some technologies and lombox**

![image](https://user-images.githubusercontent.com/10681453/221156796-f593e537-0b8e-4105-af9c-cd58495d4eb4.png)

**1.2. Packages in project** 

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

**1.3. The working mechanism is as follows**

When logging into the system, the system will generate a token and send it to the client

Each request then the client needs to attach the token to the header and send it back to the backend verify

A JWT will consist of 3 headers, payload and signature, separated by a "."

JWT will hascode header + payload and compare with signature

In the doFilterInternal method you may not need to query the Db, but will get all the UserDetails information in the jwt

**1.4. Some important classes**

- SecurityConfig

- JwtAuthenticationFilter

- JwtTokenProvider


# 2. DB

**2.1. Init Db**

```sql
create database jwtdb;
CREATE USER 'jwtuser'@'%' identified by 'jwtpass';
grant all privileges on jwtdb.* to jwtuser@'%';
flush privileges;

```

**2.2 insert role**

```sql
INSERT IGNORE INTO roles(name) VALUES('ROLE_USER');
INSERT IGNORE INTO roles(name) VALUES('ROLE_ADMIN');
```

**2.3. DB diagram**


![image](https://user-images.githubusercontent.com/10681453/221155093-aadcf26f-f03c-466f-9d35-2caace7786ff.png)


# 3. Run the app

You can run the spring boot app by typing the following command -

```bash
mvn spring-boot:run
```

The server will start on port 8080.

You can also package the application in the form of a `jar` file and then run it like so -

```bash
mvn package
```

# 4. api

**4.1. api/auth/signup**

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

**4.2. api/auth/signin**

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

**4.3. api/user/me**

- REQUEST

```json

Authorization - BearerToken: user token when login success
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjc3MjMyMjU2LCJleHAiOjE2Nzc4MzcwNTZ9.kpfbb8mHLJeSAnRcwS4VfDhlEgdor1-bIfcCheoS92C0plGfKNJm5K4PYTUFQFwVbz3JOg4ctcfK8MLRgI2oxw

```
- RESPONSE

```json

{
    "id": 1,
    "username": "nguyenk",
    "name": "nguyenpk"
}

```
