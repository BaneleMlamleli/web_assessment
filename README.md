# Ndosi Test Automation

This is Java Selenium Framework that automates [Ndosi Test Automation](https://gray-island-0bd788c1e.2.azurestaticapps.net/#overview), a small e-commerce website. My aim is to try and create a robust, maintainable, and scalable Selenium framework that implements real world project concepts, standards and technologies

## Tech-stack for the project

- ![Java 21](./src/main/java/com/ndosi/icons/java.png) Java 21
- ![Maven](./src/main/java/com/ndosi/icons/Maven.png) Maven
- ![Selenium 4](./src/main/java/com/ndosi/icons/Selenium.png) Selenium 4
- ![TestNG](./src/main/java/com/ndosi/icons/TestNG.png) TestNG
- ![ExtentReports](./src/main/java/com/ndosi/icons/ExtentReports.png) ExtentReports
- ![Log4J](./src/main/java/com/ndosi/icons/Log4J.png) Log4J
- ![Git-flow](./src/main/java/com/ndosi/icons/git.png) Git

## Project Structure

I implemented the page object model design pattern, where all the tests are separated in their own pages

- Java - Contains all the different packages required for the framework
- extentReports - This package contains classes to create and customize the extent extentReports
- pagesObjects - This package contains classes for different pages in a project
- tests - this package contains all the tests classes
- utils - this package contains all the re-usable classes
- resources - this package will contain files such as config files, data files, etc

## Reporting

- The reports will be saved under the folder 'reports'
- To open the report - you have to launch it with a browser of your choice. Options will be available on the report

## Execution

There are three ways one can run this project

- You can run it directly at a test class level not individual methods, by clicking the play button
- Run from testng.xml with the command **mvn test -DsuiteXmlFile=testng.xml**
- Run using maven command **mvn test**
