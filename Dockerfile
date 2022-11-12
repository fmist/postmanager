FROM openjdk:11
ADD build/libs/postmanager-0.0.1-SNAPSHOT.jar post.jar
CMD ["java","-jar","/post.jar"]
