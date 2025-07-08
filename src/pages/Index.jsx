//Subhendu Datta 8
import React from 'react';
import { Home, Search, FileText, Users, BarChart, LogOut, Clock, AlertCircle, CheckCircle } from 'lucide-react';

const DashboardIndex = () => {
  return (
    <div className="min-h-screen bg-gray-50">
      {/* Header */}
      <div className="bg-white shadow-sm border-b">
        <div className="flex items-center justify-between px-6 py-3">
          <div className="flex items-center space-x-3">
            <div className="w-12 h-12 bg-blue-600 rounded-lg flex items-center justify-center">
              <div className="w-6 h-6 bg-white rounded"></div>
            </div>
            <div>
              <h1 className="text-lg font-semibold text-gray-800">Right to Information Online Portal</h1>
              <p className="text-sm text-gray-600">An Initiative of Administrative Reforms, Training, Pension and Public Grievances Department, Government of Tripura</p>
            </div>
          </div>
          <div className="flex items-center space-x-4">
            <span className="text-sm text-gray-600">USER : SHRI XXXX XXXX</span>
            <button className="bg-blue-600 text-white px-4 py-2 rounded text-sm hover:bg-blue-700">
              LOGIN
            </button>
          </div>
        </div>
      </div>

      {/* Navigation */}
      <div className="bg-blue-600 text-white">
        <div className="px-6 py-3">
          <nav className="flex space-x-8">
            <a href="#" className="flex items-center space-x-2 hover:text-blue-200 text-blue-200">
              <Home className="w-4 h-4" />
              <span>HOME</span>
            </a>
            <a href="#" className="flex items-center space-x-2 hover:text-blue-200">
              <Search className="w-4 h-4" />
              <span>SEARCH</span>
            </a>
            <a href="#" className="flex items-center space-x-2 hover:text-blue-200">
              <FileText className="w-4 h-4" />
              <span>ASSESSMENT</span>
            </a>
            <a href="#" className="flex items-center space-x-2 hover:text-blue-200">
              <Users className="w-4 h-4" />
              <span>UTILITY</span>
            </a>
            <a href="#" className="flex items-center space-x-2 hover:text-blue-200">
              <BarChart className="w-4 h-4" />
              <span>REPORTS</span>
            </a>
            <a href="#" className="flex items-center space-x-2 hover:text-blue-200">
              <LogOut className="w-4 h-4" />
              <span>LOGOUT</span>
            </a>
          </nav>
        </div>
      </div>

      {/* Step Indicator */}
      <div className="bg-gray-100 px-6 py-4">
        <div className="flex items-center justify-between">
          <div className="flex items-center space-x-2">
            <span className="text-blue-600 font-medium">Step 2:</span>
            <span className="text-gray-800 font-medium">Dashboard</span>
          </div>
          <div className="flex items-center space-x-2">
            <span className="text-sm text-gray-600">Page Name:</span>
            <span className="text-sm font-medium text-gray-800">index</span>
          </div>
        </div>
      </div>

      {/* Main Content */}
      <div className="px-6 py-8">
        <div className="mb-6">
          <div className="flex items-center justify-between">
            <div>
              <h2 className="text-lg font-semibold text-gray-800">PUBLIC AUTHORITY : Tripura Public Service Commission</h2>
              <p className="text-sm text-gray-600">Welcome to PIO Module of RTI-MIS</p>
              <p className="text-sm text-gray-600">ROLE : PIO</p>
            </div>
            <div className="text-right">
              <p className="text-sm text-gray-600">USER : SHRI XXXX XXXX</p>
            </div>
          </div>
        </div>

        {/* Dashboard Cards */}
        <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
          {/* Pending For Disposal Card */}
          <div className="bg-white rounded-lg shadow-md border border-orange-200">
            <div className="p-6">
              <div className="flex items-center justify-between mb-4">
                <div className="bg-orange-100 p-3 rounded-lg">
                  <Clock className="w-8 h-8 text-orange-600" />
                </div>
                <div className="text-right">
                  <div className="text-2xl font-bold text-orange-600">4</div>
                </div>
              </div>
              <h3 className="text-sm font-medium text-gray-700 mb-2">PENDING FOR DISPOSAL OFF</h3>
              <div className="text-xs text-gray-500">
                Applications awaiting action
              </div>
            </div>
          </div>

          {/* RTI Requests Under Process Card */}
          <div className="bg-white rounded-lg shadow-md border border-blue-200">
            <div className="p-6">
              <div className="flex items-center justify-between mb-4">
                <div className="bg-blue-100 p-3 rounded-lg">
                  <AlertCircle className="w-8 h-8 text-blue-600" />
                </div>
                <div className="text-right">
                  <div className="text-2xl font-bold text-blue-600">2</div>
                </div>
              </div>
              <h3 className="text-sm font-medium text-gray-700 mb-2">RTI REQUESTS UNDER PROCESS</h3>
              <div className="text-xs text-gray-500">
                Applications in progress
              </div>
            </div>
          </div>

          {/* Appeals Disposed Card */}
          <div className="bg-white rounded-lg shadow-md border border-green-200">
            <div className="p-6">
              <div className="flex items-center justify-between mb-4">
                <div className="bg-green-100 p-3 rounded-lg">
                  <CheckCircle className="w-8 h-8 text-green-600" />
                </div>
                <div className="text-right">
                  <div className="text-2xl font-bold text-green-600">7</div>
                </div>
              </div>
              <h3 className="text-sm font-medium text-gray-700 mb-2">APPEALS DISPOSED</h3>
              <div className="text-xs text-gray-500">
                Completed applications
              </div>
            </div>
          </div>
        </div>

        {/* Quick Actions */}
        <div className="mt-8">
          <h3 className="text-lg font-semibold text-gray-800 mb-4">Quick Actions</h3>
          <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
            <button className="bg-blue-600 text-white p-4 rounded-lg hover:bg-blue-700 transition-colors">
              <FileText className="w-6 h-6 mx-auto mb-2" />
              <span className="text-sm">New Request</span>
            </button>
            <button className="bg-orange-600 text-white p-4 rounded-lg hover:bg-orange-700 transition-colors">
              <Clock className="w-6 h-6 mx-auto mb-2" />
              <span className="text-sm">Pending Items</span>
            </button>
            <button className="bg-green-600 text-white p-4 rounded-lg hover:bg-green-700 transition-colors">
              <CheckCircle className="w-6 h-6 mx-auto mb-2" />
              <span className="text-sm">Completed</span>
            </button>
            <button className="bg-purple-600 text-white p-4 rounded-lg hover:bg-purple-700 transition-colors">
              <BarChart className="w-6 h-6 mx-auto mb-2" />
              <span className="text-sm">Reports</span>
            </button>
          </div>
        </div>
      </div>

      {/* Footer */}
      <div className="bg-blue-600 text-white text-center py-4 mt-16">
        <p className="text-sm">
          Contents of this portal is provided by Administrative Reforms, Training, Pension and Public Grievances Department, Govt. of Tripura
        </p>
        <p className="text-sm mt-1">
          Copyright © 2025. All Rights Reserved. This portal is Maintained by Tripura Information Commission and Designed & Developed by National Informatics Centre, Tripura
        </p>
      </div>
    </div>
  );
};

export default DashboardIndex;
