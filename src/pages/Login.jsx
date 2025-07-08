// tanisha gr 8
import React, { useState } from 'react';
import './Login.css';

function Index() {
  const [captcha, setCaptcha] = useState('X9Z7P2');

  const handleCaptchaRefresh = () => {
    const chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let newCaptcha = '';
    for (let i = 0; i < 6; i++) {
      newCaptcha += chars.charAt(Math.floor(Math.random() * chars.length));
    }
    setCaptcha(newCaptcha);
  };

  return (
    <div className="index-container">
      <div className="box">
        <h2>Official Login</h2>
      </div>

      <div className="login-box">
        <div className="input-group">
         <span className="icon">👤</span>
         <input type="userid" placeholder="Enter Username" ></input>
        </div>
        <div className="input-group">
         <span className="icon">🔑</span>
        <input type="password" placeholder="Enter Password"></input>
        </div>
        <div className="captcha-area">
          <span className="captcha">{captcha}</span>
          <button onClick={handleCaptchaRefresh}>↻Refresh</button>
        </div>

        <div className="input-group">
         <input type="userid" placeholder="Enter Captcha" ></input>
        </div>

        <button className="login-submit">LOGIN</button>
        <p className="forgot">
          Forgot Password? <a href="#">Click here to reset</a>
        </p>
      </div> 
    </div>
  );
}

export default Index;
