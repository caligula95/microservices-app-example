FROM adoptopenjdk/openjdk11:latest

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/eureka-server

COPY ${JAR_FILE} /opt/eureka-server/app.jar

ENTRYPOINT ["java", "-jar", "/opt/eureka-server/app.jar"]