ARG APP_VERSION_DEFAULT="0.0.1-SNAPSHOT"

FROM jhipster/jhipster:v7.2.0 AS build
ARG APP_VERSION_DEFAULT
ENV APP_VERSION $APP_VERSION_DEFAULT
WORKDIR /home/jhipster/app
COPY app.jdl .
RUN jhipster --no-insight jdl ./app.jdl
RUN ./mvnw -Pprod clean verify -DskipTests

RUN pwd && echo "\n----" && \
    ls && echo "\n----" && \
    ls target

FROM adoptopenjdk/openjdk11:alpine-jre
ARG APP_VERSION_DEFAULT
ENV APP_VERSION $APP_VERSION_DEFAULT
WORKDIR /usr/share/app
ENTRYPOINT ["java", "-jar", "app.jar"]
COPY --from=build /home/jhipster/app/target/app-0.0.1-SNAPSHOT.jar ./app.jar
