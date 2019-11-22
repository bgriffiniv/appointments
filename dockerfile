FROM openjdk:10-jre-slim
COPY ./build/libs/appointments-1.0.0-SNAPSHOT.jar /usr/src/appointments/
WORKDIR /usr/src/appointments
EXPOSE 8080
CMD ["java", "-jar", "appointments-1.0.0-SNAPSHOT.jar"]