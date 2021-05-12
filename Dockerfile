FROM openjdk:11
MAINTAINER Jean Liu
LABEL name="loc-media" version="1.0" author="Jean Liu"

EXPOSE 9003

COPY gradle/ gradle
COPY gradlew build.gradle settings.gradle ./

RUN sed -i 's/\r$//' gradlew

COPY src/ ./src
RUN ./gradlew build
CMD ["./gradlew","bootRun"]