# retail-crm
It is the development branch of this porject, all changes should be commited on this branch at first


OS: Windows
 
Java Enviroment: JRE 7
 
DataBase: Postgres 9.3 (pgAdmin)
 
WebServer: Tomcat 7
 
Documentation Tool: Maven
 
IDE: Eclipse Version: Kepler Service Release 2 (Intellij?)
 
Version Controller: Git
 
Repository: Github
 
================================================================================================================
Using libraries and architecture:
Standard Provider
Container --> Spring framework
Java Bean(Object) Mapping --> Dozer(?)
Web Service --> JAX-RS Jersey
Persistence --> JPA Hibernate
DataBase --> Ansi SQL(pg/Sql) Postgres
Frontend --> Html5 Css Bootstrap, Angularjs UI, etc...
MVC --> javascript Angularjs
Test --> Unit Test JUnit
Log --> n/a
 
======================================================================================================================
Create DataBase:
1. Install Postgres
 
2. Create a new database with name "Test" in user "postgres". If you want give another database name or user name, don't forget change the spring configurations in all relevant module.
for example:
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
<property name="driverClassName" value="org.postgresql.Driver"/>
<property name="url" value="jdbc:postgresql://localhost:5432/Test"/> <!--Here,you should give another specified database name-->
<property name="username" value="postgres"/> <!--Here,you should give another specified user name-->
<property name="password" value="bjy1986717"/> <!--Here,you should give another specified password-->
</bean>

3.create a schema named "dbo" under Test 

4. open the psql console
it is only a example, you can give your configuration parameters which you have defined in the procedure of database installation.
server: localhost
database: Test
port: 5432
username: postgres
password: bjy1986717
 
5. run the sql scripts under the retail-crm-services/src/main/resources/sql
for example
5a: \i 'D:/workspace/retail-crm/retail-crm-services/src/main/resources/sql/create_db.sql'
5b: \i 'D:/workspace/retail-crm/retail-crm-services/src/main/resources/sql/data/init_data.sql'
for cleaning database you can user
5c: \i 'D:/workspace/retail-crm/retail-crm-services/src/main/resources/sql/drop_tables.sql'
 
 
===============================================================================================================
Port Configuration
 
Web:8080
Web Service:9090
DataBase:5432 
