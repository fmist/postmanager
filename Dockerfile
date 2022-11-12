FROM openjdk:11
COPY build/libs/postmanager-0.0.1-SNAPSHOT.jar post.jar
ENTRYPOINT ["java","-jar","/post.jar"]
