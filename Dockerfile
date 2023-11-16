# Use an official WildFly runtime as a parent image
FROM jboss/wildfly:latest

# Copy the WAR file into the deployments directory of WildFly
COPY target/ResaleAuctionSystem.war /opt/jboss/wildfly/standalone/deployments/

# Expose the ports your WildFly instance will run on (HTTP and management ports) - 9990?
EXPOSE 8080 8443 

# Start WildFly
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]