FROM openjdk:17-jdk-alpine



# Set the working directory inside the container

WORKDIR /app



# Copy the latest release of the JAR file into the container

# Assumes that the jar file is located in the same directory as the Dockerfile

# Expose the port that your Spring Boot app will run on

EXPOSE 8089

ADD target/tp-foyer-5.0.0.jar tp-foyer-5.0.0.jar

# Define the command to run the JAR file

ENTRYPOINT ["java", "-jar", "/tp-foyer-5.0.0.jar"]