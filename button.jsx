import React from 'react'

const Button = ({ 
  children, 
  type = 'button', 
  variant = 'primary', 
  onClick, 
  disabled = false,
  className = ''
}) => {
  const baseClass = 'login-button'
  const variantClass = variant === 'secondary' ? 'btn-secondary' : ''
  const classes = `${baseClass} ${variantClass} ${className}`.trim()

  return (
    <button
      type={type}
      className={classes}
      onClick={onClick}
      disabled={disabled}
    >
      {children}
    </button>
  )
}

export default Button