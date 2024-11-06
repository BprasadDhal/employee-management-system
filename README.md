# Employee Management System

This is a basic Employee Management System developed as a web application using **Spring Boot** and **Thymeleaf**. It allows an admin to perform essential operations like adding, viewing, editing, and deleting employee records. The project includes a simple authentication feature and a contact form.

## Features

- **Authentication**: User login is required to access pages for managing employee records.
- **Employee Operations**:
  - **Add Employee**: Add new employee records.
  - **View Employee**: View all employee records.
  - **Edit Employee**: Edit details of existing employees.
  - **Delete Employee**: Delete employee records.
- **Contact Form**: A form to submit messages, sent via email to the admin.

## Project Structure

- **Controller** (`EmpController.java`): Manages the routing and interactions between views and the service layer.
- **Service** (`EmpService.java`): Contains business logic for employee operations and authentication.
- **Repository** (`EmpRepository.java`): Interface for interacting with the database.
- **Entity** (`Employee.java`, `Login.java`): Represents data structure for Employee and Login details.

## Database Configuration

The application uses a `login` table for authentication, with at least the following fields:

- `username` (VARCHAR) – Username of the user.
- `password` (VARCHAR) – Password of the user.

### Sample SQL for Creating `login` Table

```sql
CREATE TABLE login (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Insert initial admin credentials
INSERT INTO login (username, password) VALUES ('admin', 'admin123');
```

Update the database connection settings in `application.properties` and ensure the login credentials exist in the `login` table before testing the login functionality.

## Technologies Used

- **Java & Spring Boot**: For building the backend logic.
- **Thymeleaf**: For dynamic HTML templates.
- **Spring Data JPA**: For database access and management.
- **JavaMailSender**: For sending contact form messages via email.

## Setup Instructions

1. **Database Configuration**: Update the database connection settings in `application.properties`.
2. **Run Application**: Start the application using an IDE or with `mvn spring-boot:run`.
3. **Access**: Open `http://localhost:8080` in a web browser.

## Usage

1. **Login**: Use the login page to enter your credentials.
2. **Manage Employees**: After logging in, access pages to add, view, edit, or delete employees.
3. **Logout**: Click the logout button to end your session.
