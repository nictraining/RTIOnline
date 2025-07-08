import React, { useEffect, useState } from 'react';

const ScrollToTopButton = () => {
  const [visible, setVisible] = useState(false);

  // Show button after scrolling down 100px
  useEffect(() => {
    const toggleVisibility = () => {
      setVisible(window.scrollY > 100);
    };

    window.addEventListener('scroll', toggleVisibility);
    return () => window.removeEventListener('scroll', toggleVisibility);
  }, []);

  const scrollToTop = () => {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  };

  if (!visible) return null;

  return (
    <button
      onClick={scrollToTop}
      className="btn btn-sm btn-info position-fixed end-0 m-3 z-3 rounded-circle d-flex align-items-center justify-content-center"
      style={{ width: '45px', height: '45px', bottom: '15px' }}
      aria-label="Go to top"
    >
      <i className="fa fa-arrow-up fs-5"></i>
    </button>
  );
};

export default ScrollToTopButton;
