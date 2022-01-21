FROM gradle:7.3.3-jdk11-alpine AS build
WORKDIR /usr/src/gradle
COPY --chown=gradle:gradle . .
RUN gradle clean bootJar --no-daemon -x test

FROM adoptopenjdk/openjdk11:alpine AS dev
LABEL maintainer="gabrielmbarboza"
WORKDIR /usr/src/app
COPY --from=build /usr/src/gradle/build/libs/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
