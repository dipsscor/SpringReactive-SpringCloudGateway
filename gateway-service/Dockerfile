FROM openjdk
MAINTAINER Dipankar Chatterjee <dipankar.c@hcl.com>
ADD target/gateway-service-1.0.jar gateway-service-1.0.jar
ENTRYPOINT exec java -jar /gateway-service-1.0.jar gateway-service
EXPOSE 8090