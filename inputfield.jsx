import React from 'react'

const InputField = ({ 
  type = 'text', 
  name, 
  placeholder, 
  value, 
  onChange, 
  icon,
  className = ''
}) => {
  const handleChange = (e) => {
    onChange(e.target.value)
  }

  return (
    <div className={`form-group ${className}`}>
      <div className="input-wrapper">
        {icon && <span className="input-icon">{icon}</span>}
        <input
          type={type}
          name={name}
          placeholder={placeholder}
          value={value}
          onChange={handleChange}
          className="form-input"
          required
        />
      </div>
    </div>
  )
}

export default InputField