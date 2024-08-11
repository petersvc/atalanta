FROM maven:3.9-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-alpine

WORKDIR /app

EXPOSE 8080

COPY --from=build ./app/target/*.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]