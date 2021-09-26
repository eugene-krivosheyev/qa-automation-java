ARG APP_VERSION_DEFAULT="0.0.1-SNAPSHOT"

FROM --platform=linux/amd64 jhipster/jhipster:v7.1.0 AS build
WORKDIR /home/jhipster/app
ARG APP_VERSION_DEFAULT
ENV APP_VERSION $APP_VERSION_DEFAULT
COPY app.jdl .
RUN jhipster --no-insight jdl app.jdl
RUN ./mvnw -Pprod,api-docs verify -DskipTests

FROM --platform=linux/amd64 adoptopenjdk/openjdk11:centos-jre
WORKDIR /usr/share/app
ENTRYPOINT ["java", "-jar", "app.jar"]
ARG APP_VERSION_DEFAULT
ENV APP_VERSION $APP_VERSION_DEFAULT
COPY --from=build /home/jhipster/app/target/app-${APP_VERSION}.jar ./app.jar
