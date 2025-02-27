# Builder stage
FROM gradle:8.4-jdk17-alpine AS builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon -x test

# Final stage
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 4021
VOLUME /home/votey/media
VOLUME /keys
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]