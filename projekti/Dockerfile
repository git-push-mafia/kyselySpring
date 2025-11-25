FROM eclipse-temurin:17-jdk-focal as builder
WORKDIR /projekti/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install -DskipTests 
RUN find ./target -type f -name '*.jar' -exec cp {} /projekti/app/app.jar \; -quit

FROM eclipse-temurin:17-jre-alpine
COPY --from=builder /projekti/app/*.jar /projekti/app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/projekti/app/app.jar" ]