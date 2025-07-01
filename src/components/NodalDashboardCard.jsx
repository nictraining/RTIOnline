import React from 'react';
import '../pages/NodalDashboard.css';
import { FaEnvelopeOpen } from 'react-icons/fa';

export default function DashboardCard({ title, value }) {
  return (
    <div className="dashboard-card">
      <div className="card-icon">
        <FaEnvelopeOpen />
      </div>
      <div className="card-content">
        <p className="card-title">{title}</p>
        <p className="card-value">{value}</p>
      </div>
    </div>
  );
}