import React from 'react';

import './css/ClaimHistory.css';

export const ClaimHistory = () => {

  const claimHistoryData = [
    {
      claimHistoryID: 'CH001',
      coverPlanID: 'CP001',
      claimAmount: 1000,
      amountPaid: 800,
      claimPersonaID: 'P001',
      timeStamp: '2023-01-15T10:30:00Z',
    },
    {
      claimHistoryID: 'CH002',
      coverPlanID: 'CP002',
      claimAmount: 2000,
      amountPaid: 2000,
      claimPersonaID: 'P002',
      timeStamp: '2023-02-20T11:45:00Z',
    },
    {
      claimHistoryID: 'CH003',
      coverPlanID: 'CP003',
      claimAmount: 1500,
      amountPaid: 1200,
      claimPersonaID: 'P003',
      timeStamp: '2023-03-10T09:20:00Z',
    },
  ];

  return (
    <div className="claim-history-container">
      <h1>Claim History</h1>
      <table className="claim-history-table">
        <thead>
          <tr>
            <th>Claim History ID</th>
            <th>Cover Plan ID</th>
            <th>Claim Amount</th>
            <th>Amount Paid</th>
            <th>Claim Persona ID</th>
            <th>Time Stamp</th>
          </tr>
        </thead>
        <tbody>
          {claimHistoryData.map((claim) => (
            <tr key={claim.claimHistoryID}>
              <td>{claim.claimHistoryID}</td>
              <td>{claim.coverPlanID}</td>
              <td>{claim.claimAmount}</td>
              <td>{claim.amountPaid}</td>
              <td>{claim.claimPersonaID}</td>
              <td>{new Date(claim.timeStamp).toLocaleString()}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};