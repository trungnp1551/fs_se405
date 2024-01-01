const mongoose = require('mongoose')

const reportSchema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    sender_id:{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
    },
    target_id:{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
    },
    content: String,
    proceeded: {

    },
    created_at: {
        type: Date,
        default: Date.now(),
    }
},
    {
        versionKey: false
    }
)

module.exports = mongoose.model('Report', reportSchema)