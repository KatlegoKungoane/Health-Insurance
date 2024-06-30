import React from 'react';
import { Link } from 'react-router-dom';

export const Navbar = () => {

  return (

    <nav>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/persona-plan">Persona Plan</Link></li>
        <li><Link to="/claim-history">Claim History</Link></li>
        <li><Link to="/stock-shares">Stock Shares</Link></li>

        <button>Log In</button>
      </ul>
    </nav>
  );
};
