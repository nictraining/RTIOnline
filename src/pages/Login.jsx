//Krishita Grp 10
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { User, KeyRound, RefreshCw } from 'lucide-react'



export default function Login() {
const navigate = useNavigate()
const [username, setUsername] = useState('')
const [password, setPassword] = useState('')

const handleLogin = () => {
  if (!username.trim() || !password.trim()) {
    alert('Please enter username and password')
    return
  }

  navigate('/dashboard')
}

  return (
    <div className="min-h-screen bg-white flex flex-col items-center">
      <div className="w-full bg-black text-white text-sm py-1 px-4 flex justify-end">
        <span className="mr-4">Skip to main content</span>
        <span>🌐 English ▾</span>
      </div>

      <div className="w-full max-w-5xl px-4 pt-6">
        <div className="text-center mb-2">
          <h1 className="text-xl font-semibold text-blue-800">Right to Information Online Portal</h1>
          <p className="text-sm text-gray-500">An initiative of Administrative Reforms, Training, Pension and Public Grievances Department, Government of Tripura</p>
        </div>

        <div className="text-center my-3">
          <h2 className="text-lg text-blue-900 font-medium">Official Login</h2>
        </div>

        <div className="mx-auto max-w-md bg-white border rounded-xl shadow-md p-6 space-y-4">
          <div className="flex items-center border rounded px-3 py-2">
            <User className="w-4 h-4 text-gray-500 mr-2" />
            <input
type="text"
placeholder="Enter Username"
className="w-full outline-none"
value={username}
onChange={(e) => setUsername(e.target.value)}
/>
          </div>
          <div className="flex items-center border rounded px-3 py-2">
            <KeyRound className="w-4 h-4 text-gray-500 mr-2" />
            <input
type="password"
placeholder="Enter Password"
className="w-full outline-none"
value={password}
onChange={(e) => setPassword(e.target.value)}
/>
          </div>
          <div className="flex flex-col space-y-1">
            <div className="flex justify-between items-center">
              <img src="https://dummyimage.com/200x50/cccccc/000&text=Ie1GK9" alt="captcha" className="h-10 object-cover" />
              <button type="button" className="text-xs text-blue-600 flex items-center gap-1">
                <RefreshCw className="w-3 h-3" /> Refresh
              </button>
            </div>
            <input type="text" placeholder="Enter Captcha Code" className="border rounded px-3 py-2 outline-none" />
          </div>
          <button
onClick={handleLogin}
type="button"
className="w-full bg-gray-600 text-white py-2 rounded hover:bg-gray-700 transition">
            LOGIN
          </button>
          <p className="text-center text-sm text-gray-600">
            Forgot Password? <a href="#" className="text-blue-600 hover:underline">Click Here to Reset</a>
          </p>
        </div>
      </div>

      <footer className="mt-10 text-xs text-white bg-blue-800 text-center w-full py-4 px-2 space-y-1">
        <p>Contents of the portal is provided by Administrative Reforms, Training, Pension and Public Grievances Department, Govt. of Tripura</p>
        <p>&copy; 2025. All Rights Reserved. Maintained by Tripura Information Commission and Developed by NIC Tripura.</p>
      </footer>
    </div>
  )
}
