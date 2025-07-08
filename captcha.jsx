import React, { useState, useEffect } from 'react'

const CaptchaField = ({ value, onChange }) => {
  const [captchaText, setCaptchaText] = useState('1e1GK9')

  const generateCaptcha = () => {
    const chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
    let result = ''
    for (let i = 0; i < 6; i++) {
      result += chars.charAt(Math.floor(Math.random() * chars.length))
    }
    setCaptchaText(result)
  }

  const handleRefresh = (e) => {
    e.preventDefault()
    generateCaptcha()
  }

  const handleInputChange = (e) => {
    onChange(e.target.value)
  }

  return (
    <div className="form-group">
      <div className="captcha-section">
        <div className="captcha-image">
          {captchaText}
        </div>
        <button 
          type="button" 
          className="refresh-btn" 
          onClick={handleRefresh}
          title="Refresh Captcha"
        >
          🔄 Refresh
        </button>
        <input
          type="text"
          placeholder="Enter Captcha Code"
          value={value}
          onChange={handleInputChange}
          className="captcha-input"
          required
        />
      </div>
    </div>
  )
}

export default CaptchaField