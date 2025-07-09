import React, { useEffect } from 'react';

const HelpdeskSupportButton = () => {
  useEffect(() => {
    const button = document.getElementById('supportBtn');
    const text = document.getElementById('supportText');

    const handleMouseEnter = () => {
      text.style.display = 'block';
    };

    const handleMouseLeave = () => {
      text.style.display = 'none';
    };

    button.addEventListener('mouseenter', handleMouseEnter);
    button.addEventListener('mouseleave', handleMouseLeave);

    return () => {
      button.removeEventListener('mouseenter', handleMouseEnter);
      button.removeEventListener('mouseleave', handleMouseLeave);
    };
  }, []);

  return (
    <div
      className="btn btn-sm btn-warning position-fixed start-0 m-3 z-3 rounded-5 d-flex text-start align-items-start"
      id="supportBtn"
      style={{ cursor: 'auto', bottom: '15px' }}
    >
      <i className="fa fa-headset fs-3 mx-1 my-2"></i>
      <div id="supportText" className="mx-1 mx-md-3 text-dark" style={{ display: 'none' }}>
        {/* Desktop View */}
        <div className="d-none d-md-flex">Helpdesk Support No:</div>
        <div className="d-none d-md-flex">
          <a href="tel:03612337900" className="text-decoration-none text-dark fw-bold">
            0361-2337900
          </a>
        </div>

        {/* Mobile View */}
        <div className="d-md-none small">Helpdesk Support No:</div>
        <div className="d-md-none small">
          <a href="tel:03612337900" className="text-decoration-none text-dark fw-bold">
            0361-2337900
          </a>
        </div>
      </div>
    </div>
  );
};

export default HelpdeskSupportButton;
