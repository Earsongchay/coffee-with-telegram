FROM gradle:8.3.0-jdk17 AS build
COPY . .
RUN gradle clean build -x test

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /home/gradle/build/libs/coffee-with-telegram-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
