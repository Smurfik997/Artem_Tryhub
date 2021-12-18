# D&T2021 Homework
## [Java Tasks](../../tree/Java_tasks)
To run java files you need to have Java.
For homework was used [JDK 16.0.1](https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html).

* if you have JDK 16.0.1 you can run .java files in two ways
  1. by double-clicking on them
  2. from console by using command `java filename.java`
* else you need to include files to your project, for example in IntelliJ IDEA

After run `.java` file follow the instructions, which will be displayed for every task.

## [WebUI (Selenium HomeTask)](../../tree/WebUI)
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
* Cucumber features are located [here](../../tree/WebUI/src/test/resources/features)
* Cucumber step definitions are [here](../../tree/WebUI/src/test/java/stepdefs)
* Example Selenium scenario without using Cucumber is [here](../../tree/WebUI/src/test/java/TestScenarioHardcoded.java)
* Page object files are located [here](../../tree/WebUI/src/main/java)

## [WebAPI HomeTask](../../tree/WebAPI)
### System specification used for hometask
* OS: Windows 11 Build 22000.376
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
* REST request builder files are [here](src/main/java/rest)
* DropBox API requests are [here](src/main/java/api)
* Images resources are located [here](src/test/resources/data_analytics_imgs)