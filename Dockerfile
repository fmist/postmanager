FROM openjdk:11
MAINTAINER rustCohle
COPY build/libs/postmanager-0.0.1-SNAPSHOT.jar docker-postmanager-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/docker-postmanager-0.0.1-SNAPSHOT.jar"]