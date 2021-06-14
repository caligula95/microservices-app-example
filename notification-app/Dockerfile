FROM adoptopenjdk/openjdk11:latest

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/notification-app

COPY ${JAR_FILE} /opt/notification-app/app.jar

ENTRYPOINT ["java", "-jar", "/opt/notification-app/app.jar"]