# ==========================================
# STAGE 1: Build the application using Gradle Wrapper
# ==========================================
# Upgraded to Java 21 JDK
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Copy the Gradle Wrapper script and its configuration folder
COPY gradlew .
COPY gradle ./gradle

# Copy the build configuration and source code
COPY build.gradle settings.gradle ./
COPY src ./src

# Make the wrapper executable
RUN chmod +x ./gradlew

# Compile the code using the Wrapper
RUN ./gradlew build -x test

# ==========================================
# STAGE 2: Run the application
# ==========================================
# Upgraded to Java 21 JRE (Runtime Environment)
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy ONLY the compiled .jar file from the 'builder' stage
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
