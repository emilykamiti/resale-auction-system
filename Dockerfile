 #Stage 1: Build the application
FROM maven:3.9.5 as build

WORKDIR /app

COPY pom.xml .

RUN mvn install

COPY . .

RUN mvn clean compile package

# Stage 2: Deploy the application to WildFly
FROM quay.io/wildfly/wildfly:26.1.3.Final-jdk11 AS deploy
# Remove the default standalone.xml file from WildFly
RUN rm /opt/jboss/wildfly/standalone/configuration/standalone.xml

COPY --from=build /app/standalone.xml /opt/jboss/wildfly/standalone/configuration/


COPY --from=build /app/mysql /opt/jboss/wildfly/modules/system/layers/base/org/


# Copy the WAR file
COPY --from=build /app/target/ResaleAuctionSystem.war /opt/jboss/wildfly/standalone/deployments/

# Expose port 8080
EXPOSE 8080

# Start WildFly
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
