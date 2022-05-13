FROM quay.io/wildfly/wildfly:23.0.2.Final 
COPY ./target/bkmapp.war /opt/jboss/wildfly/standalone/deployments/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-microprofile.xml", "-b", "0.0.0.0"]