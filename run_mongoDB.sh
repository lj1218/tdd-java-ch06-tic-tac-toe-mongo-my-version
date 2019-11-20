#!/usr/bin/env bash

docker pull mongo
docker rm -f mongoDB
docker run -p 27017:27017 --name mongoDB -d mongo
