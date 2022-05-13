#!/bin/sh
mvn clean package -P docker.local && docker build --rm -t dhtssdev/bkmapp .
docker rm -f bkmapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name bkmapp --network tss dhtssdev/bkmapp  && docker logs -f bkmapp
