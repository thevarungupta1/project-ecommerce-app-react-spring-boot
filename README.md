# Grocery App Workspace

This workspace contains a full-stack grocery application with a React frontend and a Spring Boot backend.

## Projects

### Frontend
- Path: `grocery-react-web-app`
- Stack: React 18, React Router, Redux, Axios, Bootstrap, Formik, Yup
- Purpose: Customer-facing grocery storefront with login, category browsing, product listing, product details, and cart flow

### Backend
- Path: `grocery-spring-boot-api`
- Stack: Spring Boot, Spring Web MVC, Spring Data JPA, Spring Security, JWT, H2 Database, Swagger/OpenAPI
- Purpose: REST API for authentication, categories, subcategories, and products

## Project Description

The application provides a simple grocery shopping experience. Users can log in with seeded demo accounts, browse grocery categories and products, view product details, and manage items in the cart. The frontend consumes the Spring Boot API and uses JWT tokens for authentication.

## Features

### Frontend Features
- React single-page application
- Protected routes for authenticated pages
- Category and product browsing
- Product detail page
- Shopping cart with quantity controls
- Login and registration forms
- Axios interceptor for JWT token handling

### Backend Features
- Layered architecture with controller, service, repository, and entity layers
- JWT-based authentication
- BCrypt password hashing
- H2 in-memory database with seeded sample data
- Swagger/OpenAPI API documentation
- CORS configured for React dev server
- Demo categories, subcategories, products, and users

## Architecture

### Frontend Architecture
- `src/pages`: route-level pages
- `src/components`: reusable UI components
- `src/api`: API constants, endpoints, Axios config
- `src/redux`: cart store, actions, reducer
- `src/routes`: route protection logic

### Backend Architecture
- `controller`: REST endpoints
- `service`: business logic
- `repository`: JPA data access
- `entity`: database models
- `dto`: API request/response payloads
- `security`: JWT auth filter and user details service
- `config`: security config, OpenAPI config, seed data
- `exception`: global API error handling

## API Endpoints

Base URL:
- `http://localhost:8080/api`

Authentication:
- `POST /api/auth/register`
- `POST /api/auth/login`

Catalog:
- `GET /api/category`
- `GET /api/subcategory/{catId}`
- `GET /api/products/cat/{catId}`
- `GET /api/products/{id}`

Documentation and tools:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`
- H2 Console: `http://localhost:8080/h2-console`

## Seed Data

The backend seeds:
- 4 categories
- Multiple subcategories
- Multiple products with sample image URLs
- 3 demo users for login testing

## Dummy Credentials

Use any of the following accounts:

1. Email: `demo1@groceryapp.local`
   Password: `Password@123`
2. Email: `demo2@groceryapp.local`
   Password: `Password@123`
3. Email: `demo3@groceryapp.local`
   Password: `Password@123`

## How To Start Both Projects

Open two terminals from the workspace root.

### Start Backend
```powershell
Set-Location "grocery-spring-boot-api"
.\gradlew.bat bootRun
```

Backend runs on:
- `http://localhost:8080`

### Start Frontend
```powershell
Set-Location "grocery-react-web-app"
npm install
npm start
```

Frontend runs on:
- `http://localhost:3000`

## Build Commands

### Backend
```powershell
Set-Location "grocery-spring-boot-api"
.\gradlew.bat test
.\gradlew.bat clean build
```

### Frontend
```powershell
Set-Location "grocery-react-web-app"
npm run build
```

## Authentication Flow

1. User logs in from the React app.
2. Backend validates credentials and returns a JWT token.
3. Frontend stores the token in local storage.
4. Axios sends the token as a Bearer token for protected requests.
5. Spring Security validates the token for secured API access.

## Local Development Notes

- The backend uses an in-memory H2 database, so data resets when the backend restarts.
- Seed data is automatically loaded on backend startup.
- The frontend uses `http://localhost:8080/api` as the default API base URL.
- CORS is configured to allow requests from `http://localhost:3000`.

## Current Tech Summary

- React 18
- Redux
- Axios
- Formik + Yup
- Bootstrap 4
- Spring Boot 4
- Spring Security
- Spring Data JPA
- JWT
- H2
- Swagger/OpenAPI
