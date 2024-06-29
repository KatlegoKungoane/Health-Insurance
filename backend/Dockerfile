FROM openjdk:17-alpine
WORKDIR /app
COPY pom.xml ./
RUN mvn clean package
COPY target/*.jar ./
EXPOSE 80
EXPOSE 443
ENTRYPOINT ["java", "-jar", "backend.jar"]