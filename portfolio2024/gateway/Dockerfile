FROM openjdk:17-slim
LABEL authors="wonseok"
VOLUME /tmp
COPY build/libs/gateway-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java", "-jar", "gateway.jar"]