# ---------- Stage 1 : Build Stage ----------
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /build

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests


# ---------- Stage 2 : Runtime Stage ----------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy only the jar from builder stage
COPY --from=builder /build/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]