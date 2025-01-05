FROM eclipse-temurin:21-jdk

ARG GRADLE_VERSION=8.8

WORKDIR /app

COPY /app .

RUN ./gradlew installDist

CMD java -jar build/libs/app-1.0-SNAPSHOT.jar
