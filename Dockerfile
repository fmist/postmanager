FROM openjdk:11
ARG JAR_FILE=build/libs/postmanager-0.0.1-SNAPSHOT.jar
COPY $JAR_FILE app.jar
CMD ["java","-jar","/app.jar"]
