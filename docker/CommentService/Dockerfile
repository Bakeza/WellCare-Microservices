# Dockerfile for Spring Boot service 1
FROM openjdk:22-jdk-slim

WORKDIR /CommentService

COPY ./Comment-Service.jar .
COPY ./application.properties .

CMD ["java", "-jar", "Comment-Service.jar", "--spring.config.location=application.properties"]
