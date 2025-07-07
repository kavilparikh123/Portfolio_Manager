# 💹 AI-Powered Smart Investment Portfolio Manager

A full-stack web application for managing investment portfolios with real-time stock tracking, AI-driven risk analysis, live alerts, and cloud-ready deployment.

---

## 🧰 Tech Stack

- **Backend:** Java, Spring Boot, Spring Security, Kafka, WebSocket, TensorFlow (stub), H2/PostgreSQL
- **Frontend:** Angular 20 (Standalone APIs), RxJS, SCSS
- **Tools:** JWT Auth, REST APIs, STOMP over SockJS, AWS (EC2/S3), Docker (optional)

---

## 📁 Project Structure

```

portfolio-manager/
├── backend/                 # Spring Boot application
├── smart-invest-ui/         # Angular frontend app

````

---

## 🚀 Features

- ✅ User Registration & Login (JWT)
- 📈 Live Stock Price Fetch (TwelveData API or similar)
- 💼 Portfolio & Holdings Management
- ⚠️ Real-time Stock Alerts (Kafka → WebSocket)
- 📊 AI-based Risk Scoring (TensorFlow-ready)
- ☁️ Cloud Deployment (AWS EC2 + S3/CDN)

---

## 🔧 Backend Setup (Spring Boot)

```bash
cd backend
./mvnw clean package
java -jar target/portfolio-manager.jar
````

### 🔐 REST Endpoints

* `POST /api/auth/register`
* `POST /api/auth/login`
* `GET /api/stocks`
* `POST /api/portfolios?name=XYZ`
* `GET /api/risk/{portfolioId}`

### 📦 Dev DB: H2 Console

* Visit: `http://localhost:8080/h2-console`
* JDBC: `jdbc:h2:mem:portfolio_db`

---

## 🖥️ Frontend Setup (Angular 20+)

```bash
cd smart-invest-ui
npm install
ng serve
```

* Runs on `http://localhost:4200`
* Connects to backend on `http://localhost:8080`

### 🔑 Auth Workflow

* Login: `POST /api/auth/login` → `token`
* Token is stored in `localStorage` and attached via `HttpInterceptor`

---

## 🔔 Real-Time Alerts

* Kafka produces alerts to `stock-alerts` topic
* Spring Boot consumes and pushes to `/topic/alerts` via WebSocket
* Angular listens via STOMP + SockJS

---

## 📡 Deployment (Optional)

### 🟤 Spring Boot on EC2

```bash
scp target/portfolio-manager.jar ec2-user@<ip>:/home/ec2-user
ssh ec2-user@<ip>
java -jar portfolio-manager.jar
```

### 🔵 Angular to S3 (Static Hosting)

```bash
ng build --output-path=dist
aws s3 sync dist/ s3://<your-bucket-name> --delete
```



## 👨‍💻 Author

Built by \[Kavil Parikh].
Feel free to contribute or fork the project!
