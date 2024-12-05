# ExchangeFX- Your Flexible Path to Global Wealth

Group 10  - Aja Khanal, Jing Wang, Chih-Hsuan Jen, Yang Zijian, Saif Abbas

Professor - Nazim Madhavji 

## Introduction

This is a full-stack application built with React and Node.js, featuring user registration, login, user profile management, and account balance inquiry functionalities.

## Features

- User Registration
- User Login
- User Profile Management
- Account Balance Inquiry
- Real-time and Historical Exchange Rates
- Forex News

## Tech Stack

- Frontend: React, Axios, React Router
- Backend: Node.js, Express, MongoDB, Mongoose, JWT, bcrypt
- Styling: CSS, Flexbox

## Installation

### Frontend

1. Navigate to the frontend directory:

   ```bash
   cd frontend
2. Install dependencies:
   ```
   npm install
   ```
3. Start the frontend development server:
   ```
   npm start
   ```

### Backend
1. Navigate to the backend directory:
   ```
   cd backend
   ```
2. Install dependencies:
   ```
   npm install
   ```
3. Start the backend server:
   ```
   npm start
   ```

### Environment Variables

Create a .env file in the backend directory and add the following content:

```
MONGO_URI=your_mongodb_connection_string
JWT_SECRET=your_jwt_secret
CORS_ORIGIN=http://localhost:3000
```

### Usage

- Registration
  1. Open your browser and navigate to http://localhost:3000/signup
  2. Fill out the registration form and submit
- Login
  1. Open your browser and navigate to http://localhost:3000/
  2. Fill out the login form and submit
- User Profile Management
  1. After logging in, navigate to http://localhost:3000/profile
  2. View and edit user profile
- Account Balance Inquiry
  1. After logging in, navigate to http://localhost:3000/balance
  2. View account balances
- Real-time and Historical Rate Selection
  - https://application-a1.1p0sj4mn37zu.ca-tor.codeengine.appdomain.cloud/
- Forex News
  - 

### Project Structure

```
my-project/
├── backend/
│   ├── models/
│   │   └── User.js
│   ├── routes/
│   │   ├── [auth.js](http://_vscodecontentref_/1)
│   │   └── userProfile.js
│   ├── .env
│   ├── server.js
│   └── package.json
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── LoginForm.js
│   │   │   ├── SignupForm.js
│   │   │   ├── UserProfile.js
│   │   │   ├── AccountBalance.js
│   │   │   └── HomePage.js
│   │   ├── assets/
│   │   │   └── styles/
│   │   │       ├── LoginForm.css
│   │   │       ├── UserProfile.css
│   │   │       ├── AccountBalance.css
│   │   │       └── HomePage.css
│   │   ├── App.js
│   │   └── index.js
│   ├── public/
│   ├── package.json
│   └── .env
└── [README.md](http://_vscodecontentref_/2)
```