import React from 'react';
import { Navbar, Container } from 'react-bootstrap';

const BottomBar = () => {
  const message =
    'For any queries related to the RTI Tripura portal, please contact 0361-2337900 during normal office hours 09:30-18:00 on working days or send an email to help-desk[dot]rtionline[at]tripura[dot]gov[dot]in';

  return (
    <Navbar expand="lg" className="p-1" style={{ backgroundColor: '#f0f0f0' }}>
      <Container fluid className="justify-content-center text-center px-3">
        {/* Desktop view */}
        <div className="d-none d-lg-block">{message}</div>

        {/* Mobile view */}
        <div className="d-lg-none small">{message}</div>
      </Container>
    </Navbar>
  );
};

export default BottomBar;
