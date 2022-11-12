FROM openjdk:11
COPY build/libs/postmanager-0.0.1-SNAPSHOT.jar postmanager-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/postmanager-0.0.1-SNAPSHOT.jar"]
