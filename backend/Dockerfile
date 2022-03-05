FROM gradle:7.3.3-jdk11-alpine AS build
WORKDIR /usr/src/gradle
COPY --chown=gradle:gradle . .
RUN gradle clean bootJar --no-daemon -x test
RUN ls /usr/src/gradle/build/libs/

FROM azul/zulu-openjdk-alpine:11 AS dev
LABEL maintainer="gabrielmbarboza"
WORKDIR /usr/src/app
COPY --from=build /usr/src/gradle/build/libs/*.jar /usr/src/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
