import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './RegisterForm.css';

const RegisterForm = () => {
  const [formData, setFormData] = useState({ email: '', username: '', password: '' });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post('http://localhost:7788/api/auth/register', formData);
      localStorage.setItem('token', res.data.token);
      console.log(`Welcome! Your token: ${res.data.token}`);
      localStorage.setItem('username', res.data.username);
      console.log(res.data.message);
      navigate('/home');
    } catch (err) {
      alert('Error: Could not register. Please try again.');
    }
  };

  return (
    <div className="register-container">
      <h2>Create an Account</h2>
      <form onSubmit={handleSubmit} className="register-form">
        <input
          name="email"
          onChange={handleChange}
          placeholder="Email"
          required
          className="register-input"
          type="email"
        />
        <input
          name="username"
          onChange={handleChange}
          placeholder="Username"
          required
          className="register-input"
        />
        <input
          name="password"
          onChange={handleChange}
          type="password"
          placeholder="Password"
          required
          className="register-input"
        />
        <button type="submit" className="register-button">Sign Up</button>
      </form>
      <p className="login-link">
        Already have an account? <Link to="/">Log in here</Link>
      </p>
    </div>
  );
};

export default RegisterForm;
