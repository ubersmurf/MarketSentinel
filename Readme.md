# 🛡️ MarketSentinel
### High-Performance Financial Analysis & Alert System with Hybrid Architecture

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)

> **"Code that works is not enough. It must be sustainable, scalable, and testable."**

---

## 📖 Overview
**MarketSentinel** is a robust financial monitoring system designed to demonstrate advanced software engineering principles.  
Unlike traditional stock trackers, this project emphasizes **Software Architecture** over simple functionality.

It features a **Hybrid Architecture** where a high-performance **Java Backend** manages the business logic and design patterns, while a **Python** micro-script handles data visualization and complex statistical analysis.

---

## 🏗️ Engineering & Architecture
This project is built to showcase the practical application of **GoF (Gang of Four) Design Patterns**.

### 📐 UML Class Diagram
<img width="1471" height="1151" alt="uml" src="https://github.com/user-attachments/assets/6475060c-a4d8-4958-af21-852e04c44083" />


### 1️⃣ Creational Patterns
- **Singleton Pattern (`APIManager`)**  
  Ensures a single point of access for external Market Data APIs, managing connection pools and preventing resource overuse.

- **Factory Method Pattern (`AssetFactory`)**  
  Decouples client code from concrete asset classes (`Crypto`, `Stock`), allowing new asset types (e.g. Commodities) to be added without modifying existing code.

---

### 2️⃣ Behavioral Patterns
- **Observer Pattern (`NotificationSystem`)**  
  Implements a reactive architecture. When asset prices exceed thresholds, independent subsystems (`ConsoleLogger`, `EmailService`, `TradeBot`) are notified automatically.

- **Strategy Pattern (`AnalysisEngine`)**  
  Enables runtime switching between analysis algorithms such as `SimpleMovingAverage` or `RSIStrategy` without stopping the system.

---

### 3️⃣ Hybrid Bridge (Java ↔ Python)
- Uses Java `ProcessBuilder` to integrate Python’s data science stack (Pandas / Matplotlib) with Java’s type-safe backend.

---

## 🚀 Getting Started

### ✅ Prerequisites
- **Docker** (Recommended)

**OR**

- Java 17+
- Python 3.9+

---

## 🐳 Running with Docker
MarketSentinel is fully containerized — no need to install Java or Python dependencies manually.

```bash
# 1. Clone the repository
git clone https://github.com/username/MarketSentinel.git

# 2. Build the Docker image 
docker build --no-cache -t marketsentinel .

# 3. Run the container

# Linux / macOS
docker run -it -v $(pwd)/data:/app/data marketsentinel

# Windows CMD
docker run -it -v %cd%\data:/app/data marketsentinel

# Windows PowerShell
docker run -it -v ${PWD}/data:/app/data marketsentinel
```

## 📊 Visual Output Sample
<img width="640" height="480" alt="chart" src="https://github.com/user-attachments/assets/1dfb49ce-9381-4c63-b800-a969b338b6e0" />


---

## 🧪 Testing
The project follows **TDD (Test Driven Development)** principles using **JUnit 5**.

### ✔ Test Coverage
- **Unit Tests**
  - Singleton instance validation
  - Strategy algorithm correctness

- **Integration Tests**
  - Java ↔ Python process execution

### ▶ Run Tests
```bash
mvn test
```

---

### Educational Context
**This project was developed during my 2nd year as a Computer Science student to demonstrate:**
 - Object-Oriented Design
 - Design Patterns
 - Multi-language system integration

---

## 👤 Author
**Taha**

---
