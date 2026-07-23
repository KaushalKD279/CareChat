# CareChat 💬

> A scalable real-time chat application built incrementally using Spring Boot, WebSockets, and modern backend technologies.

## 📖 About

CareChat is a personal project aimed at building a production-ready, scalable real-time chat application from scratch.

Instead of implementing everything at once, the application is developed incrementally. Each phase introduces a new concept, following real-world software engineering practices. Every completed milestone is documented and pushed separately to GitHub.

The long-term goal is to evolve this project into a distributed chat system capable of supporting thousands of concurrent users using technologies like Redis, Kafka, Docker, Kubernetes, and Spring Security.

---

## 🚀 Tech Stack

### Backend
- Java 21
- Spring Boot 3
- Spring WebSocket

### Frontend
- HTML
- CSS
- JavaScript

### Tools
- IntelliJ IDEA
- Maven
- Git
- GitHub

---

# 📌 Current Progress

| Phase | Feature | Status |
|--------|---------|--------|
| 1 | Basic WebSocket Chat | ✅ Completed |
| 2 | JSON Message Model | ⏳ Planned |
| 3 | Message Timestamp | ⏳ Planned |
| 4 | Chat History | ⏳ Planned |
| 5 | Private Messaging | ⏳ Planned |
| 6 | Database Persistence | ⏳ Planned |
| 7 | User Authentication (JWT) | ⏳ Planned |
| 8 | Group Chat | ⏳ Planned |
| 9 | Online Presence & Typing Indicator | ⏳ Planned |
| 10 | Redis Pub/Sub | ⏳ Planned |
| 11 | Docker Containerization | ⏳ Planned |
| 12 | Kubernetes Deployment | ⏳ Planned |

---

# ✅ Phase 1 - Basic WebSocket Chat

### Implemented Features

- WebSocket server using Spring Boot
- Real-time communication
- Multiple clients can connect simultaneously
- Broadcast messages to all connected users
- Username-based login screen
- Session tracking
- Connection and disconnection logging

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.kaushal.carechat
│   │       ├── config
│   │       │   └── WebSocketConfig.java
│   │       ├── model
│   │       │   └── ChatMessage.java
│   │       └── websocket
│   │           └── ChatHandler.java
│   └── resources
│       └── static
│           └── index.html
```

---

## 🧪 Current Functionality

- Open the application in multiple browser tabs.
- Enter a username.
- Send messages.
- Messages are instantly broadcast to every connected client.

---

## 📸 Screenshots

Screenshots for each development phase are available inside the `screenshots/` directory.

---

## 🎯 Future Improvements

- JSON-based message communication
- Message timestamps
- Persistent chat history
- Private messaging
- User authentication using JWT
- MySQL/PostgreSQL integration
- Group chats
- Online/offline presence
- Typing indicator
- File sharing
- Redis Pub/Sub
- Docker
- Kubernetes
- Horizontal scaling

---

## 📚 Learning Objectives

This project is being developed to gain hands-on experience with:

- Spring Boot
- WebSockets
- REST APIs
- Concurrent programming
- Distributed systems
- Message brokers
- Authentication & Authorization
- System Design
- Scalable backend architecture

---

## 🤝 Contributing

This project is currently under active development as a personal learning project.

Suggestions and feedback are always welcome.

---

## ⭐ Repository Progress

Current Version

**v0.1.0 - Basic WebSocket Chat**