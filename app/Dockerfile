ARG APP_VERSION_DEFAULT=1.0.0

FROM jhipster/jhipster:v7.2.0 AS build
ARG APP_VERSION_DEFAULT
ENV APP_VERSION=$APP_VERSION_DEFAULT
WORKDIR /home/jhipster/app
COPY app.jdl .
RUN jhipster --no-insight jdl ./app.jdl && \
    ./mvnw -Pprod clean verify -DskipTests

FROM adoptopenjdk/openjdk11:alpine-jre
ARG APP_VERSION_DEFAULT
ENV APP_VERSION=$APP_VERSION_DEFAULT
#USER root
WORKDIR /usr/share/app
#RUN addgroup app && \
#    adduser --ingroup app --disabled-password --no-create-home app && \
#    chown -R app:app . && \
#    chmod -R 700 .
#USER app
ENTRYPOINT ["sh", "-c", "java -jar app-${APP_VERSION}.jar"]
COPY --from=build /home/jhipster/app/target/app-${APP_VERSION}.jar .
