# spring-data-jpa-experiments

Experiments learning Spring Data JPA, with dockerized MySQL database.



### Available scripts 

To start up the local MySQL docker container, run:

`docker-compose up`

Build the starter app and execute tests by running: 

`./gradlew clean test`

When it is running, you can connect to the database with the following:
```
Database=mydb
Username=demouser
Password=demopassword
Port=3306
```