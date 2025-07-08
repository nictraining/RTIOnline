// tanisha gr8
import React from 'react';
import './Header.css';
import TripuraLogo from './tripura_logo.png';
import RTI_Logo from './rti_logo.webp';

const Header = () => {
  const navigateHome = () => {
    window.location.href = '/';
  };

  const handleCitizenLogin = () => {
    window.location.href = 'https://rtionline.assam.gov.in/login.php';
  };

  const handleOfficialLogin = () => {
    window.location.href = 'https://rtionline.assam.gov.in/mis/index.php';
  };

  return (
    <header className="header">
      <h1>Skip to main content  |  🌐English ▾</h1>
      <div className="header-desktop">
        <div className="left-logos">
          <img
            src={TripuraLogo}
            alt="TripuraLogo"
            onClick={navigateHome}
          />
          <div className="divider" />
          <img
            src={RTI_Logo}
            alt="RTI_Logo"
            onClick={navigateHome}
          />
        </div>

        <div className="header-center" onClick={navigateHome}>
          <div className="title">Right to Information Online Portal</div>
          <div className="subtitle">
            An initiative of Administrative Reforms, Training, Pension and Public Grievances Department, Government of Tripura
          </div>
        </div>

        <div className="login-dropdown">
          <button className="login-btn">🔒 LOGIN ▾</button>
          <div className="dropdown-content">
            <div onClick={handleCitizenLogin}>👤 Citizen Login</div>
            <div className="divider-line"></div>
            <div onClick={handleOfficialLogin}>🏛️ Official Login</div>
          </div>
        </div>
      </div>

      {/* Mobile View */}
      <div className="header-mobile">
        <img src="/images/tripura_logo.png" height="40" width="40" onClick={navigateHome} />
        <div className="mobile-text" onClick={navigateHome}>
          <div className="title-sm">Right to Information Online Portal</div>
          <div className="subtitle-sm">
            Administrative Reforms, Govt. of Tripura
          </div>
        </div>
        <img src="/images/rti_logo.png" height="40" width="60" onClick={navigateHome} />
      </div>
    </header>
  );
};

export default Header;
