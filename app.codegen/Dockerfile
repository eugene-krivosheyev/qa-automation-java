FROM eclipse-temurin:11-jre
WORKDIR /usr/share/app
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod,api-docs", "--spring.liquibase.contexts=prod,faker"]
COPY build/app.jar ./
