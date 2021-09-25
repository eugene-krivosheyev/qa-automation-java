FROM jhipster/jhipster:v7.2.0 AS buid
ENV APP_VERSION 1.0.0
USER root
VOLUME "$USER_HOME_DIR/.m2"
WORKDIR /home/jhipster/app
ENV HUSKY 0
COPY app.jdl .

RUN ["jhipster", "--no-insight", "jdl", "./app.jdl"]
RUN npm set-script prepare ""
RUN npm set-script postinstall ""
RUN ./mvnw -Pprod clean verify

FROM adoptopenjdk/openjdk11:alpine-jre
#USER root
WORKDIR /usr/share/app
RUN addgroup app && \
    adduser --ingroup app --disabled-password --no-create-home app && \
    chown -R app:app . && \
    chmod -R 700 . \
USER app
ENTRYPOINT ["java", "-jar", "app-1.0.0.jar", "--jhipster.security.authentication.jwt.secret={{ TODO }}"]
COPY --from=build /build/target/app-1.0.0.jar .
