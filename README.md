# retail-crm
It is the development branch of this project, all changes should be committed on this branch at first


OS: Windows

Java Environment: JRE 7

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
1. Download/Install Postgres http://www.postgresql.org/download/

2. Create a new database with name "Test" in user "postgres". If you want give another database name or user name, don't forget change the spring configurations in all relevant module.
for example:
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
<property name="driverClassName" value="org.postgresql.Driver"/>
<property name="url" value="jdbc:postgresql://localhost:5432/Test"/> <!--Here,you should give another specified database name-->
<property name="username" value="postgres"/> <!--Here,you should give another specified user name-->
<property name="password" value="bjy1986717"/> <!--Here,you should give another specified password-->
</bean>
3. open the psql console
it is only a example, you can give your configuration parameters which you have defined in the procedure of database installation.
server: localhost
database: Test
port: 5432
username: postgres
password: bjy1986717

4. for DB initialization.
start db process master:
pg_ctl -D "{db data directory}" -o "-p {port}" -l {logdirectory}/log start
access the data base table:
psql -p {port} {table name}

Note: you need to create your schema in order to create the tables.
run the sql scripts under the retail-crm-services/src/main/resources/sql
for example
4a: \i 'D:/workspace/retail-crm/retail-crm-services/src/main/resources/sql/create_db.sql'
4b: \i 'D:/workspace/retail-crm/retail-crm-services/src/main/resources/sql/data/init_data.sql'
for cleaning database you can user
4c: \i 'D:/workspace/retail-crm/retail-crm-services/src/main/resources/sql/drop_tables.sql'


===============================================================================================================
Port Configuration

Web:8080
Web Service:9090
DataBase:5432
