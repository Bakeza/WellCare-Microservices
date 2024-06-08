# Dockerfile for Spring Boot service 1
FROM openjdk:22-jdk-slim

WORKDIR /EurkaService

COPY ./Eurka-server.jar .
COPY ./application.properties .

CMD ["java", "-jar", "Eurka-server.jar", "--spring.config.location=application.properties"]
