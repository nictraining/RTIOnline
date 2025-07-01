import { Routes, Route } from "react-router-dom"
import Login from "./pages/Login"
import Dashboard from "./pages/Dashboard"

export default function App() {
return (
<Routes>
  <Route path="/" element={<Login />} />
  <Route path="/dashboard" element={<Dashboard />} />
</Routes>

)
}