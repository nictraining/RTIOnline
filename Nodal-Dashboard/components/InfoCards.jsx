import React from 'react';

const InfoCards = () => {
  const cards = [
    { label: 'New Request(s)', count: 20 },
    { label: 'New Appeal(s)', count: 5 },
    { label: 'Request Document(s) Called', count: 5 },
  ];

  return (
    <div className="cards-container">
      {cards.map((card, i) => (
        <div key={i} className="info-card">
          <div className="card-icon">📩</div>
          <p>{card.label}</p>
          <h3>{card.count}</h3>
        </div>
      ))}
    </div>
  );
};

export default InfoCards;
