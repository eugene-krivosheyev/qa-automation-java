ARG APP_VERSION_DEFAULT="0.0.1-SNAPSHOT"

FROM jhipster/jhipster:v7.2.0 AS build_stage
ARG APP_VERSION_DEFAULT
ENV APP_VERSION $APP_VERSION_DEFAULT
WORKDIR /home/jhipster/app
COPY app.jdl .
RUN jhipster --no-insight jdl ./app.jdl && \
    ./mvnw -Pprod clean verify -DskipTests \

RUN ls
RUN ls target

FROM adoptopenjdk/openjdk11:alpine-jre AS run_stage
ARG APP_VERSION_DEFAULT
ENV APP_VERSION $APP_VERSION_DEFAULT
WORKDIR /usr/share/app
ENTRYPOINT ["java", "-jar", "app.jar"]
COPY --from=build_stage /home/jhipster/app/target/app-${APP_VERSION}.jar ./app.jar
