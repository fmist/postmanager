FROM adoptopenjdk/openjdk11
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"," jar","app.jar"]
