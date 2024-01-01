const mongoose = require('mongoose')

const Message = require('../models/message')

exports.getAll = async (req, res) => {
    const data = await Message.find()

    res.status(200).json({
        success: true,
        message: 'get all',
        data
    })
}