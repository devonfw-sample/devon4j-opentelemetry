FROM openjdk:11-jre
RUN mkdir -p /app/bin
COPY ./server/target/testapp-server-bootified.war /app/bin

CMD java -jar /app/bin/testapp-server-bootified.war
