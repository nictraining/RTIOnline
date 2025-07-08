import React from 'react'
import './App.css'
import Header from './components/header'
import LoginForm from './components/loginform'
import Footer from './components/footer'

function App() {
  return (
    <div className="app">
      <Header />
      <main className="main-content">
        <div className="container">
          <div className="login-section">
            <h2 className="official-login-title">Official Login</h2>
            <LoginForm />
          </div>
        </div>
      </main>
      <Footer />
    </div>
  )
}

export default App