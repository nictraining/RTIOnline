import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <nav className="bg-blue-600 p-4 text-white">
      <ul className="flex space-x-4">
        <li><Link to="/pending-requests">Pending Requests</Link></li>
        <li><Link to="/nil-fee-report">NIL Fee Report</Link></li>
        <li><Link to="/designer-report">Designer Report</Link></li>
      </ul>
    </nav>
  );
}

export default Navbar;
