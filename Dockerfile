FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY . .
RUN ./gradlew build
CMD ["java", "-jar", "build/libs/webtech-bung-0.0.1-SNAPSHOT.jar"]
