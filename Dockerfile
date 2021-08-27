FROM openjdk:8-jdk-alpine
ADD target/*.jar /app.jar
EXPOSE 80
CMD java -jar /app.jar