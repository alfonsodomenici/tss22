#!/bin/sh
mvn clean package && docker build -t it.tss/worldapp .
docker rm -f worldapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name worldapp it.tss/worldapp 
