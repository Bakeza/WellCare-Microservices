# Dockerfile for Spring Boot service 1
FROM openjdk:22-jdk-slim

WORKDIR /PostService

COPY ./Post-Service.jar .
COPY ./application.properties .

CMD ["java",  "-jar", "Post-Service.jar", "--spring.config.location=application.properties"]
