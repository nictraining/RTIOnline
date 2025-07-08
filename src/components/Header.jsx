import React, { useState } from 'react';
import { Navbar, Container, Nav, Dropdown, Image } from 'react-bootstrap';
import 'bootstrap-icons/font/bootstrap-icons.css';

const Header = () => {
  const [showDropdown, setShowDropdown] = useState(false);

  const navigateHome = () => {
    // window.location.href = 'https://rtionline.tripura.gov.in/';  // Home Url
    window.location.href = '/';
  };

  return (
    <Navbar expand="lg" className="sticky-top bg-white shadow pb-0 pb-lg-2 pt-1 pt-md-2 z-3" id="NavBar">
      {/* Desktop View */}
      <Container className="d-none d-lg-flex justify-content-between">
        {/* Left Logos */}
        <Navbar.Brand className="d-flex align-items-center gap-2">
          <Image
            src="./images/tripura_logo.png"
            srcSet="./images/tripura_logo.png 1x, ./images/tripura_logo.png 2x"
            height="75"
            onClick={navigateHome}
            alt="Tripura Logo"
            style={{ cursor: 'pointer' }}
          />
          <div style={{ width: '1px', height: '60px', backgroundColor: '#000', opacity: 0.4 }}></div>
          <Image
            src="./images/rti_logo.png"
            srcSet="./images/rti_logo.webp 1x, ./images/ 2x"
            height="75"
            onClick={navigateHome}
            alt="RTI Logo"
            style={{ cursor: 'pointer' }}
          />
        </Navbar.Brand>

        {/* Center Text */}
        <div className="text-center">
          <div className="text-primary fw-bold fs-3" style={{ cursor: 'pointer' }} onClick={navigateHome}>
            Right to Information Online Portal
          </div>
          <div className="fw-medium text-secondary fs-6" style={{ cursor: 'pointer' }} onClick={navigateHome}>
            An initiative of Administrative Reforms, Training, Pension and Public Grievances Department, Government of Tripura
          </div>
        </div>

        {/* Login Dropdown */}
        <div className="position-relative">
          <Dropdown show={showDropdown} onToggle={() => setShowDropdown(!showDropdown)} align="end">
            <Dropdown.Toggle className="btn btn-dark primary-bg rounded-pill border-0 px-3 py-2 d-inline-flex align-items-center gap-2 fw-bold">
              <i className="fa fa-lock fs-6"></i> LOGIN
            </Dropdown.Toggle>

            <Dropdown.Menu className="mt-2 p-0 rounded">
              <Dropdown.Item onClick={() => (window.location.href = 'https://rtionline.assam.gov.in/login.php')} className="py-2 px-4 fw-medium">
                <i className="fa fa-user"></i> Citizen Login
              </Dropdown.Item>
              <Dropdown.Divider className="m-0" />
              <Dropdown.Item onClick={() => (window.location.href = 'https://rtionline.assam.gov.in/mis/index.php')} className="py-2 px-4 fw-medium">
                <i className="fa fa-bank"></i> Official Login
              </Dropdown.Item>
            </Dropdown.Menu>
          </Dropdown>
        </div>
      </Container>

      {/* Mobile View */}
      <Container fluid className="d-lg-none row pe-0 pb-1 m-0">
        <div className="col-2 p-0">
          <Image
            src="./images/tripura_logo.png"
            srcSet="./images/tripura_logo.png 1x, ./images/tripura_logo.png 2x"
            height="45"
            width="45"
            onClick={navigateHome}
            alt="Tripura Logo"
            style={{ cursor: 'pointer' }}
          />
        </div>
        <div className="col-8 text-center overflow-hidden p-0">
          <div className="text-primary fw-bold f-small" onClick={navigateHome} style={{ cursor: 'pointer' }}>
            Right to Information Online Portal
          </div>
          <div className="text-wrap w-100" style={{ fontSize: '8px' }}>
            An initiative of Administrative Reforms, Training, Pension and Public Grievances Department, Government of Assam
          </div>
        </div>
        <div className="col-2 text-end p-0">
          <Image
            src="./images/rti_logo.png"
            srcSet="./images/rti_logo.webp 1x, ./images/rti_logo.webp 2x"
            height="40"
            width="60"
            onClick={navigateHome}
            alt="RTI Logo"
            style={{ cursor: 'pointer' }}
          />
        </div>
      </Container>
    </Navbar>
  );
};

export default Header;