FROM adoptopenjdk/openjdk11
ARG JAR_FILE=build/libs/$JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
