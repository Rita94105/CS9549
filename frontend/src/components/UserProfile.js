import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './UserProfile.css';

const UserProfile = () => {
  const [userData, setUserData] = useState(null);

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const username = localStorage.getItem('username');
        console.log('Username:', username);
        const res = await axios.get(`http://localhost:7788/api/user/profile/${username}`);
        setUserData(res.data); // 假設的返回數據
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
          <p><strong>Email:</strong> {userData.email}</p>
          <p><strong>Name:</strong> {userData.username}</p>
          <p><strong>Joined:</strong> {userData.joined}</p>
        </div>
      ) : (
        <p>Loading...</p>
      )}
      <div className="buttons">
        <button className="profile-button">Edit Profile</button>
        <button className="profile-button">Change Password</button>
      </div>
    </div>
  );
};

export default UserProfile;