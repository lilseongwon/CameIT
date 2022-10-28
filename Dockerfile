FROM openjdk:17-jdk-slim

EXPOSE 8080

ADD build/libs/CameIT-0.0.1-SNAPSHOT.jar CameIT-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","CameIT-0.0.1-SNAPSHOT.jar"]