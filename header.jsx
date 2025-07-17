import React from 'react'
import emblem from '../assets/Emblem_of_India.svg'
import rti from '../assets/RIGHT_TO_INFORMATION_LOGO_23.svg'
const Header = () => {
  return (
    <header className="header">
      <div className="header-content">
        <div className="logo">
          <img 
            src={emblem} 
            alt="Government of India Logo" 
            className="logo"
          />
        </div>
        <div className="rti-icon">
            <img src={rti} alt="rti logo" style={{width:'85px', height:'auto'}}/>
          {/* <svg width="20" height="20" viewBox="0 0 24 24" fill="currentColor">
            <path d="M14,2H6A2,2 0 0,0 4,4V20A2,2 0 0,0 6,22H18A2,2 0 0,0 20,20V8L14,2M18,20H6V4H13V9H18V20Z"/>
          </svg> */}
        </div>
        <div className="header-text">
          <h1 className="header-title">Right to Information Online Portal</h1>
          <p className="header-subtitle">
            An initiative of Administrative Reforms, Training, Pension and Public Grievances Department, Government of Tripura
          </p>
        </div>
        <div className="header-actions">
          <a href="#main" className="skip-link">Skip to main content</a>
          <select className="language-selector">
            <option>🌐 English</option>
            <option>हिंदी</option>
          </select>
        </div>
      </div>
    </header>
  )
}

export default Header