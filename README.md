# Selenium Java Automation Framework

🚀 A scalable and modular test automation framework using **Java**, **Selenium**, **TestNG**, and **Page Object Model (POM)**.

---

## 🔧 Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model
- Extent Reports
- Apache POI (Excel)
- Logger

---
Key  Features: 
Page Object Model (POM)
Centralized Driver and Test Base
Retry Analyzer for flaky tests
Data-driven testing (Excel)
Custom Waits, Logging, Screenshot capture
TestNG Listener + Extent Reports

## 📁 Key Components

| Folder / File           | Purpose                                      |
|-------------------------|----------------------------------------------|
| `base/`                 | BasePage & BaseTest for setup/config         |
| `pages/`                | Page classes following POM                   |
| `factory/`              | Centralized Page Object manager              |
| `utils/`                | Reusable utilities (Wait, Screenshot, Retry) |
| `resources/`            | Config and test data                         |
| `listeners/`            | TestNG listener for reporting/logging        |
| `tests/`                | Test classes                                 |

---

## 🚀 How to Run

```bash
mvn clean test

FolderStructure:
selenium-Java/
├── .mvn/
├── reports/
│   └── ExtentReport.html
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   ├── BasePage.java
│   │   │   │   └── BaseTest.java
│   │   │   ├── factory/
│   │   │   │   └── PageFactoryManager.java
│   │   │   ├── pages/
│   │   │   │   ├── HomePage.java
│   │   │   │   └── LoginPage.java
│   │   │   └── utils/
│   │   │       ├── ConfigReader.java
│   │   │       ├── ExcelReader.java
│   │   │       ├── ExtentManager.java
│   │   │       ├── LoggerUtil.java
│   │   │       ├── RetryAnalyzer.java
│   │   │       ├── ScreenshotUtil.java
│   │   │       └── WaitUtil.java
│   └── resources/
│       ├── config.properties
│       └── testdata.xlsx
├── src/test/java/
│   ├── listeners/
│   │   └── TestListener.java
│   └── tests/
│       └── LoginTest.java
├── pom.xml
├── testng.xml
├── .gitignore
├── README.md




