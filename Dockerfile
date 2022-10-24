FROM openjdk:8
EXPOSE 8080
ADD target/spring-achat.jar spring-achat.jar
ENTRYPOINT ["java","-jar","/spring-achat.jar"]