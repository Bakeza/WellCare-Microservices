# Dockerfile for Spring Boot service 1
FROM openjdk:22-jdk-slim

WORKDIR /UserService

COPY ./User-Service.jar .
COPY ./application.properties .

CMD ["java", "-jar", "User-Service.jar", "--spring.config.location=application.properties"]
