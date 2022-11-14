# SauceDemoProject
Automation of Sauce Demo login-Assignment

#Prerequistic to run the project 
- Java JDK and Eclipse should be installed
- Git hub account should be available

# Steps to import the project 
- Open  Eclipse
- Copy the Github link of this project 
- In eclipse, from open perspective select 'Git Repository'
- Now, select the option 'Clone existing repository'
- Provide the Git hub URL :https://github.com/simist/RiseSauceDemoProject.git 
- Provide your Github login details 
- Select master branch and click Finish 
- Once the above steps are completed, the project will be available in your local repository 
- Again, from the local repository the project needs to be extracted to eclipse
- Click on File >> Import >> Project from Git
- Select the project from existing local repository and select the project and click finish 

# Steps to run the project
- Once the project is extracted, open RiseSauceDemoProject>>src/test/java
- The files will be available in two packages
- To run project: Open saucetest package>> SauceDemoTest.java
  -  To enter input paramters username and password: edit the method  lp.getUser( "username", "password");
- Right click and select run as TestNG Test



