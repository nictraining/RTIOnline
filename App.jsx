import React from 'react'
import Header from './COMPONENTS/header'
import Navigation from './COMPONENTS/navigation'
import Home from './main/home'
import Footer from './COMPONENTS/footer'
import './App.css'

function App() {
  return (
    <div className="App">
      <Header />
      <Navigation />
      <Home />
      <Footer />
    </div>
  )
}

export default App