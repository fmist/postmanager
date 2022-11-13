FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.4_11 as packager
ARG JAR_FILE="/build/libs/postmanager-0.0.1-SNAPSHOT.jar"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "app.jar"]