FROM eu.gcr.io/lumeer-bp/devel:latest

MAINTAINER marvenec@gmail.com

RUN cd /opt/jboss \
    && git clone https://github.com/Lumeer/web-ui.git \
    && cd web-ui \
    && export LUMEER_ENGINE=lumeer-engine \
    && mvn clean package -DskipTests \
    && cp target/lumeer-web.war /opt/jboss/wildfly/standalone/deployments \
    && cd .. \
    && rm -rf web-ui

RUN cd /opt/jboss \
    && git clone https://github.com/mlynarikj/engine.git \
    && cd engine \
    && mvn clean install -Pproduction -DskipTests \
    && cp war/target/engine-war.war /opt/jboss/wildfly/standalone/deployments \
    && cd .. \
    && rm -rf engine \
    && rm -rf ~/.m2

RUN rm -rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history/current

USER root
CMD ["--server-config", "standalone-ha.xml", "-Dlumeer.keycloak.truststore=/usr/jr-domain.ga.jks"]
