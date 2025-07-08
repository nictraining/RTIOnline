import React from 'react';
import Header from './components/Header';
import Navbar from './components/Navbar';
import InfoCards from './components/InfoCards';

const App = () => {
  return (
    <div className="page-wrapper">
      <Header />
      <Navbar />
      <main className="main-content">
        <p className="welcome-text">
          Public Authority: Tripura Public Service Commission
        </p>
        <h2 className="role-text">Welcome to Nodal Officer Module of RTI-MIS</h2>
        <div className="sub-role-text">
          <div className="role-left">Role : Nodal Officer</div>
          <div className="user-name">User : SHRI A. BHATTACHERJEE</div>
        </div>
        <InfoCards />
      </main>
      <footer className="footer">
        <p>
          Contents of the portal is provided by Administrative Reforms, Training, Pension and Public Grievances Department, Govt. of Tripura
        </p>
        <p>
          Copyright © 2025. All Rights Reserved. This portal is Maintained by Tripura Information Commission and Designed & Developed by National Informatics Centre, Tripura
        </p>
      </footer>
    </div>
  );
};

export default App;
