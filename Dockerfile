# ==========================================
# STAGE 1: Build the application with Gradle
# ==========================================
# Use an official Gradle image with JDK 17
FROM gradle:8.5-jdk17 AS builder

# Set the working directory
WORKDIR /app

# Copy the Gradle configuration files and source code
COPY build.gradle settings.gradle ./
COPY src ./src

# Compile the code and package it into a .jar file (skipping tests)
RUN gradle build --no-daemon -x test

# ==========================================
# STAGE 2: Run the application
# ==========================================
# Use a much smaller base image just for running Java
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy ONLY the compiled .jar file from the 'builder' stage
# Gradle saves the output in build/libs/ instead of target/
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar

# Expose port 8080 (Spring Boot's default port)
EXPOSE 8080

# The command to start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
