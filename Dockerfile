FROM openjdk:8
ADD target/load-balancer.jar load-balancer.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "load-balancer.jar"]