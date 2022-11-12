FROM adoptopenjdk/openjdk11
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
