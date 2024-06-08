# Dockerfile for Spring Boot service 1
FROM openjdk:22-jdk-slim

WORKDIR /ApiGateway

COPY ./API-Gateway.jar .
COPY ./application.properties .

CMD ["java", "-jar", "API-Gateway.jar", "--spring.config.location=application.properties"]
