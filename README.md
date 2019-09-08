# starter-spring-jpa-mysql

Dockerized starter project for running Spring JPA on MySQL

## Building and running the app 

Build the starter app by running: 

`./gradlew clean build`

To start up your local development environment, run:

`docker-compose up`

Run the data migrations in the /migrations folder of the project to create the database entities:

`./gradlew flywayMigrate`