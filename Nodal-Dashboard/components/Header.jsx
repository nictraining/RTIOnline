import React from 'react';
import emblem from '../assets/emblem.png';
import rtiLogo from '../assets/rti-logo.png';

const Header = () => {
  return (
    <div className="top-bar">
      <div className="logos">
        <img src={emblem} alt="National Emblem" className="logo" />
        <img src={rtiLogo} alt="RTI Logo" className="logo" />
      </div>
      <div className="portal-title">
        <h1>Right to Information Online Portal</h1>
        <p>
          An initiative of Administrative Reforms, Training, Pension and Public Grievances Department, Government of Tripura
        </p>
      </div>
      <div className="skip-language">
        <span>Skip to main content | </span>
        <select>
          <option>English</option>
          <option>বাংলা</option>
        </select>
      </div>
    </div>
  );
};

export default Header;
