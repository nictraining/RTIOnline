import React from 'react'
import LoginForm from '../COMPONENTS/login'

const Home = () => {
  return (
    <main className="main-content" id="main">
      <div className="welcome-section">
        <h2 className="welcome-title">Welcome to Nodal Officer</h2>
      </div>
      
      <div className="authority-info">
        <div className="authority-text">
          Public Authority: Tripura Public Service Commission
        </div>
        <div className="role-text">
          Role : Nodal Officer
        </div>
      </div>
      
      <LoginForm />
    </main>
  )
}

export default Home