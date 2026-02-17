FROM maven:3.8.5-openjdk-17 AS builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    rm -rf /var/lib/apt/lists/*

RUN pip3 install pandas matplotlib --break-system-packages

COPY --from=builder /app/target/*.jar app.jar

COPY python_scripts ./python_scripts

RUN mkdir data

ENTRYPOINT ["java", "-jar", "app.jar"]