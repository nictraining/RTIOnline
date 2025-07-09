import React, { useState } from 'react';
import { Container } from 'react-bootstrap';
import Guidelines from './Guidelines';
import Breadcrumbs from './components/Breadcrumbs';

const SubmitRequest = () => {
  const [guidelinesAccepted, setGuidelinesAccepted] = useState(false);

  const handleGuidelinesSubmit = () => {
    setGuidelinesAccepted(true);
  };

  const breadcrumbItems = [
    { label: 'Home', link: '/' },
    { label: 'Submit Request'}
  ];

  return (
    <>
      {!guidelinesAccepted ? (
        <Guidelines onSubmitGuidelines={handleGuidelinesSubmit} />
      ) : (
        <Container className="mt-5 text-center">
          <Breadcrumbs items={breadcrumbItems} />
          <h2 className="text-primary mb-4">Submit RTI Request</h2>
          <p>This is the demo page for Submit RTI Request functionality.</p>
        </Container>
      )}
    </>
  );
};

export default SubmitRequest;
