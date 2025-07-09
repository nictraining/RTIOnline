// tanisha gr8
import React from 'react';
import './Assessment.css';

const Assessment = () => {
  return (
    <div className="assessment-table-wrapper">
          <h4>
            Fields prefixed with * are mandatory
          </h4>

      <table className="assessment-table">
        <tbody>
          <tr>
          <th>Registration No. (নিবন্ধন নম্বর):</th>
          <td colSpan="3">
            GOTI &nbsp;&nbsp;
            <a href="#" className="view-link">                |View Request Details|</a>
          </td>
        </tr>
          <tr>
            <th>Type of Receipt. (প্রাপ্তির ধরণ):</th>
            <td>Online Receipt</td>
          </tr>
          <tr>
            <th>Date of Receipt. (প্রাপ্তির তারিখ):</th>
            <td>05/02/2025</td>
          </tr>
          <tr>
            <th>Language of Request (অনুরোধের ভাষা):</th>
            <td>English</td>
          </tr>
          <tr>
            <th>Name (নাম):</th>
            <td className="no">XXXX  XXXX</td>
          </tr>
          <tr>
            <th>Gender (লিঙ্গ):</th>
            <td>Male</td>
          </tr>
          <tr>
            <th>Address (ঠিকানা):</th>
            <td>Bardowali</td>
          </tr>
          <tr>
            <th>Phone No. (ফোন নম্বর):</th>
            <td className="no">+91-XXXXXXXXXX</td>
          </tr>
          <tr>
            <th>Mobile No. (মোবাইল নম্বর):</th>
            <td className="no">+91-XXXXXXXXXX</td>
          </tr>
          <tr>
            <th>Email. (ইমেইল আইডি):</th>
            <td className="no">XXXXXXXXX</td>
          </tr>
          <tr>
            <th>Country (দেশ):</th>
            <td>India</td>
          </tr>
          <tr>
            <th>State (রাজ্য):</th>
            <td>Tripura</td>
          </tr>
          <tr>
            <th>Status (স্থিতি):</th>
            <td>Details not provided</td>
          </tr>
          <tr>
            <th>Educational Status (শিক্ষাগত অবস্থা):</th>
            <td>Details not provided</td>
          </tr>
          <tr>
            <th>Citizenship Status (নাগরিকত্বের অবস্থা):</th>
            <td>Indian</td>
          </tr>
          <tr>
            <th>Mode(s) of information Supply (তথ্য সরবরাহের মোড (গুলি)):</th>
            <td>Hard Copy</td>
          </tr>
          <tr>
            <th>Is Requester Below Poverty Line? (আবেদনকারী কি দারিদ্রদ্র্যসীমার নিচে?):</th>
            <td>No</td>
          </tr>
          <tr>
            <th>Amount Paid ((প্রদান করা অর্থ পরিমাণ) (₹)):</th>
            <td>0</td>
          </tr>
          <tr>
            <th>Does it concern the life or Liberty of a Person?(এটি কি একবান বাড়ির জীবন বা স্বাধীনদার সাথে সম্পর্কিত): </th>
            <td>Details not provided</td>
          </tr>
          <tr>
            <th>Request Pertains to (অনুরোধ সংশ্লিষ্ট) :</th>
            <td colSpan="3">SHRI</td>
          </tr>
          </tbody>
                </table>
            <h5>
                Text of RTI Application (আবেদন):
            <textarea className="rti-textarea"
              defaultValue={`Please provide the requested information within the stipulated time frame. If the information is not available, please inform me accordingly.
                
Thank you for your assistance.
                
Sincerely,`}
                />
                </h5>
      <table className="assessment-table">
        <tbody>
          <tr>
            <th>Please Select the Category of Request(অনুগ্রহ করে অনুরোধের বিভাগ নির্বাচন করুন):</th>
            <td colSpan="3">
              <select>
                <option>-- PLEASE SELECT CATEGORY --</option>
                <option>Public</option>
                <option>Private</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>* Decision (গিগাস্ত):</th>
            <td colSpan="3">
              <select>
                <option>REQUEST DISPOSE OF-</option>
                <option>Accepted</option>
                <option>Rejected</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>File No. (if any):</th>
            <td colSpan="3">
              <textarea className="file"name="" id=""></textarea>
            </td>
          </tr>
          <tr>
            <th>* Type of Disposal (নিষ্পত্তির বরন):</th>
            <td colSpan="3">
              <select>
                <option>Full Information Supplied</option>
                <option>Partially Supplied</option>
                <option>Rejected</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>* Information Provided To Citizen (To appear as a part of Covering Letter) (নাগরিকদের দেওয়া ডর্যা ৮/৯ (কভারিং সেটারের অংশ হিসাবে উপস্থিত
হতে) এই অনুরোধ এবং এর উত্তর (পিডিএফ নহি (গুনি সহ), যদি যতে) আপলোড করুন মন্ত্রণালয়/অধিদপ্তরে।):</th>
            <td colSpan="3">
              <textarea rows="3"></textarea>
            </td>
          </tr>
          <tr>
            <th>Upload Reply Document(রিপ্লাই ডকুমেন্ট আপলোড করুন ()):</th>
            <td colSpan="3">
              <input type="file" />
            </td>
          </tr>
          <tr>
            <th>Upload this Request and its Reply (optional PDF document(s), if any) onto the Ministry/Dept Website (ওয়েবসাইট):</th>
            <td colSpan="3">
              <label style={{ display: 'flex', alignItems: 'center', gap: '10px' }}>
                <input type="checkbox" />
              </label>
            </td>
          </tr>
          <tr>
            <td colSpan="4" style={{ textAlign: 'center' }}>
              <button type="submit">Submit</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};
export default Assessment;