FROM openjdk:8
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
