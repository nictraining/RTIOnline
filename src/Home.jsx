import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import ActionCard from './components/ActionCard';
import BannerSlider from './components/BannerSlider';
import RTIInfoSection from './components/RTIInfoSection';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router-dom';
import {
  faEnvelopeOpenText,
  faMagnifyingGlass,
  faGavel,
  faUniversity,
  faExternalLink
} from '@fortawesome/free-solid-svg-icons';

const Home = () => {
  const navigate = useNavigate();

  const handleCardClick = (title, to) => {
    if (title === "Second Appeal Request") {
      Swal.fire({
        icon: 'info',
        title: 'You are being redirected to an external website',
        text: 'Click Continue to proceed.',
        showCancelButton: true,
        confirmButtonText: 'Continue',
        cancelButtonText: 'Cancel',
        customClass: {
          popup: 'text-sm',
          title: 'text-base',
          confirmButton: 'text-sm',
          cancelButton: 'text-sm'
        }
      }).then((result) => {
        if (result.isConfirmed) {
          window.open('https://rtionline.tripura.gov.in/sic/index.php', '_blank'); // Replace with real URL
        }
      });
    } else {
      navigate(to);
    }
  };

  const cardData = [
    {
      icon: faEnvelopeOpenText,
      title: "Submit RTI Request",
      color: "#f59e0b",
      to: "/submit-rti"
    },
    {
      icon: faMagnifyingGlass,
      title: "View Request Status",
      color: "#3b82f6",
      to: "./view-status"
    },
    {
      icon: faGavel,
      title: "First Appeal Request",
      color: "#22c55e",
      to: "./first-appeal"
    },
    {
      icon: faUniversity,
      title: "Second Appeal Request",
      color: "#14b8a6",
      to: "#", // kept just to match interface,
      appendIcon: faExternalLink 
    }
  ];

  return (
    <>
      <Container fluid className="primary-bg-image py-4">
        <Row className="justify-content-center mt-5 mb-5 gx-3 gy-4">
          {cardData.map((card, idx) => (
            <Col xs={6} sm={6} md={3} key={idx}>
              <div onClick={() => handleCardClick(card.title, card.to)}>
                <ActionCard icon={card.icon} title={card.title} color={card.color} to={card.to} appendIcon={card.appendIcon}/>
              </div>
            </Col>
          ))}
        </Row>
      </Container>
      <BannerSlider />
      <RTIInfoSection />
    </>
  );
};

export default Home;
