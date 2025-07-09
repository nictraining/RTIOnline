// tanisha gr8
import React from 'react';
import './RecordsNewRequest.css';

const RecordsNewRequest = () => {
  const records = [
    { regNo: 'GOTPCR/', name: 'XXXXX XXXXX', date: '05/02/2025' },
    { regNo: 'GOTPCR/', name: 'XXXXX XXXXX', date: '18/01/2025' },
    { regNo: 'GOTPCR/', name: 'XXXXX XXXXX', date: '14/01/2025' },
    { regNo: 'GOTPCR/', name: 'XXXXX XXXXX', date: '14/01/2025' },
  ];

  return (
    <div className="records-container">
      {/* Top Text */}
      <div className="records-header">
        <div className="left-text">PUBLIC AUTHORITY : Tripura Public Service Commission</div>
        <div className="center-text">Welcome to PIO Module of RTI-MIS<br />ROLE : PIO</div>
        <div className="right-text">USER : SHRI XXXX XXXX</div>
      </div>

      {/* Table */}
      <table className="records-table">
        <thead>
          <tr>
            <th></th>
            <th>Registration Number<br />(নিবন্ধন নম্বর)</th>
            <th>Name<br />(নাম)</th>
            <th>Received Date<br />(প্রাপ্তির তারিখ)</th>
          </tr>
        </thead>
        <tbody>
          {records.map((rec, idx) => (
            <tr key={idx}>
              <td><input type="radio" name="select" /></td>
              <td>{rec.regNo}</td>
              <td className="bold-text">{rec.name}</td>
              <td>{rec.date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default RecordsNewRequest;
