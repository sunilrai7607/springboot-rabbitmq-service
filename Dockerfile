FROM openjdk:8-jdk-alpine
MAINTAINER Sunil Rai <sunilrai7607@gmail.com>
VOLUME /app
ARG version
ENV version_number=$version
COPY ./build/libs/springboot-rabbitmq-service-$version_number.jar springboot-rabbitmq-service.jar
ENTRYPOINT ["java", "-jar","/springboot-rabbitmq-service.jar"]