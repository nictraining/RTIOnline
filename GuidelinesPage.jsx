import React from "react";

function GuidelinesPage() 
{
	return (
		<div className="max-w-5xl mx-auto p-6 bg-white shadow-md rounded-md mt-10">
			<h1 className="text-2xl font-bold text-center text-blue-800 mb-6">
				Guidelines for use of RTI Online Portal
			</h1>

			<div className="space-y-4">
				<div className="flex gap-2">
					<span className="font-bold text-blue-800">1</span>
					<p>This Web Portal can be used by Indian citizens to file RTI application online and also to make payment for RTI application online. First appeal can also be filed online.</p>
				</div>
				<div className="flex gap-2">
					<span className="font-bold text-blue-800">2</span>
					<p>
						An applicant who desires to obtain any information under the RTI Act can make a request through this Web Portal to the Departments/Public-Authorities/Others of Government of Tripura. List of Departments can be seen as following:
					</p>
				</div>

				<div className="bg-gray-100 p-4 rounded-md border border-gray-300 max-h-64 overflow-y-auto">
					<h3 className="font-semibold text-gray-700 mb-2">List of Departments</h3>
					<ul className="list-decimal pl-5 space-y-1">
						<li><a href="#" className="text-blue-600 underline">Fisheries Department</a></li>
						<li><a href="#" className="text-blue-600 underline">Food, Public Distribution and Consumer Affairs Department</a></li>
						<li><a href="#" className="text-blue-600 underline">General Administration Department</a></li>
						<li><a href="#" className="text-blue-600 underline">Handloom, Textile & Sericulture Department</a></li>
						<li><a href="#" className="text-blue-600 underline">Health and Family Welfare Department</a></li>
						<li><a href="#" className="text-blue-600 underline">Hill Areas Department</a></li>
					</ul>
				</div>

				<h2 className="text-xl font-bold mt-6 text-blue-800">
					Terms & Conditions for Payment and Refund Policy
				</h2>

				<div className="flex gap-2">
					<span className="font-bold text-blue-800">A</span>
					<p>The date of application will be, the date on which fees payment is made and fees will be calculated at the time of submission of fees.</p>
				</div>
				<div className="flex gap-2">
					<span className="font-bold text-blue-800">B</span>
					<p>The application fee once paid i.e. acknowledgment issued from the RTI Online Tripura website, will not be refunded in any case, even if the RTI application is rejected by the concerned authority.</p>
				</div>
				<div className="flex gap-2">
					<span className="font-bold text-blue-800">C</span>
					<p>The fee being paid is only towards the RTI application. The application fees once paid is non-refundable even if the application is rejected for any reason.</p>
				</div>
				<div className="flex gap-2">
					<span className="font-bold text-blue-800">D</span>
					<p>The application fee which is not acknowledged at RTI Online Tripura website (in case of Broken response) and the deduction has been made from the account of the citizen, will be refunded by the Bank Concern.</p>
				</div>

				<div className="flex items-center gap-2 mt-4">
					<input type="checkbox" id="agree" className="w-4 h-4" />
					<label htmlFor="agree" className="text-gray-800 text-sm">
						I have read and understood the above guidelines for use of RTI Online Portal (Assam)
					</label>
				</div>

				<div className="flex justify-start gap-4 mt-6">
					<button className="bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700">
						SUBMIT
					</button>
					<button className="bg-gray-300 text-black px-6 py-2 rounded hover:bg-gray-400">
						CANCEL
					</button>
				</div>
			</div>
		</div>
	);
}

export default GuidelinesPage;