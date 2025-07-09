import React, { useEffect } from 'react';
import { Container, Row, Col, Card } from 'react-bootstrap';
import * as echarts from 'echarts';
import {
  FaBuildingCircleCheck,
  FaUserTie,
  FaGavel,
  FaPeopleRoof,
} from 'react-icons/fa6';

const stats = [
  {
    label: 'Public Authority',
    value: 1184,
    icon: <FaBuildingCircleCheck size={40} className="opacity-50" />,
    bg: 'danger',
  },
  {
    label: 'SPIO Registered',
    value: 1178,
    icon: <FaUserTie size={40} className="opacity-50" />,
    bg: 'success',
  },
  {
    label: 'FAA Registered',
    value: 668,
    icon: <FaGavel size={40} className="opacity-50" />,
    bg: 'primary',
  },
  {
    label: 'Citizen Registered',
    value: 830,
    icon: <FaPeopleRoof size={40} className="opacity-50" />,
    bg: 'secondary',
  },
];

const RTIInfoSection = () => {
  useEffect(() => {
    const chartDesktop = echarts.init(document.getElementById('rtiChart'));
    chartDesktop.setOption({
      title: { text: 'RTI Status', left: 'center' },
      tooltip: { trigger: 'item' },
      legend: { bottom: '0', left: 'center' },
      series: [
        {
          name: 'RTI Status',
          type: 'pie',
          radius: ['40%', '70%'],
          avoidLabelOverlap: false,
          label: { show: false, position: 'center' },
          emphasis: {
            label: { show: true, fontSize: 18, fontWeight: 'bold' },
          },
          labelLine: { show: false },
          color: ['#e0400a', '#fcb441', '#418cf0', '#54085e'],
          data: [
            { value: 740, name: 'Pending Requests' },
            { value: 186, name: 'Disposed Requests' },
            { value: 239, name: 'First Appeal' },
            { value: 0, name: "Citizen's Feedback" },
          ],
        },
      ],
    });
  }, []);

  return (<>
    



     
    <div className="mb-0 p-2 p-md-4" style={{ backgroundColor: '#fff6ea' }}>
      <Container>
        <Row className="mb-3 flex-column flex-lg-row">
          {/* Left section */}
          <Col lg={8} className="mb-4">
            <div>
              <div className="text-center text-lg-start">
                <img
                  src="./images/rti-logo.png"
                  width="200"
                  alt="Right to Information Logo"
                  className="mb-3"
                />
              </div>

              <div className="text-primary fs-5 fs-lg-3 fw-medium text-center text-lg-start">
                Right to Information Online Portal, Government of Tripura
              </div>

              <p className="text-primary mt-3 fs-6 text-justify">
                This is a portal to file RTI application/first appeal online along
                with payment gateway. Fee payment can be made through Net Banking.
                Through this portal RTI application/first appeal can be filed by
                Indian Citizen only for the Departments/Public Authorities of the
                Govt. of Tripura. Please read instructions carefully while submitting
                the RTI application/first appeal.
              </p>

              {/* Stats */}
              <Row className="mt-2">
                {stats.map((stat, i) => (
                  <Col xs={6} md={6} key={i} className="my-2">
                    <div
                      className={`widget bg-${stat.bg} rounded text-white px-4 py-2`}
                      style={{ boxShadow: '0 0 10px 2px rgba(100,100,100,0.3)' }}
                    >
                      <Row>
                        <Col xs={4} className="text-start my-auto">
                          {stat.icon}
                        </Col>
                        <Col xs={8} className="text-end">
                          <div>{stat.label}</div>
                          <div className="fw-bold fs-3">{stat.value}</div>
                        </Col>
                      </Row>
                    </div>
                  </Col>
                ))}
              </Row>
            </div>
          </Col>

          {/* Right chart section */}
          <Col lg={4} className="my-auto">
            <Card className="border-0 bg-transparent mt-4 mt-lg-0">
              <Card.Body className="d-flex flex-column justify-content-end pb-0">
                <div
                  id="rtiChart"
                  style={{ minHeight: '400px', width: '100%' }}
                  className="echart"
                ></div>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>

    </>
  );
};

export default RTIInfoSection;
