FROM eclipse-temurin:17
WORKDIR workspace
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} cataloge-service.jar

ENTRYPOINT ["java", "-jar", "cataloge-service.jar"]