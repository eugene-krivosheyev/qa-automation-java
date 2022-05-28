FROM eclipse-temurin:11-jre
WORKDIR /usr/share/app
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.liquibase.contexts=prod,faker"]
COPY build/app.jar ./
