import React, { useState } from "react";

const RTIRequestForm = () => {
  const CAPTCHA_TEXT = "7Odbx4";

  const [formData, setFormData] = useState({
    department: "Agriculture",
    name: "Test",
    gender: "Male",
    address1: "Dhaleswar",
    address2: "Road 3",
    address3: "Agartala",
    pincode: "799007",
    country: "India",
    state: "Tripura",
    district: "West Tripura",
    education: "Literate",
    phone: "0381230584",
    mobile: "9999999999",
    email: "test@gmail.com",
    citizenship: "Indian",
    bpl: "No",
    rtiText: "Text For RTI Request Application",
    file: null,
    captcha: "",
  });

  const [charCount, setCharCount] = useState(formData.rtiText.length);
  const [fileError, setFileError] = useState("");
  const [captchaError, setCaptchaError] = useState("");

  const handleChange = (e) => {
    const { name, value, files } = e.target;
    if (name === "file") {
      const file = files[0];
      if (file && file.name.includes(" ")) {
        setFileError("Filename should not have blank spaces.");
      } else {
        setFileError("");
      }
      setFormData({ ...formData, file });
      return;
    }
    if (name === "rtiText") setCharCount(value.length);
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (formData.captcha !== CAPTCHA_TEXT) {
      setCaptchaError("Incorrect captcha entered.");
      return;
    }
    setCaptchaError("");
    alert("RTI Request Submitted Successfully ✅");
  };

  const handleReset = () => {
    window.location.reload();
  };

  const Label = ({ text, required }) => (
    <label className="font-bold whitespace-nowrap">
      {required && <span className="text-red-600">*</span>} {text}
    </label>
  );

  return (
    <form
      onSubmit={handleSubmit}
      onReset={handleReset}
      className="max-w-5xl mx-auto my-10 p-6 border border-blue-500 rounded bg-white shadow"
    >
      <h1 className="text-center text-xl font-bold text-blue-700 mb-2">
        Online RTI Request Form
      </h1>
      <p className="text-center text-green-700 text-sm mb-4">
        Data to be entered only in English
        <span className="text-gray-700 ml-2">Note: Fields marked with * are Mandatory.</span>
      </p>

      <div className="mb-4">
        <label className="text-blue-700 font-semibold block mb-1">
          Public Authority Details:
        </label>
        <div className="grid grid-cols-2 gap-2 items-center border p-2">
          <Label text="Select Department/Public Authority" required />
          <select
            name="department"
            value={formData.department}
            onChange={handleChange}
            className="w-full border p-2 rounded"
          >
            <option value="">Select</option>
            <option value="Agriculture">Agriculture</option>
          </select>
        </div>
      </div>

      <div className="border border-gray-300 p-4 rounded mb-6">
        <h3 className="text-blue-700 font-semibold mb-4 text-lg">
          Personal Details of RTI Applicant:-
        </h3>

        <div className="grid grid-cols-1 gap-2">
          {[{ label: "Name", name: "name", required: true, type: "text" }].map((field) => (
            <div className="grid grid-cols-2 border">
              <div className="p-2">
                <Label text={field.label} required={field.required} />
              </div>
              <div className="p-2">
                <input
                  type={field.type}
                  name={field.name}
                  value={formData[field.name]}
                  onChange={handleChange}
                  className="w-full border p-2 rounded"
                />
              </div>
            </div>
          ))}

          <div className="grid grid-cols-2 border">
            <div className="p-2">
              <Label text="Gender" />
            </div>
            <div className="p-2">
              <label className="mr-4">
                <input type="radio" name="gender" value="Male" checked={formData.gender === 'Male'} onChange={handleChange} /> Male
              </label>
              <label>
                <input type="radio" name="gender" value="Female" checked={formData.gender === 'Female'} onChange={handleChange} /> Female
              </label>
            </div>
          </div>

          <div className="grid grid-cols-2 border">
            <div className="p-2">
              <Label text="Address" required />
            </div>
            <div className="p-2">
              {["address1", "address2", "address3"].map((line) => (
                <input
                  key={line}
                  type="text"
                  name={line}
                  value={formData[line]}
                  onChange={handleChange}
                  className="w-full border p-2 rounded mb-1"
                />
              ))}
            </div>
          </div>

          {["pincode", "country", "state", "district", "education", "phone", "mobile", "email"].map((field) => (
            <div key={field} className="grid grid-cols-2 border">
              <div className="p-2">
                <Label
                  text={
                    field === "pincode"
                      ? "Pincode"
                      : field === "country"
                      ? "Country"
                      : field === "state"
                      ? "State"
                      : field === "district"
                      ? "Districts"
                      : field === "education"
                      ? "Educational Status"
                      : field === "phone"
                      ? "Phone Number"
                      : field === "mobile"
                      ? "Mobile Number"
                      : "Email-ID"
                  }
                  required={field === "email"}
                />
              </div>
              <div className="p-2">
                {field === "country" ? (
                  <>
                    <label className="mr-4">
                      <input type="radio" name="country" value="India" checked={formData.country === 'India'} onChange={handleChange} /> India
                    </label>
                    <label>
                      <input type="radio" name="country" value="Other" checked={formData.country === 'Other'} onChange={handleChange} /> Other
                    </label>
                  </>
                ) : field === "state" ? (
                  <select name="state" value={formData.state} onChange={handleChange} className="w-full border p-2 rounded">
                    <option value="Tripura">Tripura</option>
                  </select>
                ) : field === "district" ? (
                  <select name="district" value={formData.district} onChange={handleChange} className="w-full border p-2 rounded">
                    <option value="West Tripura">West Tripura</option>
                  </select>
                ) : field === "education" ? (
                  <>
                    <label className="mr-4">
                      <input type="radio" name="education" value="Literate" checked={formData.education === 'Literate'} onChange={handleChange} /> Literate
                    </label>
                    <label>
                      <input type="radio" name="education" value="Illiterate" checked={formData.education === 'Illiterate'} onChange={handleChange} /> Illiterate
                    </label>
                  </>
                ) : (
                  <input
                    type={field === "email" ? "email" : "text"}
                    name={field}
                    value={formData[field]}
                    onChange={handleChange}
                    className="w-full border p-2 rounded"
                  />
                )}
              </div>
            </div>
          ))}
        </div>
      </div>

      <div className="border border-gray-300 p-4 rounded mb-6">
        <h3 className="text-blue-700 font-semibold mb-4 text-lg">
          Request Details :-
        </h3>

        <div className="grid grid-cols-2 border">
          <div className="p-2 font-bold">Citizenship</div>
          <div className="p-2">
            <select
              name="citizenship"
              value={formData.citizenship}
              onChange={handleChange}
              className="w-full border p-2 rounded"
            >
              <option value="Indian">Indian</option>
              <option value="Other">Other</option>
            </select>
          </div>
        </div>

        <div className="grid grid-cols-2 border">
          <div className="p-2 font-bold text-red-600">
            * Is the Applicant Below Poverty Line ?
          </div>
          <div className="p-2">
            <select
              name="bpl"
              value={formData.bpl}
              onChange={handleChange}
              className="w-full border p-2 rounded"
            >
              <option value="No">No</option>
              <option value="Yes">Yes</option>
            </select>
            {formData.bpl === "No" && (
              <div className="text-red-600 text-sm mt-1">
                You are required to pay the RTI fee of ₹ 10
              </div>
            )}
          </div>
        </div>

        <div className="border p-2 text-red-600 text-sm">
          <div className="font-bold">
            Note:- Only alphabets A-Z a-z number 0-9 and special characters , . - _ () / @ : & \ % are allowed in Text for RTI Request application.
          </div>
        </div>

        <div className="grid grid-cols-2 border">
          <div className="p-2 font-bold text-red-600">* Text for RTI Request application</div>
          <div className="p-2">
            <textarea
              name="rtiText"
              value={formData.rtiText}
              onChange={handleChange}
              rows={5}
              className="w-full border p-2 rounded"
            ></textarea>
            <div className="text-green-600 text-sm">{charCount}/3000 Characters entered</div>
          </div>
        </div>

        <div className="grid grid-cols-2 border">
          <div className="p-2 font-bold">
            Supporting document <span className="text-sm font-normal">(only pdf upto 1 MB)</span>
            <p className="text-blue-600 text-xs mt-1">
              Pdf file name should not have any blank space between any character. Special characters allowed are (a-zA-Z0-9-_)
            </p>
          </div>
          <div className="p-2">
            <input
              type="file"
              name="file"
              accept="application/pdf"
              onChange={handleChange}
              className="border p-2 rounded"
            />
            {fileError && <div className="text-red-600 text-sm">{fileError}</div>}
          </div>
        </div>

        <div className="grid grid-cols-2 border">
          <div className="p-2 font-bold text-red-600">* Enter Captcha code</div>
          <div className="p-2">
            <div className="bg-gray-300 text-black font-bold px-3 py-1 inline-block mb-1">
              {CAPTCHA_TEXT}
            </div>
            <input
              type="text"
              name="captcha"
              value={formData.captcha}
              onChange={handleChange}
              className="w-full border p-2 rounded"
              placeholder="Enter captcha here"
            />
            {captchaError && <div className="text-red-600 text-sm">{captchaError}</div>}
          </div>
        </div>
      </div>

      <div className="flex justify-center gap-4">
        <button type="submit" className="bg-blue-600 text-white px-6 py-2 rounded">Submit</button>
        <button type="reset" className="bg-gray-300 text-black px-6 py-2 rounded">Reset</button>
      </div>
    </form>
  );
};

export default RTIRequestForm;