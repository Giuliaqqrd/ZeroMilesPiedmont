#official Maven runtime as a parent image
FROM maven:latest AS build

#setting the working directory in the container
WORKDIR /app

#copy the project files into the container
COPY . .

#build the Spring Boot application using Maven
RUN mvn clean package -DskipTests

#create a new image for the application
FROM openjdk:19

#set the working directory in the container
WORKDIR /app

#copy JAR file from the Maven build stage
COPY --from=build /app/target/company-service-0.0.1-SNAPSHOT.jar company-service-1.0.0.jar

#expose the port your Spring Boot app listens on (default is 8080)
EXPOSE 8080

#define the command to run your Spring Boot application
CMD ["java", "-jar", "company-service-1.0.0.jar"]