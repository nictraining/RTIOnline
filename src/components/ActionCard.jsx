import React from 'react';
import { Card, Row, Col } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { Link } from 'react-router-dom'; // Make sure react-router-dom is installed

const ActionCard = ({ icon, title, color, to, appendIcon  }) => (
  <Link to={to} className="text-decoration-none">
    <Card className="shadow-sm c-pointer" style={{ borderRadius: '1rem' }}>
      <Card.Body className="card-body-hover p-3" style={{ borderRadius: '1rem' }}>
        <Row className="align-items-center">
          <Col xs={5} className="d-flex justify-content-center text-center">
            <div className="icon-circle fs-3xl" style={{ backgroundColor: color }}>
              <FontAwesomeIcon icon={icon} className="text-white fs-3xl" />
            </div>
          </Col>
          <Col xs={7}>
            <div className="text-primary fw-bold fs-lg text-end">{title}
              {appendIcon && (
                <FontAwesomeIcon
                  icon={appendIcon}
                  className="ms-1"
                  style={{ fontSize: '1rem' }}
                />
              )}</div>
          </Col>
        </Row>
      </Card.Body>
    </Card>
  </Link>
);

export default ActionCard;
