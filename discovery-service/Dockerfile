FROM openjdk
MAINTAINER Dipankar Chatterjee <dipankar.c@hcl.com>
ADD target/discovery-service-1.0.jar discovery-service-1.0.jar
ENTRYPOINT exec java -jar /discovery-service-1.0.jar discovery-service
EXPOSE 8761