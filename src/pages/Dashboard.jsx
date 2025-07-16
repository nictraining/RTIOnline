import React from 'react';
import './Dashboard.css';
import { useNavigate } from 'react-router-dom';

function Dashboard() {

   const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("isLoggedIn");
    navigate("/");
  };



  return (
    <div className="dashboard-container">
      {/* Header */}
      <header className="header">
        <div className="gov-logo">🇮🇳</div>
        <div className="portal-title">
          <h2>Right to Information Online Portal</h2>
          <p>
            An initiative of Administrative Reforms, Training, Pension and Public Grievances Department, Government of Tripura
          </p>
        </div>
        <div className="login-dropdown">
         <button onClick={handleLogout}>Logout</button>
        </div>
      </header>

      {/* Navigation Bar */}
      <nav className="navbar">
        <ul>
          <li>HOME</li>
          <li>SEARCH</li>
          <li>ASSIGNMENT</li>
          <li>UTILITY</li>
          <li>REPORTS</li>
          <li>REQUEST</li>
        </ul>
      </nav>

      {/* Dashboard Content */}
      <main className="dashboard-main">
        <div className="authority-info">PUBLIC AUTHORITY: Tripura Public Service Commission</div>

        <div className="card-container">
          <div className="dashboard-card">
            <p><strong>PENDING FOR DISPOSED OFF</strong></p>
            <p className="count red">4</p>
          </div>

          <div className="dashboard-card">
            <p><strong>RTI REQUESTS</strong></p>
            <p className="count">NEW: 3</p>
            <p className="count">UNDER PROCESS: 6</p>
          </div>

          <div className="dashboard-card">
            <p><strong>APPEALS</strong></p>
            <p className="count">RAISED: 6</p>
            <p className="count">DISPOSED: 7</p>
          </div>
        </div>
      </main>

      {/* Footer */}
      <footer className="footer">
        <p>Contents of the portal is provided by Administrative Reforms, Training, Pension and Public Grievances Department, Govt. of Tripura</p>
        <p>© 2024. Maintained by Tripura Information Commission and Developed by NIC, Tripura</p>
        <p>Visitor Count: 123456</p>
      </footer>
    </div>
  );
}

export default Dashboard;

