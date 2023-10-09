const mongoose = require('mongoose')

const settingSchema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    sound: Boolean,
    vibration: Boolean,
    notification: Boolean,
    status: {
        type: String,
        enum:['free','busy','offline']
    },
}, {
    versionKey: false
})

module.exports = mongoose.model('Setting', settingSchema)
