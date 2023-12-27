const express = require('express')
const router = express.Router()
const auth = require('../middleware/auth')
const reportController = require('../controllers/report')

router
    .route('/')
    .get(reportController.getAll)
    .post(auth, reportController.addReport)

module.exports = router