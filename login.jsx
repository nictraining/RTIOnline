import React, { useState } from 'react'
import Button from './button'

const LoginForm = () => {
  const [formData, setFormData] = useState({
    role: 'Appellate Authority [01]',
    officerName: '',
    username: 'tpsc_user',
    password: ''
  })

  const handleInputChange = (e) => {
    const { name, value } = e.target
    setFormData(prev => ({
      ...prev,
      [name]: value
    }))
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    console.log('Form submitted:', formData)
  }

  const handleReset = () => {
    setFormData({
      role: 'Appellate Authority [01]',
      officerName: '',
      username: 'tpsc_user',
      password: ''
    })
  }

  return (
    <div className="login-section">
      <div className="login-actions">
        <Button variant="secondary">View Login User List</Button>
        <Button variant="primary">Add New Login User</Button>
      </div>

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label className="form-label required">Select Role :</label>
          <select
            name="role"
            value={formData.role}
            onChange={handleInputChange}
            className="form-select"
          >
            <option value="Appellate Authority [01]">Appellate Authority [01]</option>
            <option value="Public Information Officer [02]">Public Information Officer [02]</option>
            <option value="Nodal Officer [03]">Nodal Officer [03]</option>
          </select>
        </div>

        <div className="form-group">
          <label className="form-label required">Select officer Name :</label>
          <input
            type="text"
            name="officerName"
            value={formData.officerName}
            onChange={handleInputChange}
            className="form-input"
            placeholder="Enter officer name"
          />
          <div className="form-note">
            In this role username and password are not created.
          </div>
        </div>

        <div className="form-group">
          <label className="form-label required">Enter Username :</label>
          <input
            type="text"
            name="username"
            value={formData.username}
            onChange={handleInputChange}
            className="form-input"
          />
        </div>

        <div className="form-group">
          <label className="form-label required">Enter Password :</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleInputChange}
            className="form-input"
          />
        </div>

        <div className="form-actions">
          <Button type="submit" variant="primary">Submit</Button>
          <Button type="button" variant="secondary" onClick={handleReset}>Reset</Button>
        </div>
      </form>
    </div>
  )
}

export default LoginForm