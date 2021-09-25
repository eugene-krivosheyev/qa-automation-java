FROM jhipster/jhipster:v7.2.0 AS buid
WORKDIR /build
COPY app.jdl .
ENV APP_VERSION 1.0.0
RUN jhipster jdl app.jdl && \
    mvnw -Pprod clean verify

FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app
ENTRYPOINT ["java", "-jar", "app-1.0.0.jar"]
COPY --from=build /build/target/app-1.0.0.jar .
