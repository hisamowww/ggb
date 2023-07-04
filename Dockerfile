FROM maven:3.8.1-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /out/artifacts/ggb_jar/ggb-0.0.1-SNAPSHOT.jar ggb.jar
EXPOSE 8080
ENTRYPOINT ["java", "jar", "ggb.jar"]
