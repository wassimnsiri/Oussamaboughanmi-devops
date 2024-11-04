FROM openjdk:17-jdk-alpine

WORKDIR /app

ADD target/tp-foyer-5.0.0.jar tp-foyer-5.0.0.jar

EXPOSE 8091  # Ensure this matches the port in your application.properties

ENTRYPOINT ["java", "-jar", "tp-foyer-5.0.0.jar"]
