import React, { useState } from 'react'
import InputField from './inputfield'
import CaptchaField from './captcha'
import Button from './button'

const LoginForm = () => {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    captcha: ''
  })

  const handleInputChange = (name, value) => {
    setFormData(prev => ({
      ...prev,
      [name]: value
    }))
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    console.log('Login attempt:', formData)
    // Handle login logic here
  }

  return (
    <form className="login-form" onSubmit={handleSubmit}>
      <InputField
        type="text"
        name="username"
        placeholder="Enter Username"
        value={formData.username}
        onChange={(value) => handleInputChange('username', value)}
        icon="👤"
      />

      
      <InputField
        type="password"
        name="password"
        placeholder="Enter Password"
        value={formData.password}
        onChange={(value) => handleInputChange('password', value)}
        icon="🔒"
      />
      
      <CaptchaField
        value={formData.captcha}
        onChange={(value) => handleInputChange('captcha', value)}
      />
      
      <Button type="submit" variant="primary">
        LOGIN
      </Button>
      
      <div className="forgot-password">
        <span>Forgot Password? </span>
        <a href="#reset">Click Here to Reset</a>
      </div>
    </form>
  )
}

export default LoginForm