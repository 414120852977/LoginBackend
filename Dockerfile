FROM openjdk:11-jdk-slim
 
COPY lookUp-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
# set the startup command to execute the jar
CMD ["java", "-jar", "lookUp-0.0.1-SNAPSHOT.jar"]