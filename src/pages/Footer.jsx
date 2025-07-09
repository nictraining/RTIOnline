// tanisha gr8
import React from 'react';
import VisitorCounter from './VisitorCounter';
import './Footer.css';

const Footer = () => {
  const links = [
  ];

  return (
    <footer className="footer">
      {/* Desktop View */}
      <div className="footer-links desktop">
        {links.map((link, idx) => (
          <React.Fragment key={link.label}>
            <a
              href={link.href}
              target={link.external ? '_blank' : '_self'}
              rel={link.external ? 'noopener noreferrer' : ''}
              className="footer-link"
            >
              {link.label}
              {link.external && <sup>↗</sup>}
            </a>
            {idx < links.length - 1 && <span className="divider">|</span>}
          </React.Fragment>
        ))}
      </div>

      {/* Mobile View */}
      <div className="footer-links mobile">
        <div className="quick-title">Quick Links</div>
        {links.map((link) => (
          <a
            key={link.label}
            href={link.href}
            target={link.external ? '_blank' : '_self'}
            rel={link.external ? 'noopener noreferrer' : ''}
            className="footer-link block"
          >
            {link.label}
            {link.external && <sup>↗</sup>}
          </a>
        ))}
      </div>

      {/* Footer Text */}
      <div className="footer-text desktop">
        <p>
          Contents of the portal is provided by Administrative Reforms, Training, Pension and Public Grievances Department, Govt. of Tripura
        </p>
        <p>
          © 2024. Maintained by Tripura Information Commission and Developed by NIC, Tripura
        </p>
      </div>

      <div className="footer-text mobile">
        <p>
          Contents of the portal is provided by Administrative Reforms, Training, Pension and Public Grievances Department, Govt. of Tripura
        </p>
        <p>
          © 2024. Maintained by Tripura Information Commission and Developed by NIC, Tripura
        </p>
      </div>

      <VisitorCounter />
    </footer>
  );
};

export default Footer;
