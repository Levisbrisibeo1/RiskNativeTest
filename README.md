# Web Form Automation Framework

## 🚀 Overview
This project automates a sample web form from [Selenium's demo site](https://www.selenium.dev/selenium/web/web-form.html) using:

- Selenium WebDriver (UI Automation)
- Java
- Cucumber (BDD)
- JUnit
- Page Object Model (POM)
- REST Assured (for API Testing)
- Maven (build/test tool)

💡 Also includes API test integration using endpoints from [Free Public APIs](https://www.freepublicapis.com/).

## Project Structure
- `pages/` - Page Object classes for UI elements.
- `helpers/` - Utility/helper classes.
- `stepdefinitions/` - Step Definitions for Cucumber features.
- `features/` - Gherkin feature files.
- `runners/` - Cucumber runner classes.
- `tests/api/` - API tests.
- `reports/` - Generated reports.

## 🧪 How to Run Tests

### Run from IDE (Eclipse/IntelliJ)
1. Import the project.
2. Right-click `TestRunner.java` in the `runners/` package.
3. Select **Run As > JUnit Test**.

---

### ✅ Run from Maven CLI

#### Step 1: Ensure `chromedriver.exe` is present at src/test/resources/ChromeDriver/chromedriver.exe

#### Step 2: Open terminal in project root and run:

mvn clean test

This will:

Launch Chrome

Fill and submit the form

Assert the confirmation message

Close the browser

Print summary to terminal

API Testing
API tests are located in:src/test/java/tests/api/
These use REST Assured and target public APIs from https://www.freepublicapis.com.

You can run them the same way (mvn test) or individually from your IDE.

## Reporting
After test execution:

HTML report is generated in the reports/ folder.

You can open report.html in a browser to view detailed test output.

## Requirements
- Java 11+
- Maven
- ChromeDriver in system PATH
