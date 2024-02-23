FROM openjdk:17-slim
LABEL authors="wonseok"
VOLUME /tmp
COPY build/libs/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver.jar
ENTRYPOINT ["java", "-jar", "eurekaserver.jar"]