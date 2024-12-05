import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './AccountBalance.css';

const AccountBalance = () => {
  const [balances, setBalances] = useState({CAD: 500, USD:100, EUR: 50});
  const [currency, setCurrency] = useState('CAD');
  const [amount, setAmount] = useState(1000);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchBalances = async () => {
      try {
        const token = localStorage.getItem('token');
        const res = await axios.get('http://44.203.41.165:7788/api/auth/balance', {
          headers: { Authorization: `Bearer ${token}` },
        });
        setBalances(res.data.balances);
      } catch (err) {
        console.error('Error fetching balances:', err);
      } finally {
        setLoading(false);
      }
    };

    fetchBalances();
  }, []);

  const handleUpdateBalance = async () => {
    try {
      const token = localStorage.getItem('token');
      const res = await axios.put(
        'http://44.203.41.165:7788/api/auth/balance',
        { currency, amount },
        { headers: { Authorization: `Bearer ${token}` } }
      );
      setBalances(res.data.balances);
      setCurrency('');
      setAmount(0);
    } catch (err) {
      console.error('Error updating balance:', err);
    }
  };

  if (loading) return <div>Loading balances...</div>;

  return (
    <div className="balance-container">
      <h2>Account Balance</h2>
      <div className="balance-list">
        {Object.entries(balances).map(([currency, amount]) => (
          <p key={currency}>
            {currency}: {amount}
          </p>
        ))}
      </div>
    </div>
  );
};

export default AccountBalance;
