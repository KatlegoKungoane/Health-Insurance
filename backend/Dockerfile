# Build Stage
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/backend-*.jar /app/app.jar
EXPOSE 80
EXPOSE 443
ENTRYPOINT ["java","-jar","/app/app.jar"]