const express = require('express')
const router = express.Router()

const messageController = require('../controllers/message')

router
    .route('/')
    .get(messageController.getAll)

module.exports = router