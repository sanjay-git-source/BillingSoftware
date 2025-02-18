# Supermarket Billing Software

## Description
This is a Java-based billing software for supermarkets, designed with a GUI and integrated with Microsoft SQL Server for data management. The software allows for itemized billing, inventory tracking, and generating receipts.

## Features
- User-friendly GUI
- Product management (add, update, delete items)
- Billing system with automatic total calculation
- Integration with MSSQL Server
- Sales report generation

## Technologies Used
- **Programming Language**: Java (Swing/JavaFX for GUI)
- **Database**: Microsoft SQL Server
- **IDE**: NetBeans / Eclipse / IntelliJ IDEA

## Prerequisites
1. Install Java Development Kit (JDK 8 or higher)
2. Install Microsoft SQL Server and SQL Server Management Studio (SSMS)
3. Set up the required database and tables

## Installation and Setup
### 1. Clone the Repository
```sh
git clone https://github.com/sanjay-git-source/supermarket-billing-software.git
cd supermarket-billing-software
```

### 2. Configure Database
- Create a database in MSSQL Server
- Run the provided SQL script (`db_setup.sql`) to create tables
- Update database connection details in the Java code (e.g., `DBConnection.java`)

### 3. Compile and Run
Using Command Line:
```sh
javac -cp .;mssql-jdbc.jar Main.java
java -cp .;mssql-jdbc.jar Main
```

Using an IDE:
- Open the project in your IDE
- Ensure the JDBC driver is added to the project
- Run `Main.java`

## Database Schema
Refer to `db_schema.sql` for table structure.

## Usage
1. Launch the application.
2. Login using default credentials (can be changed in the database).
3. Add products, generate bills, and track sales.

## Contributing
Feel free to fork the project and submit pull requests.

## License
This project is licensed under the MIT License.

