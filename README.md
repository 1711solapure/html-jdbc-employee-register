# html-jdbc-employee-register
This repository hosts a web application for employee registration built using HTML and Java with JDBC (Java Database Connectivity)and Servlet. The employee registration form allows HR personnel or administrators to input and store essential employee details such as name, contact information, department, and more in a secure database.

# MySQL 
1.Create schema(Database) employeedb 
2.Table name is employee_jsp1
3.Containing columns (int) id, (varchar) name,(BigInt) phone,(varchar) address,(varchar) email,(varchar )password

# Steps to create repository
1.Create new maven project (does not select simple project) click next
2.filter: org.apache.maven (let it load the versions)
3.select artifact id as “maven-archetype-webapp” version 1.4 click next
4.group id is your comapy name
5. Artifact id is your project name click on finish
6.after open project and at last there will be file call pom.xml 
7. add this dependencies  in dependencies tag

</dependency>
  <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
</dependency>
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>

  </dependencies>

8..java files should be in java resources in src/main/java
9.web.xml file paste it in src->main->WEB-INF
10.And .html files should in folder src->main->WEB-INF below web.xml

