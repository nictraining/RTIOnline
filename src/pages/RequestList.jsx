// RequestList.jsx
// Created by Anjali Yadav – RTI Request List Page

import React from 'react';
import './RequestList.css'; 

const RequestList = () => {
  const dummyData = [
    { id: 1, applicant: 'Ravi Sharma', date: '2025-06-12', status: 'Pending' },
    { id: 2, applicant: 'Anjali Verma', date: '2025-06-10', status: 'Approved' },
    { id: 3, applicant: 'Nikhil Rao', date: '2025-06-09', status: 'Rejected' },
  ];

  return (
    <div className="request-list">
      <h2>RTI Requests (Nodal Officer)</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Applicant</th>
            <th>Date</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {dummyData.map((req) => (
            <tr key={req.id}>
              <td>{req.id}</td>
              <td>{req.applicant}</td>
              <td>{req.date}</td>
              <td>{req.status}</td>
              <td><button>View</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default RequestList;
