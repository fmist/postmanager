FROM openjdk:11
ARG APP_NAME="postmanager"
ARG APP_VERSION="0.0.1-SNAPSHOT"
ARG JAR_FILE="/build/libs/${APP_NAME}-${APP_VERSION}.jar"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
