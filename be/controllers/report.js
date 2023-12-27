const mongoose = require('mongoose')

const Report = require('../models/report')

exports.getAll = async (req, res) => {
    const data = await Report.find().populate('sender_id',['username','reportNumber']).populate('target_id',['username','reportNumber'])

    res.status(200).json({
        success: true,
        message: 'get all report',
        data
    })
}

exports.addReport = async (req, res)=>{
    const sender_id = req.userId
    const {target_id, content} = req.body
    try {
        const newReport = new Report({
            _id: new mongoose.Types.ObjectId(),
            sender_id,
            target_id,
            content
        })
        await newReport.save()
        return res.status(200).json({
            success: true,
            message: "add report successful",
            newReport
        })
    } catch (error) {
        console.log(error)
    }
}