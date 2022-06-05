FROM eclipse-temurin:11-jre
WORKDIR /usr/share/app
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=dev,api-docs", "--spring.liquibase.contexts=dev,faker"]
COPY build/app.jar ./
