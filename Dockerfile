FROM adoptopenjdk/openjdk11
COPY ${JAR_FILE} app.jar
CMD ["java","-jar", "app.jar"]
