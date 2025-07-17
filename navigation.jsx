import React, { useState } from 'react'

const Navigation = () => {
  const [activeItem, setActiveItem] = useState('HOME')

  const navItems = [
    'HOME',
    'Application List',
    'Search Application',
    'Master Updation',
    'Change password',
    'Create/ Deactivate Login',
    'Logout'
  ]

  return (
    <nav className="navigation">
      <div className="nav-content">
        {navItems.map((item) => (
          <button
            key={item}
            className={`nav-item ${activeItem === item ? 'active' : ''}`}
            onClick={() => setActiveItem(item)}
          >
            {item}
          </button>
        ))}
      </div>
    </nav>
  )
}

export default Navigation