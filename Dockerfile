FROM openjdk:21
EXPOSE 8081
ADD target/ebank.jar ebank.jar
ENTRYPOINT ["java","-jar","/ebank.jar"]
