const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
require('dotenv').config();

const app = express();
app.use(cors());
app.use(express.json());

// 路由
const authRoutes = require('./routes/auth');
app.use('/api/auth', authRoutes);

// MongoDB 連線
mongoose
  .connect(process.env.MONGO_URI, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.error('Failed to connect to MongoDB', err));

// 啟動伺服器
const PORT = process.env.PORT || 7788;
app.listen(PORT, () => console.log(`Server running on http://localhost:${PORT}`));
