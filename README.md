## WebUI (Selenium HomeTask)
### System specification used for hometask
* OS: Windows 11 Build 22000.348
* Browser: Chrome 96.0.4664.93 64-bit
* Selenium browser driver: 96.0.4664.45
* Java: JDK 16.0.1
* Maven version: 3.8.4
* Allure version: 2.17.1
* IDE: IntelliJ IDEA Community 2021.1.3

### Run project possible in two ways
1. Using command from console `mvn clean test` 
2. Run from your IDE all project starting from file `src/test/java/TestRunner.java`

To see allure report use command `allure serve target/allure-results`

**NOTE**: for use all of mentioned commands you should be at root directory with project files

### Additional
* Cucumber features are located [here](src/test/resources/features)
* Cucumber step definitions are [here](src/test/java/stepdefs)
* Example Selenium scenario without using Cucumber is [here](src/test/java/TestScenarioHardcoded.java)
* Page object files are located [here](src/main/java)
