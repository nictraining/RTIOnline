import React, { useState } from "react";
import "./App.css";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";


function App() {
  const navigate = useNavigate();
  const [captchaCode, setCaptchaCode] = useState(generateCaptcha());
  const [userCaptcha, setUserCaptcha] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  // Function to generate a random 6-character alphanumeric CAPTCHA
  function generateCaptcha() {
    const chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    let code = "";
    for (let i = 0; i < 6; i++) {
      code += chars.charAt(Math.floor(Math.random() * chars.length));
    }
    return code;
  }

  // Refresh the CAPTCHA code
  function refreshCaptcha() {
    setCaptchaCode(generateCaptcha());
  }

  // Handle Login Button Click
function handleLogin() {
  if (username !== "tathagata.nic" || password !== "hello1") {
    alert("Invalid username or password!");
    return;
  }

  if (userCaptcha !== captchaCode) {
    alert("Wrong CAPTCHA, try again!");
    return;
  }

  // ✅ All checks passed, redirect to dashboard
  navigate("/dashboard", { state: { loggedIn: true } });
}


  return (
    <div className="main-container">
      {/* Top Bar */}
      <header className="top-bar"></header>

      {/* Login Section */}
      <section className="login-section">
        {/* Banner */}
        <div className="banner">
          <div className="banner-text">
            <h1>Right to Information Online Portal</h1>
            <p className="rti">
              An initiative of Administrative Reforms, Training, Pension and
              Public Grievances Department, Government of Tripura
            </p>
          </div>
          <button className="login-btn">LOGIN</button>
        </div>

        {/* Official Login Title */}
        <h3 className="official-login">Official Login</h3>

        {/* Login Box */}
        <div className="login-box">
          <input
            type="text"
            placeholder="Enter Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <input
            type="password"
            placeholder="Enter Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />

          {/* CAPTCHA Display and Refresh */}
          <div className="captcha">
            <div className="captcha-box">{captchaCode}</div>
            <button className="refresh-btn" onClick={refreshCaptcha}>
              Refresh ↻
            </button>
          </div>

          {/* CAPTCHA Input */}
          <input
            type="text"
            placeholder="Enter Captcha Code"
            value={userCaptcha}
            onChange={(e) => setUserCaptcha(e.target.value)}
          />

          {/* Submit Button */}
          <button className="submit-btn" onClick={handleLogin}>
            LOGIN
          </button>

          {/* Forgot Password Section */}
          <p className="reset-link">
            <span className="forgot-text">Forgot Password?</span>{" "}
            <a href="#">Click Here to Reset</a>
          </p>
        </div>
      </section>

      {/* Footer */}
      <footer>
        <p>
          Contents of the portal is provided by Administrative Reforms,
          Training, Pension and Public Grievances Department, Govt. of Tripura
        </p>
        <p>
          Copyright © 2025. All Rights Reserved. This portal is Maintained by
          Tripura Information Commission and Designed & Developed by National
          Informatics Centre, Tripura
        </p>
      </footer>
    </div>
  );

  

// inside App()
useEffect(() => {
  if (localStorage.getItem("isLoggedIn") === "true") {
    navigate("/dashboard");
  }
}, []);
}

export default App;
