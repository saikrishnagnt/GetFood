# CHANGELOG.md

## GetFood User Management - Change Log

### **[v1.0] - Initial Version**
- Implemented **User Registration & Authentication** using JWT and OTP.
- Added **Multi-Factor Authentication (MFA)** with OTP verification.
- Integrated **JWT Token Management** (Generation, Validation, and Extraction).
- Developed **User Profile Management APIs**:
  - `GET /api/users/profile` - Fetch user details.
  - `PUT /api/users/profile` - Update user details.
- Updated **Database Schema (`schema.sql`)**:
  - Added `address` and `profile_picture` fields to the `users` table.
- Implemented **Security Enhancements**:
  - User authentication via JWT.
  - Secure token handling.
- Fixed **Dependency Issues** in `pom.xml`:
  - Added `jjwt` for JWT handling.
  - Included `JUnit` and `Mockito` for testing.
