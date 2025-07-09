import React, { useState } from 'react';
import { Container, Row, Col, Card, Form, Button, ListGroup } from 'react-bootstrap';
import Breadcrumbs from './components/Breadcrumbs';

function Guidelines({ onSubmitGuidelines }) {
  const [citizenConsent, setCitizenConsent] = useState(false);

  const departments = [
    { id: 1, name: 'Act East Policy Affairs Department', url: 'https://assam.gov.in/business/438' },
    { id: 2, name: 'Administrative Reforms, Training, Pension & Public Grievance Department', url: 'https://art.assam.gov.in/' },
    { id: 3, name: 'Agriculture Department', url: 'https://agri-horti.assam.gov.in/' },
    { id: 4, name: 'Animal Husbandry & Veterinary Department', url: 'https://animalhusbandry.assam.gov.in/' },
    { id: 5, name: 'Assam Accord Implementation Department', url: 'http://assamaccord.assam.gov.in/' },
    { id: 6, name: 'Border Protection and Development Department', url: 'https://bpdd.assam.gov.in/' },
    { id: 7, name: 'Chief Minister Secretariat', url: 'https://cm.assam.gov.in/' },
    { id: 8, name: 'Co-operation Department', url: 'https://coop.assam.gov.in' },
    { id: 9, name: 'Cultural Affairs Department', url: 'https://culturalaffairs.assam.gov.in' },
    { id: 10, name: 'Education (Higher) Department', url: 'http://highereducation.assam.gov.in/' },
    { id: 11, name: 'Education (Technical) Department', url: 'http://dte.assam.gov.in/' },
    { id: 12, name: 'Election Department', url: 'http://ceoassam.nic.in/' },
    { id: 13, name: 'Environment & Forest Department', url: 'https://environmentandforest.assam.gov.in/' },
    { id: 14, name: 'Excise Department', url: 'https://excise.assam.gov.in' },
    { id: 15, name: 'Finance Department', url: 'https://finance.assam.gov.in/' },
    { id: 16, name: 'Fisheries Department', url: 'https://fisheries.assam.gov.in/' },
    { id: 17, name: 'Food, Public Distribution and Consumer Affairs Department', url: 'https://fcsca.assam.gov.in/' },
    { id: 18, name: 'General Administration Department', url: 'https://gad.assam.gov.in/' },
    { id: 19, name: 'Handloom, Textile & Sericulture Department', url: 'https://hts.assam.gov.in/' },
    { id: 20, name: 'Health and Family Welfare Department', url: 'https://hfw.assam.gov.in/' },
    { id: 21, name: 'Hill Areas Department', url: 'https://had.assam.gov.in/' },
    { id: 22, name: 'Home & Political Department', url: 'https://homeandpolitical.assam.gov.in/' },
    { id: 23, name: 'Housing and Urban Affairs Department', url: 'https://dohua.assam.gov.in/' },
    { id: 24, name: 'Indigenous and Tribal Faith and Culture Department', url: 'https://itfc.assam.gov.in/' },
    { id: 25, name: 'Industries, Commerce and Public Enterprise Department', url: 'https://industries.assam.gov.in/' },
    { id: 26, name: 'Information & Technology Department', url: 'https://it.assam.gov.in/' },
    { id: 27, name: 'Information, Public Relations, Printing & Stationery Department', url: 'https://iprd.assam.gov.in/' },
    { id: 28, name: 'Irrigation Department', url: 'https://irrigation.assam.gov.in/' },
    { id: 29, name: 'Judicial Department', url: 'https://judicial.assam.gov.in/' },
    { id: 30, name: 'Labour Welfare Department', url: 'https://labour.assam.gov.in/' },
    { id: 31, name: 'Legislative Department', url: 'https://legislative.assam.gov.in/' },
    { id: 32, name: 'Medical Education & Research Department', url: 'http://dme.assam.gov.in/' },
    { id: 33, name: 'Mines & Minerals Department', url: 'http://mines.assam.gov.in/' },
    { id: 34, name: 'Panchayat & Rural Development Department', url: 'https://pnrd.assam.gov.in/' },
    { id: 35, name: 'Parliamentary Affairs Department', url: 'https://parliamentaryaffairs.assam.gov.in/' },
    { id: 36, name: 'Personnel Department', url: 'https://personnel.assam.gov.in/' },
    { id: 37, name: 'Power (Electricity) Department', url: 'https://power.assam.gov.in/' },
    { id: 38, name: 'Public Health Engineering Department', url: 'https://phe.assam.gov.in/' },
    { id: 39, name: 'Public Works (Buildings & NH) Department', url: 'https://pwdbnh.assam.gov.in/' },
    { id: 40, name: 'Public Works (Roads) Department', url: 'https://pwdroads.assam.gov.in/' },
    { id: 41, name: 'Revenue and Disaster Management Department', url: 'https://landrevenue.assam.gov.in/' },
    { id: 42, name: 'School Education Department', url: 'https://education.assam.gov.in/' },
    { id: 43, name: 'Science, Technology and Climate Change Department', url: 'https://snt.assam.gov.in/' },
    { id: 44, name: 'Skill, Employment & Entrepreneurship Department', url: 'https://skill.assam.gov.in/' },
    { id: 45, name: 'Social Justice & Empowerment Department', url: 'http://socialjustice.assam.gov.in/' },
    { id: 46, name: 'Soil Conservation Department', url: 'http://soilconservation.assam.gov.in/' },
    { id: 47, name: 'Sports & Youth Welfare Department', url: 'http://sports.assam.gov.in/' },
    { id: 48, name: 'Tea Tribes and Adivasi Welfare Department', url: 'http://ttwd.assam.gov.in/' },
    { id: 49, name: 'Tourism Department', url: 'http://tourism.assam.gov.in/' },
    { id: 50, name: 'Transformation & Development Department', url: 'http://transdev.assam.gov.in/' },
    { id: 51, name: 'Transport Department', url: 'https://transport.assam.gov.in/' },
    { id: 52, name: 'Tribal Affairs (P) Department', url: 'http://wptbc.assam.gov.in/' },
    { id: 53, name: 'Water Resources (Flood Control) Department', url: 'https://waterresources.assam.gov.in/' },
    { id: 54, name: 'Welfare of Bodoland Department', url: 'https://wptbc.assam.gov.in/' },
    { id: 55, name: 'Welfare of Minorities and Development Department', url: 'http://minorities.assam.gov.in/' },
    { id: 56, name: 'Woman & Child Development Department', url: 'http://socialwelfare.assam.gov.in/' },
  ];

  const guidelines = [
    { id: 1, text: 'This Web Portal can be used by Indian citizens to file RTI application online and also to make payment for RTI application online. First appeal can also be filed online.' },
    { id: 2, text: 'An applicant who desires to obtain any information under the RTI Act can make a request through this Web Portal to the Departments/Public-Authorities/Others of Government of Assam. List of Departments/Public-Authorities/Others of Government of Assam can be seen as following:', isDepartmentsList: true },
    { id: 3, text: 'On clicking at "Submit Request", the applicant has to fill the required details on the page that will appear. The fields marked * are mandatory while the others are optional.' },
    { id: 4, text: 'The text of the application may be written at the prescribed column.' },
    { id: 5, text: 'At present, the text of an application that can be uploaded at the prescribed column is confined to 1000 words (Except Name, Address etc) only.' },
    { id: 6, text: 'After filling the first page, the applicant has to click on "Make Payment" to make payment of the prescribed fee.' },
    { id: 7, text: 'The applicant can pay the prescribed fee through the net banking.' },
    { id: 8, text: 'At present the RTI application fee is Rs.10 and is governed by Assam Right to Information (Regulation of fee and Cost) Rules, 2005' },
    { id: 9, text: 'Submission of RTI Request is subject to successful payment of the application fee. In cases where the payment status is not reflected due to delayed response from the Payment Aggregator or the Bank, applicants can manually verify the payment status through the View Status page. The date on which the payment is successfully verified shall be deemed as the date of submission of the RTI application.' },
    { id: 10, text: 'No RTI fee is required to be paid by any citizen who is below-poverty- line (BPL) as per RTI Act, 2005. However, the applicant must attach a copy of the certificate issued by the appropriate government in this regard, along with the application.' },
    { id: 11, text: 'On submission of an application, a unique registration number would be issued, which may be referred by the applicant for any references in future.' },
    { id: 12, text: 'The application filed through this Web Portal would reach electronically to the "Nodal Public Information Officer" of concerned Department/Public-Authority/ Others under Government of Assam, who would transmit the RTI application electronically to the concerned PIO.' },
    { id: 13, text: 'In case additional fee is required representing the cost for providing information (like for example copying and/or inspection charges), the PIO would intimate the applicant through this portal. This intimation can be seen by the applicant through Status Report under "View Status" or through his/her e-mail alert.' },
    { id: 14, text: 'For making an appeal to the first Appellate Authority, the applicant has to click at "Submit First Appeal" and fill up the page that will appear.' },
    { id: 15, text: 'The registration number of original application has to be used for reference.' },
    { id: 16, text: 'As per RTI Act, no fee has to be paid for first appeal.' },
    { id: 17, text: 'The applicant/the appellant should submit his/her mobile number and e-mail ID to receive SMS and e-mail alert/s respectively.' },
    { id: 18, text: 'Status of the RTI application/first appeal/additional fees required if any can be seen by the applicant/appellant by clicking at "View Status".' },
    { id: 19, text: 'All the requirements for filing an RTI application and first appeal as well as other provisions regarding time limit, exemptions etc., as provided in the RTI Act, 2005 will continue to apply.' },
  ];

  const termsAndConditions = [
    { id: 'A', text: 'The date of application will be the, date on which fees payment is made and fees will be calculated at the time of submission of fees.' },
    { id: 'B', text: 'The application fee once paid i.e acknowledgement issued from the RTI Online Assam website, will not be refunded in any case, even if, the RTI application is rejected by the concerned authority. Therefore the citizens are advised to go through the detailed Guidelines/FAQs and ensure their eligibility before making payment.' },
    { id: 'C', text: 'The fee being paid is only towards the RTI application. The application fees once paid is non-refundable even if the application is rejected for any reason.' },
    { id: 'D', text: 'The application fee which is not acknowledged at RTI Online Assam website (in case of Broken response) and the deduction has been made from the account of the citizen, will be refunded by the Bank Concern. The citizen will be required to contact to them. Government of Assam will not be liable in any such cases.' },
  ];

  const handleCheckboxChange = (event) => {
    setCitizenConsent(event.target.checked);
  };

  const handleCancelClick = () => {
    window.location.href = "/";
  };

  const breadcrumbItems = [
    { label: 'Home', link: '/' },
    { label: 'Guidelines', link: '/guidelines' }
  ];

  return (
    // Custom styles for this component
    <>
      <style>
        {`
        body {
            font-family: "Inter", sans-serif;
        }
        .main {
            background-image: url('./images/form-background.png'); /* Placeholder image */
            background-position: center;
            background-repeat: repeat;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px 0;
        }
        .primary {
            color: #0269b0;
        }
        .primary-bg {
            background-color: #0269b0;
            color: white;
        }
        .f-small {
            font-size: 0.75rem; /* Equivalent to f-small from original */
        }
        .f-sm-small {
            font-size: 0.875rem; /* Slightly larger for small screens if f-small was too tiny for buttons */
        }
        .form-title {
            color: #0269b0;
        }
        .rounded-5 {
            border-radius: 0.5rem !important; /* Tailwind's rounded-xl is closer to 0.75rem, but original used rounded-5 */
        }
        `}
      </style>
      {/* Font Awesome for icons */}
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" xintegrity="sha512-Fo3rlalHpgOq12p9rP8L+xXgq6P2O7XFjWjL+GkE1yF2w1o5+35W3m+eG6gqN3b+Pz0/7z+A7wE/Rj/g+Q==" crossOrigin="anonymous" referrerPolicy="no-referrer" />
        
      <div className="main">
        
        <Container className="mb-5 mt-xl-0 my-lg-5">
            <Breadcrumbs items={breadcrumbItems} />
          <div className="mb-3 form-title mb-md-4 pt-3 text-center">
            <h3 className="d-none primary d-md-block fw-bold">Guidelines for use of RTI Online Portal</h3>
            <h3 className="d-md-none primary f-small fw-bold">Guidelines for use of RTI Online Portal</h3>
          </div>
          <Card className="bg-light m-auto" style={{ boxShadow: '0 0 10px 2px rgba(100,100,100,.3)', borderBottom: '5px solid #0269b0', borderRadius: '15px' }}>
            <Form onSubmit={(e) => {
                e.preventDefault();
                if (citizenConsent && typeof onSubmitGuidelines === 'function') {
                    onSubmitGuidelines();
                }
                }}  className="p-3 p-lg-4" >
              <div className="mb-3" style={{ textAlign: 'justify' }}>
                {guidelines.map((item) => (
                  <Row key={item.id} className="mb-2">
                    <Col xs={2} md={1} xl={1}>
                      <div className="d-none d-md-flex align-items-center fs-5 justify-content-center primary-bg rounded-circle" style={{ width: '40px', height: '40px' }}>{item.id}</div>
                      <div className="d-md-none f-small align-items-center d-flex justify-content-center primary-bg rounded-circle text-center" style={{ width: '25px', height: '25px' }}>{item.id}</div>
                    </Col>
                    <Col xs={10} md={11} xl={11} className="ps-0">
                      <span className="d-none d-md-flex">{item.text}</span>
                      <span className="d-md-none f-small">{item.text}</span>
                      {item.isDepartmentsList && (
                        <Card className="col-md-8 mx-auto my-md-3 px-0 px-md-3 py-3">
                          <div className="form-title mb-4">
                            <h5 className="d-none primary d-md-block text-center">List of Departments</h5>
                            <h5 className="d-md-none text-center f-small primary">List of Departments</h5>
                            <ListGroup className="list-group-flush" style={{ maxHeight: '300px', overflowY: 'auto' }}>
                              {departments.map((dept) => (
                                <ListGroup.Item key={dept.id} className="d-flex gap-2 list-group-item-action">
                                  <span className="d-none d-md-flex">{dept.id}.</span>
                                  <a className="d-none d-md-flex fst-italic fw-medium text-decoration-none text-primary" href={dept.url} target="_blank" rel="noopener noreferrer">
                                    {dept.name} <small><sup><i className="fa-solid fa-arrow-up-right-from-square"></i></sup></small>
                                  </a>
                                  <span className="d-md-none f-small">{dept.id}.</span>
                                  <a className="d-md-none f-small fst-italic fw-medium text-decoration-none text-primary" href={dept.url} target="_blank" rel="noopener noreferrer">
                                    {dept.name} <small><sup><i className="fa-solid fa-arrow-up-right-from-square"></i></sup></small>
                                  </a>
                                </ListGroup.Item>
                              ))}
                            </ListGroup>
                          </div>
                        </Card>
                      )}
                    </Col>
                  </Row>
                ))}

                <hr />

                <Row className="mb-2 my-3">
                  <Col xs={12} md={12} xl={12} className="text-center fw-bold">
                    <span className="d-none primary d-md-block">TERMS & CONDITIONS FOR PAYMENT AND REFUND POLICY</span>
                    <span className="d-md-none f-small primary">TERMS & CONDITIONS FOR PAYMENT AND REFUND POLICY</span>
                  </Col>
                </Row>

                {termsAndConditions.map((item) => (
                  <Row key={item.id} className="mb-2">
                    <Col xs={2} md={1} xl={1}>
                      <div className="d-none d-md-flex align-items-center fs-5 justify-content-center primary-bg rounded-circle" style={{ width: '40px', height: '40px' }}>{item.id}</div>
                      <div className="d-md-none f-small align-items-center d-flex justify-content-center primary-bg rounded-circle text-center" style={{ width: '25px', height: '25px' }}>{item.id}</div>
                    </Col>
                    <Col xs={10} md={11} xl={11} className="ps-0">
                      <span className="d-none d-md-flex">{item.text}</span>
                      <span className="d-md-none f-small">{item.text}</span>
                    </Col>
                  </Row>
                ))}

                <hr />
              </div>

              <Form.Group className="mb-3">
                <Form.Check
                  type="checkbox"
                  id="gridCheck"
                  name="citizen_consent"
                  required
                  checked={citizenConsent}
                  onChange={handleCheckboxChange}
                  label={
                    <>
                      <span className="d-none d-md-flex fst-italic fw-bold ms-2 primary">I have read and understood the above guidelines for use of RTI Online Portal (Assam)</span>
                      <span className="d-md-none f-small fst-italic fw-bold ms-2 primary">I have read and understood the above guidelines for use of RTI Online Portal (Assam)</span>
                    </>
                  }
                />
              </Form.Group>

              <div className="d-flex text-center form-group my-3">
                <Button
                  type="submit"
                  className="fw-medium btn-secondary f-sm-small rounded-5 primary-bg"
                  disabled={!citizenConsent}
                  name="submit"
                >
                  SUBMIT
                </Button>
                <Button
                  type="button"
                  className="fw-medium btn-secondary f-sm-small rounded-5 mx-3"
                  onClick={handleCancelClick}
                >
                  CANCEL
                </Button>
              </div>
            </Form>
          </Card>
        </Container>
      </div>
    </>
  );
}

export default Guidelines;
