FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y netcat-openbsd

COPY wait-for-it.sh /wait-for-it.sh

COPY api-0.0.1-SNAPSHOT.jar /app.jar

RUN chmod +x /wait-for-it.sh

ENTRYPOINT ["/wait-for-it.sh", "cadastro-postgres:5432", "--", "java", "-jar", "/app.jar"]
