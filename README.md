# E-Commerce Test Automation Framework

This framework is crafted to automate an eCommerce web application utilizing **Selenium WebDriver**, **Java**, and a **hybrid approach** that merges **Data-Driven Testing** with **Cucumber BDD**. It employs the **Page Object Model (POM)** to enhance test maintainability and scalability.

## Getting Started

### Prerequisites

Before you begin setting up the project, make sure you have the following installed:

- **Java 8 or later**
- **Selenium WebDriver**
- **TestNG**
- **ExtentReports (extentreporterng)**
- **Jenkins** (optional, for CI/CD automation)

## Why Use This Framework?

- **Scalability & Maintainability** – Implements the Page Object Model to minimize code duplication and ease updates.
- **Readable & Structured** – Utilizes Cucumber BDD to create test cases in plain English.
- **Reusable Components** – Offers modular functions for more straightforward test development.

## Setup & Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/dbohara88/E-CommerceAutomation.git
   ```

2. Change to the project directory:

   ```sh
   cd E-CommerceAutomation
   ```

3. Install dependencies and build the project:

   ```sh
   mvn clean install
   ```

## Test Reports

Once the tests are executed, a **detailed HTML report** is generated using **Extent Reports**. This report, located in the `reports` folder, offers insights into test execution, logs, and screenshots (if applicable).

## License

This project is licensed under the [MIT License](LICENSE).

## Author

Deepak Bohara

---
