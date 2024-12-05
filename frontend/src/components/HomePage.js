import React from 'react';
import { useNavigate } from 'react-router-dom';
import './HomePage.css'; // 引入 CSS 樣式

const HomePage = () => {
    const navigate = useNavigate(); // 用來進行頁面跳轉

  const goToProfile = () => {
    navigate('/profile'); // 重定向到用戶資料管理頁面
  };
  return (
    <div className="home-page">
      <h1>Welcome to Home Page</h1>
      <div className="buttons">
      <a href="https://application-a1.1p0sj4mn37zu.ca-tor.codeengine.appdomain.cloud/" className="home-button" target="_blank" rel="noopener noreferrer">
          S1 and S2
        </a>
        <button className="home-button">S5</button>
        <button className="home-button">S6</button>
        <button className="home-button" onClick={goToProfile}>User Profile</button>
      </div>
    </div>
  );
};

export default HomePage;
