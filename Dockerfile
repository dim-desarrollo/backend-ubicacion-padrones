FROM openjdk:21
MAINTAINER DIM <correo@dim.com>
VOLUME /data/dev
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} backend-ubicacion-padrones.jar
ENTRYPOINT ["java", "-jar", "/backend-ubicacion-padrones.jar"]
