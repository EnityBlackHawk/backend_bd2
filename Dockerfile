FROM maven:3-eclipse-temurin-21-alpine AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn package


FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY --from=builder /app/target/bd2-0.0.1-SNAPSHOT.jar /app.jar

RUN apk add --no-cache curl

EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]

