FROM adoptopenjdk/openjdk11:latest

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/customer-app

COPY ${JAR_FILE} /opt/customer-app/app.jar

ENTRYPOINT ["java", "-jar", "/opt/customer-app/app.jar"]