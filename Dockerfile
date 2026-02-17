# ---------- BUILD STAGE ----------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests


# ---------- RUNTIME STAGE ----------
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Install Python + venv
RUN apt-get update && \
    apt-get install -y python3 python3-pip python3-venv && \
    rm -rf /var/lib/apt/lists/*

# Create virtual environment
RUN python3 -m venv /opt/venv

# Activate venv path
ENV PATH="/opt/venv/bin:$PATH"

# Install Python packages inside venv
RUN pip install --upgrade pip
RUN pip install pandas matplotlib

# Copy jar
COPY --from=builder /app/target/marketsentinel-1.0-SNAPSHOT.jar app.jar

# Copy python scripts
COPY python_scripts ./python_scripts

RUN mkdir -p data

ENTRYPOINT ["java", "-jar", "app.jar"]