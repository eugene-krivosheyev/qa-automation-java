Prerequisites
=============
Install [Docker Desktop](https://docs.docker.com/desktop/)

Download app release
====================
Download [pre-built jar](https://www.dropbox.com/s/g0er6zwnsycdrc5/app-dev.jar) to `app.codegen/build/app.jar`

Build the Docker image
======================
```shell
cd app.codegen
docker buildx build --tag tinkoff-edu-app:1.0.0 .
```

Run containerized app
=====================
```shell
docker run --detach --publish 8080:8080 tinkoff-edu-app:1.0.0
```

API info
========
- [Main page](http://localhost:8080)
- [Swagger UI](http://localhost:8080/admin/docs)
- [OpenAPI spec](http://localhost:8080/v3/api-docs/springdocDefault)

Stop and delete containerized app
=================================
```shell
docker ps
docker rm --force <NAME>
```
