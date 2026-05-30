# ☕ Java Trainee REST API (CRUD Operations)

A secure and robust RESTful API built with Spring Boot to manage Java Trainee records. It implements complete CRUD (Create, Read, Update, Delete) operations, database persistence, secure endpoints, and interactive API documentation.

---

## 🚀 Features

* **Full CRUD Operations:** Create, retrieve, update, and delete Java Trainee records.
* **REST Endpoints:** Standard RESTful architecture with proper HTTP methods (GET, POST, PUT, DELETE) and JSON responses.
* **Interactive API Documentation:** Embedded **Swagger UI** for easy testing and documentation of all REST endpoints directly from the browser.
* **Role-Based Security:** Endpoints are secured using Spring Boot Security to prevent unauthorized access.
* **ORM Persistence:** Smooth database mapping and queries using Spring Data JPA and Hibernate.

---

## 🛠️ Tech Stack Used

* **Framework:** Spring Boot (Java)
* **API Documentation:** Swagger UI
* **Security:** Spring Boot Security
* **Data Access (ORM):** Spring Boot Data JPA & Hibernate
* **Database:** MySQL
* **IDE Used:** Eclipse IDE (with STS - Spring Tool Suite)

---

## 📁 How to Run the Project

### 1. Download the Project
* Click on the green **"Code"** button at the top right of this GitHub page.
* Select **"Download ZIP"** and extract the files on your computer.

### 2. Database Setup (MySQL)
* Open MySQL Workbench or MySQL Command Line Client
* Create a database named `javatrainee` (or the name used in your application properties).
* Open the `src/main/resources/application.properties` file in the project.
* Update your MySQL username and password:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
  spring.datasource.username=your_mysql_username
  spring.datasource.password=your_mysql_password
  spring.jpa.hibernate.ddl-auto=update
  ```

### 3. Import and Run in Eclipse
* Open **Eclipse IDE**.
* Go to **File** -> **Import...** -> Select **Maven** -> **Existing Maven Projects** and click **Next**.
* Browse and select your extracted project folder, then click **Finish**.
* Wait for Eclipse to download all Maven dependencies.
* Right-click on the project -> **Run As** -> **Spring Boot App** (or **Java Application** via the Main class).

### 4. Testing via Swagger UI (No Postman Required!)
* Once the application starts, open your web browser.
* Go to the Swagger URL (replace port if different):
  * **Swagger UI:** `http://localhost:8080/swagger-ui/index.html` (or `http://localhost:8080/swagger-ui.html` for older versions)
* You can visualize, interact, and test all the CRUD APIs directly from this page.
* *Note: Since Spring Security is enabled, make sure to click the **"Authorize"** button on the Swagger page and enter your configured Username and Password before testing the APIs.*

