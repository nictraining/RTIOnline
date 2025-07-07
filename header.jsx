import React from 'react'
import emblem from '../assets/Emblem_of_India.svg'
import rtilogo from '../assets/RIGHT_TO_INFORMATION_LOGO_23.svg'
import lock from '../assets/icons8-lock.svg'

const Header = () => {
  return (
    <header className="header">
      <div className="header-top">
        <div className="container">
          <div className="header-nav">
            <div className="flex header-actions justify-end">
              <a href="#" className="skip-link">Skip to main content</a>
              <select className="language-selector">
                <option>English</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      
      <div className="header-main">
        <div className="container">
          <div className="header-content">
            <div className="logo-section">
              <div className="logo">
                <img src={emblem} alt="" style={{width: '30px' ,height: 'auto'}} />
              </div>
              <div className="logo">
                <img src={rtilogo} alt="" style={{width:'40px', height:'auto'}}/>
              </div>
              <div className="title-section">
                <h1>Right to Information Online Portal</h1>
                <p className="subtitle">
                  An Initiative of Administrative Reforms, Training, Pension and Public Grievances Department, Government of Tripura
                </p>
              </div>
            </div>
            <button className="login-btn"><img src={lock} alt="" style={{width:'15px', height:'12px'}}/> LOGIN</button>
          </div>
        </div>
      </div>
    </header>
  )
}

export default Header