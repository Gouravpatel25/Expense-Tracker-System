# Expense Tracker API

This repository contains a Spring Boot-based backend application for tracking financial transactions. It allows users to record incomes and expenses, categorize them, and view summaries over time. This project is designed to demonstrate REST API development, data persistence with H2, and basic service architecture.

---

## 📚 Table of Contents

1. [Project Overview](#1-project-overview)
2. [Key Features](#2-key-features)
3. [Technology Stack](#3-technology-stack)
4. [Prerequisites](#4-prerequisites)
5. [Getting Started](#5-getting-started)
    - [Cloning the Repository](#cloning-the-repository)
    - [Building the Project](#building-the-project)
    - [Running the Application](#running-the-application)
6. [Database Access (H2 Console)](#6-database-access-h2-console)
7. [API Endpoints](#7-api-endpoints)
8. [Project Structure](#8-project-structure)

---

## 1. Project Overview

This is a backend API for managing personal financial transactions. It supports adding, updating, deleting, and viewing transactions by category, date, and type. It also provides a financial summary that includes total income, expenses, and net balance.

---

## 2. Key Features

- ✅ Add new income or expense
- ✅ Filter transactions by:
  - Category
  - Date range
  - Type (INCOME / EXPENSE)
- ✅ Update or delete existing transactions
- ✅ View financial summary (total income, total expense, net balance)
- ✅ In-memory H2 database for development/testing

---

## 3. Technology Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database (In-Memory)**
- **Lombok**
- **Maven**

---

## 4. Prerequisites

Make sure the following are installed:

- Java 17+
- Maven 3.6+
- IDE (IntelliJ / Eclipse recommended with Lombok support)
- Postman (for testing APIs)

---

## 5. Getting Started

### Cloning the Repository

git clone https://github.com/your-username/expense-tracker-api.git
cd expense-tracker-api

🛠️ Building the Project
Make sure you have Maven installed.

🔧 To build the project:
mvn clean install
This command compiles your code, runs tests, and packages the application.

▶️ Running the Application
After building, you can start the application with:
mvn spring-boot:run

Once started, the application will be available at:
📍 http://localhost:8080

## 6. Database Access (H2 Console)
This project uses an in-memory H2 database, which resets on every restart.

🔑 Access the H2 web console at:
📍 http://localhost:8080/h2-console

Use the following settings:

JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: (leave blank)

💡 Tip: You can use the console to directly inspect the tables and test SQL queries.

## 7. API Endpoints📡
🧾 Transaction Endpoints
| Method | Endpoint                            | Description                                 |
| ------ | ----------------------------------- | ------------------------------------------- |
| POST   | /transactions/add                   | Add a new transaction                       |
| GET    | /transactions/all                   | Get all transactions                        |
| GET    | /transactions/category/{category}   | Get transactions by category                |
| GET    | /transactions/date/{start}/{end}    | Get transactions in a date range            |
| GET    | /transactions/type/{type}           | Get transactions by type (INCOME / EXPENSE) |
| PUT    | /transactions/update/{id}           | Update a transaction by ID                  |
| DELETE | /transactions/remove/{id}           | Delete a transaction by ID                  |
| GET    | /transactions/summary               | Get total income, expense, and net balance  |

✅ Use tools like Postman or curl to test these endpoints.

## 8. Project Structure
expense-tracker/
├── controller/         # REST API controllers
├── dto/                # Data Transfer Objects
├── model/              # JPA entities and enums
├── repository/         # Spring Data JPA repositories
├── service/            # Business logic layer
└── resources/
    └── application.properties  # Spring Boot configuration

📌 Notes
This is a backend-only project — no frontend is included yet.
The database is in-memory, so all data will be lost after restarting.
Make sure Lombok is installed and enabled in your IDE.
You can inspect data live using the H2 console.

🤝 Contribution
Contributions are welcome!
If you find bugs or have feature ideas:
Fork the repository
Create a new branch
Submit a Pull Request

📄 License
This project is licensed under the MIT License.
You are free to use, modify, and distribute it for personal or commercial purposes.

