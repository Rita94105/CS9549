import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './LoginForm.css';

const LoginForm = () => {
  const [formData, setFormData] = useState({ email: '', username: '', password: '' });
  const navigate = useNavigate(); 

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post('http://localhost:7788/api/auth/login', formData);
      localStorage.setItem('token', res.data.token);
      console.log(`Welcome! Your token: ${res.data.token}`);
      localStorage.setItem('username', formData.username);
      console.log(formData.username);
      navigate('/home');
    } catch (err) {
      alert('Invalid credentials. Please try again.');
    }
  };

  return (
    <div className="login-container">
      <h2>Welcome Back!</h2>
      <form onSubmit={handleSubmit} className="login-form">
        <input
          name="email"
          onChange={handleChange}
          placeholder="Email"
          required
          className="login-input"
          type="email"
        />
        <input
          name="username"
          onChange={handleChange}
          placeholder="Username"
          required
          className="login-input"
        />
        <input
          name="password"
          onChange={handleChange}
          type="password"
          placeholder="Password"
          required
          className="login-input"
        />
        <button type="submit" className="login-button">Login</button>
      </form>
      <p className="signup-link">
        Don't have an account? <Link to="/signup">Sign up here</Link>
      </p>
    </div>
  );
};

export default LoginForm;
