Prerequisites
=============
```shell
sudo yum install -y java-11-openjdk-devel nodejs
sudo npm install -g generator-jhipster
```

```shell
cd app.codegen
```

(for Mac only)
```shell
export DOCKER_BUILDKIT=0 && export COMPOSE_DOCKER_CLI_BUILD=0
```


Re-design the application (optional)
=========================
1. Edit `app.codegen/app.jdl` with [JDL Studio](https://start.jhipster.tech/jdl-studio/)
1. Save updated `app.codegen/app.jdl`


Build the code-generated application jar (optional)
========================================
Choose profile: `prod` vs `dev` (default)
```shell
mkdir build.temp && \
cd "$_" && \
jhipster --no-insight jdl ../app.jdl && \
./mvnw -Pdev,webapp verify -DskipTests && \
cd .. && \
cp build.temp/target/app-0.0.1-SNAPSHOT.jar build/app.jar && \
rm -rf build.temp
```

Build the Docker image
======================
```shell
docker buildx build --tag tinkoff-edu-app:1.0.0 .
```

Running the application cluster
===============================
Start
-----
```shell
docker stack deploy --compose-file docker-compose.yml --resolve-image never app
```

Cluster info (optional)
------------
```shell
docker stack ls
docker stack ps app
docker stack services app
docker service ps app_backend
docker service logs app_backend 
```

Stop the cluster and clean up
-----------------------------
```shell
docker stack rm app
docker volume rm app_db
docker rmi ekr26/tinkoff-edu-app:1.0.0
```
