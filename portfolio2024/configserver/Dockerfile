FROM openjdk:17-slim
LABEL authors="wonseok"
VOLUME /tmp
ARG GIT_PASSWORD
ENV GIT_PASSWORD=${GIT_PASSWORD}
COPY build/libs/configserver-0.0.1-SNAPSHOT.jar configserver.jar
ENTRYPOINT ["java", "-jar", "-Dspring.cloud.config.server.git.password=${GIT_PASSWORD}" ,"configserver.jar"]