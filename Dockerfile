FROM openjdk:8
EXPOSE 8080
ADD target/devops-automation.jar devops-integration.jar
ENTRYPOINT ["java", "-jar", "/devops-integration.jar"]