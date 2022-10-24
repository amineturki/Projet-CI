FROM openjdk:8
EXPOSE 8080
ADD target/spring-achat spring-achat
ENTRYPOINT ["java","-jar","/spring-achat"]