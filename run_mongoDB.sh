#!/usr/bin/env bash

image=mongo
container_name=mongoDB
args="-p 27017:27017"

docker inspect ${image} -f '{{.Id}}' >/dev/null 2>&1 || docker pull ${image}
docker rm -f ${container_name} >/dev/null 2>&1
docker run -d --name ${container_name} ${args} ${image}
