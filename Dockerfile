FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./mvnw bootJar --no-daemon

FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY --from=build /build/libs/ggb-0.0.1-SNAPSHOT.jar ggb.jar

ENTRYPOINT ["java", "jar", "ggb.jar"]
