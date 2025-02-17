FROM openjdk:21
EXPOSE 8082
COPY build/libs/demo-0.0.1-SNAPSHOT.jar group-consumer.jar
ENTRYPOINT ["java", "-jar", "/group-consumer.jar"]