import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Navbar } from './adminPortal/NavBar';
import { PersonaPlan, ClaimHistory, StockShares, Tax, Welcome } from './components';

const App = () => {

  return (
    <BrowserRouter>
      <div>

        <Navbar />

        <div className="content">
          <Routes>
            <Route path="/persona-plan" element={<PersonaPlan/>} />
            <Route path="/claim-history" element={<ClaimHistory/>} />
            <Route path="/stock-shares" element={<StockShares/>} />
            <Route path="/" element={<Welcome/>} />
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
};

export default App;
