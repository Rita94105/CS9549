// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginForm from './components/LoginForm';
import SignupForm from './components/RegisterForm';
import UserProfile from './components/UserProfile';
import HomePage from './components/HomePage';
import AccountBalance from './components/AccountBalance';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginForm />} />
        <Route path="/signup" element={<SignupForm />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/profile" element={<UserProfile />} />
        <Route path="/balance" element={<AccountBalance />} />
      </Routes>
    </Router>
  );
};

export default App;
