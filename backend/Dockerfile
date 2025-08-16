# backend/Dockerfile
FROM eclipse-temurin:21-jdk-alpine

RUN apk add --no-cache maven bash

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

EXPOSE 8080
CMD ["java", "-jar", "target/donation.challenge.fullstack-1.0.0.jar"]