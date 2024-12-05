// 引入必要的套件
require('dotenv').config();  // 用來加載 .env 檔案中的環境變數
const express = require('express');
const cors = require('cors');
const app = express();
const authRoutes = require('./routes/auth'); 
const userProfileRoutes = require('./routes/userProfile'); 
APIKEY = "UHJBTQCAN7SDZW3O" 
APIKEY2 = "NQGD5POOOSM90B7D"

// CORS 設置：允許來自特定來源的請求
const corsOptions = {
  origin: process.env.CORS_ORIGIN || 'http://localhost:3000',  // 默認允許 http://localhost:3000
};

// 使用 CORS 中介軟體
app.use(cors(corsOptions));

// 解析 JSON 請求體
app.use(express.json());

// 設定註冊路由
app.use('/api/auth', authRoutes);
app.use('/api/user', userProfileRoutes);

// 啟動伺服器
app.listen(7788, () => {
  console.log('Server running on http://localhost:7788');
});

app.post('/api/forex-data', async (req, res) => {
  const { from_symbol, to_symbol } = req.body;

  try {
      // Fetch forex daily close data
      const forexPrices = await axios.get(`https://www.alphavantage.co/query?function=FX_DAILY&from_symbol=${from_symbol}&to_symbol=${to_symbol}&apikey=${APIKEY}`);
      const forexRealtime = await axios.get(`https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=${from_symbol}&to_currency=${to_symbol}&apikey=${APIKEY2}`);

      const output = {
          forex_prices: forexPrices.data,
          forex_realtime: forexRealtime.data
      };

      res.json(output);
  } catch (error) {
      console.error('Error fetching forex data:', error);
      res.status(500).send('Error fetching forex data');
  }
});