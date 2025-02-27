# Use OpenJDK 17 as the base image

FROM openjdk:17-jdk-slim


# Set working directory

WORKDIR /app


# Copy the built JAR file from target/

COPY target/vitg-api-0.0.1-SNAPSHOT.jar app.jar


# Expose the application port (default for Spring Boot)

EXPOSE 8080


# Run the application

ENTRYPOINT ["java", "-jar", "app.jar"]

