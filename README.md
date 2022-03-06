# Spring Boot study on projects

### This project was split into Backend and Frontend, where both parts work in isolation using Docker.

## Technologies

### Support

- Docker
- docker-compose

### Backend

- Java 11
- SpringBoot 2.6.3
- Gradle

### Frontend

- HTML
- CSS
- Vuejs
- Nodejs/npm

### Test

- JUnit
- Jacoco ( Code coverage )

## Usage

> :warning: **The following commands must be run in the project root**

### Running only the siegen API

`docker-compose up siegen_api`

> 0.0.0.0:8080

### Running with the siegen web app

`git submodule init && git submodule update`  
`docker-compose up`

> 0.0.0.0:8081
