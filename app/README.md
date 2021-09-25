Build
=====
```shell
docker build --tag tinkoff/edu/app:1.0.0 .
```

Run
====

Start cluster
--------------
```shell
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
