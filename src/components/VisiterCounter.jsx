import React, { useEffect, useState } from 'react';
import { v4 as uuidv4 } from 'uuid'; // install with: npm install uuid

const VisitorCounter = () => {
  const [visitorCount, setVisitorCount] = useState('000000');

  useEffect(() => {
    const hasVisited = localStorage.getItem('uniqueVisitorId');
    let currentCount = parseInt(localStorage.getItem('visitorCount')) || 270953;

    if (!hasVisited) {
      const newVisitorId = uuidv4();
      localStorage.setItem('uniqueVisitorId', newVisitorId);

      currentCount += 1;
      localStorage.setItem('visitorCount', currentCount);
    }

    // Format to 6-digit string
    setVisitorCount(currentCount.toString().padStart(6, '0'));
  }, []);

  return (
    <div className="container mt-2">
      <div className="d-flex justify-content-center">
        <div id="counter" className="text-center text-light d-flex">
          {visitorCount.split('').map((digit, index) => (
            <React.Fragment key={index}>
              <span className="d-none d-md-flex digit bg-light text-primary fw-bold fs-5">
                {digit}
              </span>
              <span className="d-md-none digit bg-light text-primary fw-bold px-2 py-1 f-xsmall">
                {digit}
              </span>
            </React.Fragment>
          ))}
        </div>
      </div>
      <div className="d-none d-md-block text-light text-center mt-2">
        Total Visitors Count
      </div>
      <div className="d-md-none text-light text-center mt-2 f-small">
        Total Visitors Count
      </div>
    </div>
  );
};

export default VisitorCounter;
