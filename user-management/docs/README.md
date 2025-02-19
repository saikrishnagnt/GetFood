# README.md

# GetFood - User Management Module

## Overview
The User Management module provides **authentication, profile management, and security** features for the GetFood application.

## Features
- **User Authentication** (JWT-based, OTP login, MFA)
- **Profile Management** (Fetch & Update user details)
- **Security Enhancements** (Token validation, Role-based access control)

## API Endpoints
### **Authentication APIs**
- `POST /api/auth/send-otp` - Send OTP for login.
- `POST /api/auth/verify-otp` - Verify OTP and generate JWT token.
- `POST /api/auth/mfa/enable` - Enable Multi-Factor Authentication.

### **User Profile APIs**
- `GET /api/users/profile` - Fetch user details.
- `PUT /api/users/profile` - Update user details.

## Database Schema
See `schema.sql` for table definitions.

## Setup & Deployment
1. Clone the repository:  
   ```sh
   git clone <repo_url>
   cd GetFood
   ```
2. Update dependencies:  
   ```sh
   mvn clean install
   ```
3. Start the application:  
   ```sh
   mvn spring-boot:run
   ```

## Contribution Guide
1. Fork the repository.
2. Create a new branch:  
   ```sh
   git checkout -b feature-branch
   ```
3. Commit your changes:  
   ```sh
   git commit -m "Added new feature"
   ```
4. Push the branch & create a pull request.

## License
MIT License - Open for contributions!
