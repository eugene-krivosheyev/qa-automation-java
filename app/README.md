Prerequisites
=============
```shell
cd app
```

(for Mac only)
```shell
export DOCKER_BUILDKIT=0
export COMPOSE_DOCKER_CLI_BUILD=0
```

Build
=====
```shell
app> 
  mkdir build && \
  cd "$_" && \
  jhipster --no-insight jdl ../app.jdl && \
  ./mvnw -Pprod,api-docs verify -DskipTests && \
  cd .. && \
  docker build --tag ekr26/tinkoff-edu-app:1.0.0 .

app>
  rm -rf build
```

Push
====
```shell
docker push ekr26/tinkoff-edu-app:1.0.0
```


Run
====

Start cluster
--------------
```shell
app>
  docker stack deploy --compose-file docker-compose.yml app
```

Cluster info
------------
```shell
docker stack ls
docker stack ps app
docker stack services app

```

Stop cluster
------------
```shell
docker stack rm app
```
