FROM --platform=linux/amd64 adoptopenjdk/openjdk11:centos-jre
WORKDIR /usr/share/app
ENTRYPOINT ["java", "-jar", "app.jar"]
ARG APP_VERSION_DEFAULT="0.0.1-SNAPSHOT"
COPY build/target/app-${APP_VERSION_DEFAULT}.jar ./app.jar
