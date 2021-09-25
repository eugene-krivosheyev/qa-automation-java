FROM jhipster/jhipster:v7.2.0 AS buid
ENV APP_VERSION 1.0.0
WORKDIR /home/jhipster/app
COPY app.jdl .
RUN jhipster --no-insight jdl ./app.jdl && \
    ./mvnw -Pprod clean verify -DskipTests
RUN ls
RUN ls target

FROM adoptopenjdk/openjdk11:alpine-jre
#USER root
WORKDIR /usr/share/app
#RUN addgroup app && \
#    adduser --ingroup app --disabled-password --no-create-home app && \
#    chown -R app:app . && \
#    chmod -R 700 .
#USER app
ENTRYPOINT ["java", "-jar", "app-1.0.0.jar"]
COPY --from=build /home/jhipster/app/target/app-1.0.0.jar .
