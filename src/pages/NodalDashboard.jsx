import React, { useEffect, useState } from 'react';
import './NodalDashboard.css';
import DashboardCard from '../components/NodalDashboardCard';


function DashboardNodal(){
  // 1. This state will store The personal info of the Officer , Which will be 
  //    Passed in the jwt-Token to the local Storage while login 
  const [userDetails, setUserDetails] = useState({
    publicAuthority: 'Hello',
    role: 'Hello',
    user: 'Hello'
  });

  // This state will store the Dashboard values 
  const [dashboardData, setDashboardData] = useState({
    newRequests: 0,
    newAppeals: 0,
    requestDocs: 0
  });


  useEffect(() => {
    const token = localStorage.getItem('authToken');
    if (token) {
      (async () => {
        try {
          const module = await import('jwt-decode');
          const jwt_decode = module.default;

          const decoded = jwt_decode(token);
          setUserDetails({
            publicAuthority: decoded.publicAuthority || '',
            role: decoded.role || '',
            user: decoded.username || ''
          });
        } catch (err) {
          console.error("JWT decode failed", err);
        }
      })();
    }
  }, []);

  
  useEffect(() => {
    const fetchDashboardData = async () => {
      try {
        const response = await fetch('/'); // Need to be replaced with actual API endpoint
        const data = await response.json();

        setDashboardData({
          newRequests: data.newRequests,
          newAppeals: data.newAppeals,
          requestDocs: data.requestDocs
        });
      } catch (error) {
        console.error("Failed to fetch dashboard data:", error);
      }
    };

    fetchDashboardData();
  }, []);

  return (
    <div className="dashboard-wrapper">
      <div className="dashboard-header">
        <div>Welcome to Nodal Officer Module of RTI-MIS</div>       
      </div>

      <div className="info-strip">
        <div className="info-item">
          Public Authority: <strong>{userDetails.publicAuthority}</strong>
        </div>
        <div className="info-item">
          Role : <strong>{userDetails.role}</strong>
        </div>
        <div className="info-item">
          User : <strong>{userDetails.user}</strong>
        </div>
      </div>

      <div className="dashboard-cards">
        <DashboardCard title="New Request(s)" value={dashboardData.newRequests} />
        <DashboardCard title="New Appeal(s)" value={dashboardData.newAppeals} />
        <DashboardCard title="Request Document(s) Called" value={dashboardData.requestDocs} />
      </div>
    </div>
  );
}

export default DashboardNodal;
