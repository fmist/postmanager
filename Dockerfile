FROM openjdk:11
ADD build/libs/postmanager-0.0.1-SNAPSHOT.jar post.jar
ENTRYPOINT ["java","-jar","/post.jar"]
