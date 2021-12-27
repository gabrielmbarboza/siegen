FROM adoptopenjdk/openjdk11:alpine
LABEL maintainer="gabrielmbarboza"
WORKDIR /usr/src/app
COPY build/libs/*.jar ./sienge.jar
ENTRYPOINT ["java", "-jar", "sienge.jar"]