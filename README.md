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
