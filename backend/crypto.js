// 引入 Node.js 的 crypto 模組
const crypto = require('crypto');

// 使用 crypto 模組生成一個 64 字節的隨機密鑰，並轉換為十六進制字符串
const jwtSecret = crypto.randomBytes(64).toString('hex');

// 輸出生成的 JWT 密鑰
console.log(jwtSecret);
