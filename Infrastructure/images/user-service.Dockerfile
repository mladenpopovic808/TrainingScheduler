# Stage 1: Build maven project
FROM maven:3.8.4-openjdk-17 as builder
#Unutar containera se pravi folder /app koji ce biti zaduzen sa ovaj servis
WORKDIR /app 
#S obzirom da smo zadali context (path) za ovaj build,
#kopirace se pom.xml iz naseg java projekta. Trenutno se u containeru nalazimo u /app,dakle
#Kopirace pom.xml iz patha projekta koji smo prosledili u ".", znaci u /app
COPY pom.xml .
COPY src /app/src
RUN --mount=type=cache,target=/root/.m2 mvn clean package -Dmaven.test.skip

# Stage 2: Build the final image
#Koristimo linux zato sto je kompatibilan sa svim i svacim
FROM openjdk:17-jdk-oraclelinux8

#Putanja do jar fajla kreiranog u prvom stejdzu (mvn package kreira to)
ARG JAR_FILE=/app/target/*.jar
COPY --from=builder ${JAR_FILE} app.jar

# Expose port 8080
EXPOSE 8080

#Kada se podigne container, pokrenuce se komanda : java -jar /app.jar
#i samim tim podici ce se nasa aplikacija
ENTRYPOINT ["java","-jar","/app.jar"]