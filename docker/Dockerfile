FROM ubuntu:latest
LABEL authors="josea"
WORKDIR /app
COPY servidor-service-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]