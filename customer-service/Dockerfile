FROM openjdk
MAINTAINER Dipankar Chatterjee <dipankar.c@hcl.com>
ADD target/customer-service-1.0.jar customer-service-1.0.jar
ENTRYPOINT exec java -jar /customer-service-1.0.jar customer-service
EXPOSE 3333