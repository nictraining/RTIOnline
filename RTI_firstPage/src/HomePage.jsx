import React from "react";

export default function HomePage() {
  return (
    <div className="p-4 space-y-6">
      <header className="bg-blue-800 text-white text-center p-4 text-xl font-semibold rounded">
        Right to Information Online Portal - Government of Tripura
      </header>

      <section className="grid grid-cols-4 gap-4 text-center">
        {[
          { label: "Request for RTI", icon: "📝" },
          { label: "Payment through eGRAS", icon: "💳" },
          { label: "Auto Assigning of SPIO", icon: "⚙️" },
          { label: "Reply to RTI Request", icon: "📩" },
        ].map((step, i) => (
          <div key={i} className="bg-white rounded shadow p-4">
            <div className="text-3xl mb-2">{step.icon}</div>
            <p>{step.label}</p>
          </div>
        ))}
      </section>

      <section className="bg-white p-6 shadow rounded">
        <h2 className="text-lg font-semibold mb-2">
          Welcome to the RTI Online Portal, <span className="text-blue-600">Tripura</span>
        </h2>
        <p className="text-sm text-gray-600 mb-4">
          File RTI applications and appeals online with government departments. Use eGRAS for payment. Make sure to read instructions.
        </p>

        <div className="grid grid-cols-4 gap-4">
          <div className="bg-red-100 text-center rounded p-3">
            <h3 className="text-red-700 font-bold text-xl">1182</h3>
            <p className="text-sm">Public Authorities</p>
          </div>
          <div className="bg-green-100 text-center rounded p-3">
            <h3 className="text-green-700 font-bold text-xl">1176</h3>
            <p className="text-sm">SPIO Registered</p>
          </div>
          <div className="bg-blue-100 text-center rounded p-3">
            <h3 className="text-blue-700 font-bold text-xl">666</h3>
            <p className="text-sm">RAA Registered</p>
          </div>
          <div className="bg-purple-100 text-center rounded p-3">
            <h3 className="text-purple-700 font-bold text-xl">826</h3>
            <p className="text-sm">FAA Registered</p>
          </div>
        </div>
      </section>

      <footer className="bg-blue-800 text-white text-sm text-center p-3 rounded">
        Content provided by Administrative Reforms Department, Tripura Government. Maintained by NIC.
      </footer>
    </div>
  );
}
