FROM openjdk:8
ADD target/stock-service.jar stock-service.jar
EXPOSE 8300
ENTRYPOINT ["java", "-jar", "stock-service.jar"]