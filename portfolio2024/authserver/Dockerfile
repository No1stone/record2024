FROM openjdk:17-slim
LABEL authors="wonseok"
VOLUME /tmp
#ARG DB_URL
#ARG DB_USERNAME
#ARG DB_PASSWORD
#ENV DB_URL=${DB_URL}
#ENV DB_USERNAME=${DB_USERNAME}
#ENV DB_PASSWORD=${DB_PASSWORD}
RUN mkdir -p generated/querydsl
COPY build/libs/authserver-0.0.1-SNAPSHOT.jar authserver.jar


ENTRYPOINT ["java", "-jar", "authserver.jar"]