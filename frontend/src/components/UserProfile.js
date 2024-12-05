import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './UserProfile.css';

const UserProfile = () => {
  const [userData, setUserData] =  useState({ email: 'test01@uwo.ca', username: 'test01', password: '$2b$10$zoJzd2zr1mzzjlcKG5loMe5nnGkiStf4H7XDrA2inq1mm1U5TxIM.' });

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const token = localStorage.getItem('token');
        const res = await axios.get('http://localhost:7788/api/auth/profile', {
          headers: { Authorization: `Bearer ${token}` },
        });
        setUserData(res.data);
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    };

    fetchUserData();
  }, []);

  return (
    <div className="user-profile">
      <h1>User Profile</h1>
      {userData ? (
        <div className="profile-info">
          <div className="form-group">
            <label><strong>Email:</strong></label>
            <input
              type="email"
              name="email"
              value={userData.email}
              required
            />
          </div>
          <div className="form-group">
            <label><strong>Password:</strong></label>
            <input
              type="password"
              name="password"
              value={userData.password}
              required
            />
          </div>
        </div>
      ) : (
        <p>Loading...</p>
      )}
      <div className="buttons">
        <button className="profile-button">Save Profile</button>
      </div>
    </div>
  );
};

export default UserProfile;