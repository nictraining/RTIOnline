import React, { useState } from "react";

export default function SubmitRTI() {
  const [department, setDepartment] = useState("");
  const [question, setQuestion] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`RTI Submitted for department: ${department}`);
    setDepartment("");
    setQuestion("");
  };

  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center">
      <form onSubmit={handleSubmit} className="bg-white p-6 rounded shadow-md w-96">
        <h2 className="text-lg font-semibold mb-4">Submit RTI Request</h2>
        <input
          type="text"
          placeholder="Department"
          className="border p-2 w-full mb-3"
          value={department}
          onChange={(e) => setDepartment(e.target.value)}
          required
        />
        <textarea
          placeholder="Write your RTI query here..."
          className="border p-2 w-full mb-3 h-24"
          value={question}
          onChange={(e) => setQuestion(e.target.value)}
          required
        />
        <button type="submit" className="bg-blue-600 text-white px-4 py-2 w-full rounded">
          Submit RTI
        </button>
      </form>
    </div>
  );
}
