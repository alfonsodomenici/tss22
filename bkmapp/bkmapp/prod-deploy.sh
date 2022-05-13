#!/bin/sh

mvn clean package  -P docker.prod && docker build --rm -t dhtssdev/bkmapp .

docker push dhtssdev/bkmapp