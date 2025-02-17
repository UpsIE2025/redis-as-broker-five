FROM openjdk:21
EXPOSE 8080
COPY build/libs/group-producer-0.0.1-SNAPSHOT.jar group-producer.jar
ENTRYPOINT ["java", "-jar", "/group-producer.jar"]