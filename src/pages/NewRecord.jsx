import React, { useState } from 'react';
//Subhendu 8 pio record

const RTIPortal = () => {
  const [currentPage, setCurrentPage] = useState('recordsNewRequest');

  const navigateToPage = (pageName) => {
    setCurrentPage(pageName);
  };

  const Header = () => (
    <div className="bg-gradient-to-r from-blue-800 via-blue-700 to-blue-600 text-white">
      <div className="max-w-6xl mx-auto px-4 py-3">
        <div className="flex items-center justify-between">
          <div className="flex items-center space-x-4">
            <div className="w-12 h-12 bg-white rounded-full flex items-center justify-center">
              <div className="w-8 h-8 bg-blue-600 rounded-full flex items-center justify-center">
                <span className="text-white text-xs font-bold">RTI</span>
              </div>
            </div>
            <div>
              <h1 className="text-xl font-semibold">Right to Information Online Portal</h1>
              <p className="text-sm text-blue-200">An Initiative of Administrative Reforms, Training, Pension and Public Grievances Department, Govt. of Tripura</p>
            </div>
          </div>
          <div className="text-right">
            <div className="text-sm">USER : SHRI XXXX XXXX</div>
            <div className="text-xs text-blue-200">ROLE : PIO</div>
          </div>
        </div>
      </div>
    </div>
  );

  const Navigation = () => (
    <div className="bg-blue-600 text-white">
      <div className="max-w-6xl mx-auto">
        <nav className="flex space-x-1">
          <button className="px-4 py-2 hover:bg-blue-700 transition-colors">HOME</button>
          <button className="px-4 py-2 hover:bg-blue-700 transition-colors">SEARCH</button>
          <button className="px-4 py-2 hover:bg-blue-700 transition-colors">ASSESSMENT</button>
          <button className="px-4 py-2 hover:bg-blue-700 transition-colors">UTILITY</button>
          <button className="px-4 py-2 hover:bg-blue-700 transition-colors">REPORTS</button>
          <button className="px-4 py-2 hover:bg-blue-700 transition-colors">LOGOUT</button>
        </nav>
      </div>
    </div>
  );

  const RecordsNewRequestPage = () => (
    <div className="max-w-6xl mx-auto p-6 bg-white">
      <div className="mb-6">
        <div className="bg-blue-100 p-3 rounded">
          <h2 className="text-lg font-semibold text-blue-800">Welcome to PIO Module of RTI MIS</h2>
        </div>
      </div>

      <div className="mb-4">
        <label className="block text-sm font-medium mb-2">
          Items per page: 
          <select className="ml-2 border border-gray-300 rounded px-2 py-1">
            <option>25</option>
            <option>50</option>
            <option>100</option>
          </select>
        </label>
      </div>

      <div className="overflow-x-auto">
        <table className="w-full border-collapse border border-gray-300">
          <thead>
            <tr className="bg-gray-200">
              <th className="border border-gray-300 px-4 py-2 text-left">S.L.</th>
              <th className="border border-gray-300 px-4 py-2 text-left">Registration Number (RTI/IT/RTI)</th>
              <th className="border border-gray-300 px-4 py-2 text-left">Name (RTI)</th>
              <th className="border border-gray-300 px-4 py-2 text-left">Received Date (DD/MM/YYYY)</th>
              <th className="border border-gray-300 px-4 py-2 text-left">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr className="hover:bg-gray-50">
              <td className="border border-gray-300 px-4 py-2">1.</td>
              <td className="border border-gray-300 px-4 py-2">OFFICER</td>
              <td className="border border-gray-300 px-4 py-2 text-red-600">XXXX XXXX</td>
              <td className="border border-gray-300 px-4 py-2">00/00/0000</td>
              <td className="border border-gray-300 px-4 py-2">
                <button 
                  onClick={() => navigateToPage('assessment')}
                  className="bg-blue-500 hover:bg-blue-700 text-white px-3 py-1 rounded text-sm transition-colors"
                >
                  View Details
                </button>
              </td>
            </tr>
            <tr className="hover:bg-gray-50">
              <td className="border border-gray-300 px-4 py-2">2.</td>
              <td className="border border-gray-300 px-4 py-2">OFFICER</td>
              <td className="border border-gray-300 px-4 py-2 text-red-600">XXXX XXXX</td>
              <td className="border border-gray-300 px-4 py-2">00/00/0000</td>
              <td className="border border-gray-300 px-4 py-2">
                <button 
                  onClick={() => navigateToPage('assessment')}
                  className="bg-blue-500 hover:bg-blue-700 text-white px-3 py-1 rounded text-sm transition-colors"
                >
                  View Details
                </button>
              </td>
            </tr>
            <tr className="hover:bg-gray-50">
              <td className="border border-gray-300 px-4 py-2">3.</td>
              <td className="border border-gray-300 px-4 py-2">OFFICER</td>
              <td className="border border-gray-300 px-4 py-2 text-red-600">XXXX XXXX</td>
              <td className="border border-gray-300 px-4 py-2">00/00/0000</td>
              <td className="border border-gray-300 px-4 py-2">
                <button 
                  onClick={() => navigateToPage('assessment')}
                  className="bg-blue-500 hover:bg-blue-700 text-white px-3 py-1 rounded text-sm transition-colors"
                >
                  View Details
                </button>
              </td>
            </tr>
            <tr className="hover:bg-gray-50">
              <td className="border border-gray-300 px-4 py-2">4.</td>
              <td className="border border-gray-300 px-4 py-2">OFFICER</td>
              <td className="border border-gray-300 px-4 py-2 text-red-600">XXXX XXXX</td>
              <td className="border border-gray-300 px-4 py-2">00/00/0000</td>
              <td className="border border-gray-300 px-4 py-2">
                <button 
                  onClick={() => navigateToPage('assessment')}
                  className="bg-blue-500 hover:bg-blue-700 text-white px-3 py-1 rounded text-sm transition-colors"
                >
                  View Details
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );

  const AssessmentPage = () => (
    <div className="max-w-6xl mx-auto p-6 bg-white">
      <div className="mb-4">
        <button 
          onClick={() => navigateToPage('recordsNewRequest')}
          className="bg-gray-500 hover:bg-gray-700 text-white px-4 py-2 rounded text-sm transition-colors mb-4"
        >
          ← Back to List
        </button>
      </div>

      <div className="bg-gray-100 p-4 rounded mb-6">
        <div className="grid grid-cols-2 gap-4 text-sm">
          <div><strong>Registration No. (RTI/TPIC/xxx):</strong></div>
          <div><strong>RTI Track Number :</strong></div>
          <div><strong>Name of Applicant (RTI/TPIC):</strong> XXXXXXX</div>
          <div><strong>Date of Receipt (DD/MM/YYYY):</strong> XX/XX/XXXX</div>
          <div><strong>Language of Request (Regional /Hindi / English):</strong> English</div>
          <div><strong>Mode of Payment:</strong></div>
          <div><strong>Gender (PIO):</strong> Male</div>
          <div><strong>Category (General/SC/ST/OBC):</strong> OBC</div>
          <div><strong>Fees (PIO):</strong> Required</div>
          <div><strong>Challan No. :</strong> xxxxxxxxxxxxxxxxx</div>
          <div><strong>Bank Name (PIO):</strong></div>
          <div><strong>Date of Deposit :</strong> xx/xx/xxxx</div>
          <div><strong>Quality (PIO):</strong> Male</div>
          <div><strong>Complete Address (Including Pincode):</strong> xxxxx xx xxxxxxx</div>
          <div><strong>Educational Status (Priority report):</strong> Under not provided</div>
          <div><strong>Economic Status Priority report):</strong> Male</div>
          <div><strong>Mobile No:</strong></div>
          <div><strong>E-mail Address :</strong></div>
          <div><strong>RTI Request (Details):</strong></div>
          <div><strong>Under Section :</strong></div>
          <div><strong>Is Economic Category Below Poverty Line ? (Under Sub Rule 2A of RTI Rule 2006) Pl.</strong></div>
          <div><strong>choose applicant related eligibility criteria otherwise application will be rejected:</strong> No</div>
        </div>
      </div>

      <div className="mb-6">
        <label className="block text-sm font-medium mb-2">
          Please provide the requested information within the stipulated time frame. If the information is not available, please advise us accordingly.
        </label>
        <textarea 
          className="w-full border border-gray-300 rounded p-3 h-24"
          placeholder="Enter your response..."
        ></textarea>
      </div>

      <div className="grid grid-cols-2 gap-4 mb-6">
        <div>
          <label className="block text-sm font-medium mb-2">
            Details from Eligible Category of Educated (Right) and Research Status (Right) applied - 
            (From the PIO/ CPIO - Pl.)
          </label>
          <select className="w-full border border-gray-300 rounded p-2">
            <option>Select Category of</option>
          </select>
        </div>
        <div>
          <label className="block text-sm font-medium mb-2">
            The OIC of work
          </label>
          <input type="text" className="w-full border border-gray-300 rounded p-2" />
        </div>
      </div>

      <div className="mb-6">
        <label className="block text-sm font-medium mb-2">
          Type of Information Furnished to Citizen (CPIO/Sub rule3(b) of RTI Rules 2005/06), fill this when applicants submitted:
        </label>
        <textarea 
          className="w-full border border-gray-300 rounded p-3 h-24"
          placeholder="All information is as per RTI Rules 06, 07 sub we request applicants affidavit..."
        ></textarea>
      </div>

      <div className="grid grid-cols-3 gap-4 mb-6">
        <div>
          <label className="block text-sm font-medium mb-2">Date &Time Document:</label>
          <input type="text" className="w-full border border-gray-300 rounded p-2" placeholder="Date & Time" />
        </div>
        <div>
          <label className="block text-sm font-medium mb-2">Other Fee and Details Information fee paid amount charged for the additional research data/Time</label>
          <input type="text" className="w-full border border-gray-300 rounded p-2" />
        </div>
        <div>
          <label className="block text-sm font-medium mb-2">(information fees and application fees according)</label>
          <input type="text" className="w-full border border-gray-300 rounded p-2" />
        </div>
      </div>

      <div className="text-center">
        <button className="bg-blue-500 hover:bg-blue-700 text-white px-6 py-2 rounded transition-colors">
          Submit
        </button>
      </div>
    </div>
  );

  const Footer = () => (
    <div className="bg-blue-600 text-white mt-8">
      <div className="max-w-6xl mx-auto px-4 py-4 text-center">
        <p className="text-sm">Contents of this portal is provided by Administrative Reforms, Training, Pension and Public Grievances Department, Govt. of Tripura</p>
        <p className="text-xs mt-2">Copyright © 2015. All Rights Reserved. This portal is Maintained by Tripura Information Commission and Designed & Developed by National Information Centre, Tripura</p>
      </div>
    </div>
  );

  return (
    <div className="min-h-screen bg-gray-50">
      <Header />
      <Navigation />
      
      <div className="py-6">
        <div className="max-w-6xl mx-auto px-4">
          <div className="mb-4">
            <h2 className="text-xl font-semibold text-blue-800">
              {currentPage === 'recordsNewRequest' ? 'Step 3: List of Request' : 'Step 4: Request Details'}
            </h2>
            <p className="text-sm text-gray-600">
              Page Name: {currentPage}
            </p>
          </div>
          
          {currentPage === 'recordsNewRequest' ? <RecordsNewRequestPage /> : <AssessmentPage />}
        </div>
      </div>
      
      <Footer />
    </div>
  );
};

export default RTIPortal;
