FROM openjdk:11
COPY postmanager-0.0.1-SNAPSHOT.jar /
CMD ["java","-jar","/postmanager-0.0.1-SNAPSHOT.jar"]
