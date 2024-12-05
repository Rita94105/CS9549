const express = require('express');
const User = require('../models/Users');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');

const router = express.Router();

// 中介軟體：驗證 JWT
const verifyToken = (req, res, next) => {
    const authHeader = req.header('Authorization');
    console.log('Received Header:', authHeader); // 輸出 Authorization 標頭以確認其存在
    const token = authHeader && authHeader.split(' ')[1];  // 從 Authorization 標頭中獲取 token
    console.log('Received Token:', token); // 輸出 token 以確認其存在
  if (!token) return res.status(403).json({ error: 'Access denied' });

  try {
    const decoded = jwt.verify(token, process.env.JWT_SECRET);
    console.log('JWT'+decoded);
    req.user = decoded;  // 在請求中保存用戶的資訊
    next();  // 讓路由處理函數繼續執行
  } catch (err) {
    res.status(401).json({ error: 'Invalid or expired token' });
  }
};

// 取得用戶資料
/*router.get('/profile/:username', async (req, res) => {
    try {
        console.log('username'+req.params.username);
      const user = await User.findOne({ username: req.params.username }).select('-password'); // 不返回密碼
      if (!user) return res.status(404).json({ error: 'User not found' });
  
      res.json({
        email: user.email,
        username: user.username,
        joined: user.createdAt
      });
    } catch (err) {
      console.error(req.params.username);
      res.status(500).json({ error: 'Error fetching user profile' });
    }
  });*/

// 取得用戶資料
router.get('/profile', verifyToken, async (req, res) => {
  try {
    console.log(req);
    const user = await User.findOne({_id: req.user._id}).select('-password'); // 不返回密碼
    if (!user) return res.status(404).json({ error: 'User not found' });

    res.json({
      email: user.email,
      username: user.username
    });
  } catch (err) {
    res.status(500).json({ error: 'Error fetching user profile' });
  }
});

// 更新用戶資料
router.put('/profile', verifyToken, async (req, res) => {
  const { email, username } = req.body;

  try {
    const user = await User.findById(req.user.id);
    if (!user) return res.status(404).json({ error: 'User not found' });

    // 更新用戶資料
    user.email = email || user.email;
    user.username = username || user.username;

    await user.save();
    res.json({ message: 'User profile updated successfully' });
  } catch (err) {
    res.status(500).json({ error: 'Error updating user profile' });
  }
});

// 更新用戶密碼
router.put('/change-password', verifyToken, async (req, res) => {
  const { oldPassword, newPassword } = req.body;

  try {
    const user = await User.findById(req.user.id);
    if (!user) return res.status(404).json({ error: 'User not found' });

    const isMatch = await bcrypt.compare(oldPassword, user.password);
    if (!isMatch) return res.status(400).json({ error: 'Old password is incorrect' });

    // 密碼加密
    const salt = await bcrypt.genSalt(10);
    user.password = await bcrypt.hash(newPassword, salt);

    await user.save();
    res.json({ message: 'Password updated successfully' });
  } catch (err) {
    res.status(500).json({ error: 'Error changing password' });
  }
});

module.exports = router;
