import React, { useState } from "react";
import { FaUser, FaKey } from "react-icons/fa";
import "./NodalOfficeLogin.css";

export default function NodalLogin() {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    captcha: ''
  });

  const [captchaUrl, setCaptchaUrl] = useState("/captcha-placeholder.png");

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const refreshCaptcha = () => {
    const timestamp = new Date().getTime();
    setCaptchaUrl(`/captcha-placeholder.png?${timestamp}`);
  };

  const handleLogin = async () => {
    if (!formData.username || !formData.password || !formData.captcha) {
      alert("Please fill in all fields.");
      return;
    }

    try {
      const response = await fetch("/", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
      });

      const result = await response.json();

      if (response.ok) {
        alert("Login successful!");
        console.log(result);
      } else {
        alert(`Login failed: ${result.message}`);
      }
    } catch (error) {
      console.error("Login error:", error);
      alert("An error occurred during login.");
    }
  };

  return (
    <div className="login-wrapper">
      <h2 className="login-title">Official Login</h2>
      <div className="login-box">
        <div className="input-group">
          <span className="icon user-icon"><FaUser /></span>
          <input
            type="text"
            name="username"
            placeholder="Enter Username"
            value={formData.username}
            onChange={handleChange}
          />
        </div>

        <div className="input-group">
          <span className="icon key-icon"><FaKey /></span>
          <input
            type="password"
            name="password"
            placeholder="Enter Password"
            value={formData.password}
            onChange={handleChange}
          />
        </div>

        <div className="captcha-group">
          <img src={captchaUrl} alt="captcha" className="captcha-img" />
          <button className="refresh-btn" onClick={refreshCaptcha}>↻ Refresh</button>
        </div>

        <input
          type="text"
          name="captcha"
          placeholder="Enter Captcha Code"
          className="captcha-input"
          value={formData.captcha}
          onChange={handleChange}
        />

        <button className="login-btn" onClick={handleLogin}>LOGIN</button>

        {
            // The forget Password Link needs to be attached Here .
        }
        <p className="forgot-text">
          Forgot Password? <a href="#">Click Here to Reset</a>  
        </p>
      </div>
    </div>
  );
}
