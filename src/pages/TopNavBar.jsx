// tanisha gr8
import React from 'react';
import './TopNavBar.css';
import { Link } from 'react-router-dom';

const TopNavBar = () => {
  return (
    <nav className="top-navbar">
      <ul className="nav-links">
        <li><Link to="/">HOME</Link></li>
        <li><Link to="/search">SEARCH</Link></li>
        <li><Link to="/assignment">ASSIGNMENT</Link></li>
        <li><Link to="/utility">UTILITY</Link></li>
        <li><Link to="/reports">REPORTS</Link></li>
        <li><Link to="/logout">LOGOUT</Link></li>
      </ul>
    </nav>
  );
};

export default TopNavBar;
