# ⏱️ Programmatic Timer EJB Demo

> A Java EE application showcasing the use of programmatic timers via the `TimerService` API.

---

## 📑 Table of Contents

1. [✨ Project Overview](#-project-overview)
2. [📂 Source Structure](#-source-structure)
3. [🛠️ Technologies & Dependencies](#️-technologies--dependencies)
4. [🚀 Getting Started](#-getting-started)

   * [Prerequisites](#-prerequisites)
   * [Clone & Build](#-clone--build)
   * [Deploy & Run](#-deploy--run)
5. [🔧 Configuration](#-configuration)
6. [📚 Core Components](#-core-components)

   * [TimerBean (EJB)](#timerbean-ejb)
   * [REST Interface](#rest-interface)
7. [📄 API Endpoints](#-api-endpoints)
8. [🔄 Timer Workflow](#-timer-workflow)
9. [🛡️ Error Handling & Logging](#️-error-handling--logging)
10. [🤝 Contributing](#-contributing)
11. [📜 License](#-license)

---

## ✨ Project Overview

This sample J2EE application illustrates creating and managing **programmatic timers** using the `javax.ejb.TimerService` interface. It provides:

* Dynamic timer creation with custom durations
* Callback handling via `@Timeout`
* A lightweight REST interface to start and inspect timers

Primarily intended for educational purposes, this demo helps you understand how to integrate timer-based tasks into your enterprise beans.

---

## 📂 Source Structure

```
Programmatical-Timer-J2EE/
├── src/main/java/
│   └── com/tharindu/ee/timer
│       ├── ejb/
│            ├── TaskSessionBean.java       
│            ├── TimerNewSessionBean.java
│            ├── TimerSessionBean.java 
│       ├── servlet/
│           ├── Test.java       
│           ├── TimerTest.java
│           ├── CancelTimer.java 
└── src/main/resources/
    └── META-INF/
```

> *Note:* Package names (`com.tharindu.ee.timer`) should reflect your own domain.

---

## 🛠️ Technologies & Dependencies

* **Java EE / Jakarta EE** (EJB, JAX-RS)
* **Maven** for build & dependency management
* **Application Server**: WildFly, GlassFish, or any JEE container with EJB support
* **JSON-B / Jackson** for JSON serialization
* **JUnit & Arquillian** (optional) for integration testing

---

## 🚀 Getting Started

### Prerequisites

* **JDK 11+**
* **Maven 3.6+**
* **Java EE–compliant server** (WildFly 21+, GlassFish 5+)
* **Git**

### Clone & Build

```bash
# Clone the repo
git clone https://github.com/Tharindu714/Programmatical-Timer-J2EE.git
cd Programmatical-Timer-J2EE

# Build with Maven
mvn clean package
```

### Deploy & Run

1. **Deploy** the generated WAR (`target/timer.war`) to your server’s `deployments/` folder.
2. **Start** (or restart) the server.
3. **Access** the REST API at `http://localhost:8080/timer-demo/api/timer`.

---

## 📚 Core Components

### TimerBean (EJB)

* **Injection:** `@Resource private TimerService timerService;`
* **Create Timer:** `timerService.createSingleActionTimer(duration, new TimerConfig(info, false));`
* **Timeout Callback:** Method annotated `@Timeout` handles expiration events.

### REST Interface

* **TimerResource.java:** Defines endpoints to:

  * **POST** `/api/timer` → Create a new timer (JSON payload with `duration`).
  * **GET** `/api/timer/{id}` → Retrieve timer info (status, next timeout).

---

## 📄 API Endpoints

| Method | Endpoint          | Description                                 |
| ------ | ----------------- | ------------------------------------------- |
| POST   | `/api/timer`      | Create a timer (body: `{"duration":60000}`) |
| GET    | `/api/timer/{id}` | Get timer details and info                  |

---

## 🔄 Timer Workflow

1. **Client** sends POST with desired duration.
2. **TimerBean** uses `TimerService` to schedule a `SingleActionTimer`.
3. Upon expiration, the **@Timeout** method executes business logic (e.g., logging).
4. **Client** can query status via GET endpoint.

---

## 🛡️ Error Handling & Logging

* **Validation:** Check payload duration is positive; return `400 Bad Request` if invalid.
* **ExceptionMapper:** Converts exceptions into JSON error responses.
* **Logging:** Standard `java.util.logging` in `logging.properties`.

---

## 🤝 Contributing

We welcome improvements!

1. **Fork** the repository.
2. **Create a branch:** `git checkout -b feature/xyz`.
3. **Commit** your changes with clear messages.
4. **Open** a Pull Request against `main`.

Please ensure Java EE best practices and update this README if structure changes.

---

## 📜 License

MIT © 2025 Tharindu714

---

> Demonstrating enterprise timers, one callback at a time! ☕️✨
