FROM openjdk:10-jre-slim
COPY ./build/libs/appointments-0.0.1-SNAPSHOT.jar /usr/src/appointments/
WORKDIR /usr/src/appointments
EXPOSE 8080
CMD ["java", "-jar", "appointments-0.0.1-SNAPSHOT.jar"]