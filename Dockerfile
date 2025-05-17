# Use Maven image to build the app
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copy all files and build the application
COPY . .
RUN mvn clean package -DskipTests

# Use a smaller JDK image to run the app
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the jar file from the previous build stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
