# JobPortal Backend Application

## Overview
The **JobPortal Backend Application** is a Java-based RESTful API developed using **Spring Boot**, **Hibernate**, **JPA**, and **MySQL**. It provides a robust backend for managing job postings with features like adding, viewing, updating, deleting, searching, and securing resources with **Spring Security** and **real-time authentication**. It also includes an **Aspect-Oriented Programming (AOP)** module for enhanced modularity and cross-cutting concerns like logging.

## Features
- **Add Job**: Create a new job post with detailed information.
- **View Job**: Retrieve all jobs or specific job details.
- **Update Job**: Modify existing job details.
- **Delete Job**: Remove a job post from the database.
- **Search by Word**: Search for jobs using keywords in job descriptions or titles.
- **Spring Security Integration**:
  - Resource access restricted to authorized users.
  - Passwords stored securely using **bcrypt hashing**.
  - Real-time authentication to ensure secure access.
- **AOP Integration**:
  - Centralized logging for API calls and method executions.
  - Simplifies tracking and debugging.

## Technology Stack
- **Backend**: Java, Spring Boot, Hibernate, JPA
- **Database**: MySQL
- **Authentication**: Spring Security, BCryptPasswordEncoder
- **Cross-Cutting Concerns**: Spring AOP
- **Development Tools**: IntelliJ IDEA, Maven, Postman (for API testing)

## Prerequisites
Before running the application, ensure the following:
1. **Java Development Kit (JDK)** version 8 or later is installed.
2. **MySQL** server is running with an accessible database.
3. **Maven** is installed and configured.


