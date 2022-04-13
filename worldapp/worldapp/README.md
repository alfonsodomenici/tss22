# Build
mvn clean package && docker build -t it.tss/worldapp .

# RUN

docker rm -f worldapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name worldapp it.tss/worldapp 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test