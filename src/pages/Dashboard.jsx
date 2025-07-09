// tanisha gr8
import React from 'react';
import './Dashboard.css';

function Dashboard() {
  return (
    <div className="dashboard-container">
      {/* Header Section */}
      <div className="dashboard-header">
        <div className="left-title">PUBLIC AUTHORITY : Tripura Public Service Commission</div>
        <div className="center-title">
          Welcome to PIO Module of RTI-MIS
          <br />
          ROLE : PIO
        </div>
        <div className="right-title">USER : SHRI XXXX XXXX</div>
      </div>

      {/* Cards Section */}
      <div className="dashboard-cards">
        {/* Card 1 */}
        <div className="dashboard-card">
          <div className="card-icon">📩</div>
          <div className="card-label">
            <div className="card-title">PENDING FOR DISPOSED OFF</div>
            <div className="card-number">4</div>
          </div>
        </div>

        {/* Card 2 */}
        <div className="dashboard-card">
          <div className="card-icon">📩</div>
          <div className="card-label">
            <div className="card-title">RTI REQUESTS</div>
            <div className="highlight">NEW: <span className="card-number">3</span></div>
            <div className="highlight">UNDER PROCESS: <span className="card-number">6</span></div>
          </div>
        </div>

        {/* Card 3 */}
        <div className="dashboard-card">
          <div className="card-icon">📩</div>
          <div className="card-label">
            <div className="card-title">APPEALS</div>
            <div className="highlight">RAISED: <span className="card-number">6</span></div>
            <div className="highlight">DISPOSED: <span className="card-number">7</span></div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Dashboard;

