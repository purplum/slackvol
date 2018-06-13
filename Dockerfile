FROM openjdk:8u131-jdk-alpine  
VOLUME /tmp  
WORKDIR /app  
COPY ./target/sv_streetcleaner-0.0.1.jar .
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/sv_streetcleaner-0.0.1.jar"]