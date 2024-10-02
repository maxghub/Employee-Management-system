# Employee-Management-system

## Project Description

In this project, I used **Spring Boot**, **Spring Data JPA**, **Spring MVC**,spring security and **Thymeleaf** for the frontend. For the database, I used **MySQL**.

### Features:
- **Two types of users:**
  - **Admin Login**: Admin users have additional functionality like adding, editing, and deleting employee details, managing total salary, and tracking attendance and salary based on department.
  - **Normal User Login**: Normal users can register, log in, and view employee details.
  
- **Admin Credentials**: 
  - By default, when a user registers, their role is set to `ROLE_USER`. To give admin access, update the user's role in the database from `ROLE_USER` to `ROLE_ADMIN`.

This project offers secure user management with different levels of access, depending on the user's role.
