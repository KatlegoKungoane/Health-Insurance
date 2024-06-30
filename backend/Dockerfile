FROM openjdk:17-alpine
WORKDIR /app
COPY pom.xml ./
RUN mvn clean package && \
  FIND_JAR_SCRIPT="find target/*.jar -name 'backend*.jar' -sort -VersionSort.semver -reverse | head -n 1" && \
  sh -c "echo $($FIND_JAR_SCRIPT) > backend.jar"
EXPOSE 80
EXPOSE 443
ENTRYPOINT ["java", "-jar", "backend.jar"]