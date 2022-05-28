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
1. Copy and edit `app.codegen/app.jdl` with [JDL Studio](https://start.jhipster.tech/jdl-studio/) 
1. Save updated `app.codegen/app.jdl`


Build the code-generated application jar (optional)
========================================
```shell
mkdir build.temp && \
cd "$_" && \
jhipster --no-insight jdl ../app.jdl && \
./mvnw -Pprod,api-docs verify -DskipTests && \
cd .. && \
cp build.temp/target/app-0.0.1-SNAPSHOT.jar build/app.jar && \
rm -rf build.temp
```
OR download [pre-built jar](https://www.dropbox.com/s/gkeyi3c5ydnlyzl/app.jar?dl=0) to `app.codegen/build`

Build the Docker image (optional)
======================
```shell
docker buildx build --tag ekr26/tinkoff-edu-app:1.0.0 .
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

API info
--------
- [Main page](http://localhost:8080)
- [Swagger UI](http://localhost:8080/admin/docs)
- [OpenAPI spec](http://localhost:8080/v3/api-docs/springdocDefault)

Stop the cluster and clean up
-----------------------------
```shell
docker stack rm app
docker volume rm app_db
docker rmi ekr26/tinkoff-edu-app:1.0.0
```
