# 🧪 Automated Web Testing Project (Cucumber + Selenium)

This project demonstrates automated UI testing using Java, Cucumber (BDD), and Selenium. It follows the Page Object Model design pattern and uses Maven as the build tool.

## 📂 Project Structure

```
src
├── test
│   └── java
│       ├── pages
│       ├── runners
│       ├── steps
|          └── hooks
│       └── utils
└── resources
    ├── features
    └── config.properties   
```

## 🚀 Technologies Used
 - Java 11+
 - Maven
 - Selenium WebDriver
 - Cucumber
 - JUnit
 - ChromeDriver

## ⚙️ How to Run

1. **Clone the repository:**
```bash
git clone https://github.com/Ovzmwil/AmazonHomeTest.git
cd AmazonHomeTest
```
2. **Run tests using Maven:**
```bash
mvn clean test -Dbrowser={browser}
```
3. **View the test report:**

After execution, a file named `cucumber-reports.html` will be generated in the project path `target/`, containing detailed test results.

## 📝 Notes
- The project uses Java 11, so it's necessary to have the JRE environment configured.
- The project runs with Apache Maven, so it's necessary to have Apache Maven configured.

