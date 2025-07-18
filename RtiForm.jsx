import React from "react";
import "./RtiForm.css";

function RtiForm() {
  return (
    <div className="rti-page">
      <header>
        <div className="top-header">
          <img src="/National_Emblem_India.jpg" alt="India Emblem" />
          <div>
            <h2>Right to Information Online Portal</h2>
            <p>
              An initiative of Administrative Reforms, Training, Pension and
              Public Grievances Department, Government of Tripura
            </p>
          </div>
        </div>

        <nav>
          <ul>
            <li>Home</li>
            <li>Application List</li>
            <li>Search Application</li>
            <li>Master Updation</li>
            <li>Change Password</li>
            <li className="active">Create/Deactivate Login</li>
            <li>Logout</li>
          </ul>
        </nav>
      </header>

      <main>
        <h3>CREATE/DEACTIVATE LOGIN</h3>
        <form className="rti-form">
          <div className="radio-group">
            <label>
              <input type="radio" name="action" value="create" /> Create Login
            </label>
            <label>
              <input type="radio" name="action" value="deactivate" /> Deactivate Login
            </label>
          </div>

          <div className="form-grid">
            <label>Name:</label>
            <input type="text" placeholder="Enter full name" />

            <label>Gender:</label>
            <select>
              <option value="">Select</option>
              <option>Male</option>
              <option>Female</option>
              <option>Other</option>
            </select>

            <label>Designation:</label>
            <input type="text" placeholder="Enter designation" />

            <label>Department:</label>
            <input type="text" placeholder="Enter department" />

            <label>Office Address:</label>
            <textarea rows="3" placeholder="Enter address"></textarea>

            <label>Mobile Number:</label>
            <input type="tel" placeholder="Enter mobile number" />

            <label>Email:</label>
            <input type="email" placeholder="Enter email" />

            <label>Username:</label>
            <input type="text" placeholder="Create username" />

            <label>Password:</label>
            <input type="password" placeholder="Create password" />
          </div>

          <p className="warning">
            * Deactivation will delete the login permanently.
          </p>

          <div className="button-group">
            <button type="submit">Submit</button>
            <button type="reset">Reset</button>
          </div>
        </form>
      </main>

      <footer>
        <p>
          This is the official portal of the Government of Tripura. Designed,
          Developed and Maintained by National Informatics Centre, Tripura State Centre.
        </p>
      </footer>
    </div>
  );
}

export default RtiForm;
