import React from 'react';
import { Breadcrumb } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const Breadcrumbs = ({ items }) => {
  return (
    <Breadcrumb className="fa-breadcrumb">
      {items.map((item, index) => {
        const isLast = index === items.length - 1;
        return (
          <Breadcrumb.Item
            key={index}
            active={isLast}
            linkAs={isLast ? 'span' : Link}
            linkProps={!isLast ? { to: item.link || '#' } : {}}
          >
            {item.label}
          </Breadcrumb.Item>
        );
      })}
    </Breadcrumb>
  );
};

export default Breadcrumbs;
