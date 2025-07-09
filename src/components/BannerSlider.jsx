import React from 'react';
import { Carousel, Container } from 'react-bootstrap';

const BannerSlider = () => {
  const slides = [
    {
      src: "https://rtionline.assam.gov.in/assets/images/banner-9.png",
      alt: "First Appeal Request Process Flow Image in English",
    },
    {
      src: "https://rtionline.assam.gov.in/assets/images/banner-8.png",
      alt: "RTI Request Process Flow Image in English",
    },
  ];

  return (
    <Container className="my-4">
      <Carousel
        indicators
        controls
        interval={3000}
        pause="hover"
        variant="dark"
        className="rounded-2 shadow"
        style={{ boxShadow: '0 0 10px 2px rgba(100, 100, 100, 0.3)' }}
      >
        {slides.map((slide, index) => (
          <Carousel.Item key={index}>
            <img
              className="d-block w-100"
              src={slide.src}
              alt={slide.alt}
              style={{ height: 'auto', width: '100%' }}
            />
          </Carousel.Item>
        ))}
      </Carousel>
    </Container>
  );
};

export default BannerSlider;
