import React from "react";
import { Routes, Route } from "react-router-dom";
import LoginUIBootstrap from "./pages/LoginUIBootstrap";
import Dashboard from "./pages/Dashboard";

function App() {
  return (
    <Routes>
      <Route path="/RTIOnline/" element={<LoginUIBootstrap />} />
      <Route path="/RTIOnline/dashboard" element={<Dashboard />} />
    </Routes>
  );
}

export default App;
