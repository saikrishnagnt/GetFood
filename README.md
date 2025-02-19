# GetFood Application

## Overview
GetFood is a microservices-based food delivery application, similar to Swiggy, designed to handle user management, order processing, real-time notifications, and payment handling efficiently.

## Features
- **User Management**: Role-based access, loyalty programs, and authentication.
- **Order Management**: Order tracking, reassignment, and scheduled orders.
- **Restaurant Management**: Menu management and analytics.
- **Delivery Service**: Real-time tracking and ETA estimation.
- **Notifications**: WebSocket-based real-time notifications and Firebase integration.
- **Payment Gateway**: Multi-payment support and refund automation.
- **API Gateway**: Secure and scalable request routing.

## Project Structure
```
GetFood/
├── user-management/
│   ├── src/main/java/com/getfood/user/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   ├── src/main/resources/
│   │   └── application.yml
├── order-management/
│   ├── src/main/java/com/getfood/order/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   ├── src/main/resources/
│   │   └── application.yml
├── restaurant-management/
├── delivery/
├── notification/
├── payment/
├── gateway/
├── data-model/
├── db/
│   ├── schema.sql
│   ├── data.sql
├── docker/
│   ├── docker-compose.yml
├── docs/
│   ├── API_SPEC.yaml
│   ├── README.md
├── pom.xml
```

## Setup & Deployment
### Prerequisites
- Java 17+
- Maven
- Docker & Docker Compose
- MySQL

### Steps to Run Locally
1. **Clone the Repository**:
   ```sh
   git clone https://github.com/saikrishnagnt/GetFood.git
   cd GetFood
   ```

2. **Build Microservices**:
   ```sh
   mvn clean install
   ```

3. **Start Services Using Docker**:
   ```sh
   docker-compose up -d
   ```

4. **Access APIs**:
   - API Gateway: `http://localhost:8080`
   - Swagger Docs: `http://localhost:8080/swagger-ui.html`

## Contribution Guide
1. Fork the repository.
2. Create a new branch: `git checkout -b feature-branch`
3. Commit your changes: `git commit -m "Add new feature"`
4. Push the branch: `git push origin feature-branch`
5. Open a pull request.

## License
MIT License. Feel free to use and contribute!
