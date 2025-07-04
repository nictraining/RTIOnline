import React from "react";
import "./App.css";

function App() {
  const requests = [
    { name: "Test 1", date: "05-02-2025" },
    { name: "Test 2", date: "04-02-2025" },
    { name: "Test 3", date: "02-02-2025" },
    { name: "Test 4", date: "01-02-2025" },
    { name: "Test 5", date: "31-01-2025" },
    { name: "Test 6", date: "31-01-2025" },
    { name: "Test 7", date: "31-01-2025" },
    { name: "Test 8", date: "30-01-2025" },
    { name: "Test 9", date: "30-01-2025" },
    { name: "Test 10", date: "28-01-2025" },
  ];

  return (
    <div className="container">
      <header>
        <div className="top-bar">
          <h3>Step 3: List of Request</h3>
          <div className="page-name">Page Name: recordsNewRequest</div>
        </div>
        <nav className="navbar">
          <ul>
            <li>HOME</li>
            <li>SEARCH</li>
            <li>ASSESSMENT</li>
            <li>MASTER UPDATION</li>
            <li>UTILITIES</li>
            <li>REPORT</li>
            <li>LOGIN HISTORY</li>
            <li>LOGOUT</li>
          </ul>
        </nav>
      </header>

      <main>
        <h4>Welcome to Nodal Officer Module of RTI-MIS</h4>
        <div className="user-info">
          <p>Public Authority: Tripura Public Service Commission</p>
          <p>Role: Nodal Officer</p>
          <p>User: SHRI A. BHATTACHERJEE</p>
        </div>
        <table>
          <thead>
            <tr>
              <th>S.No.</th>
              <th>Edit</th>
              <th>Registration Number</th>
              <th>Name</th>
              <th>Received Date</th>
            </tr>
          </thead>
          <tbody>
            {requests.map((req, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td>
                  <input type="radio" name="edit" />
                </td>
                <td>GOT/CPR/</td>
                <td>{req.name}</td>
                <td>{req.date}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </main>

      <footer>
        <p>
          Contents of the portal is provided by Administrative Reforms, Training, Pension and
          Public Grievances Department, Govt. of Tripura
        </p>
        <p>©️ 2025. All Rights Reserved. Maintained by Tripura Information Commission</p>
      </footer>
    </div>
  );
}

export default App;