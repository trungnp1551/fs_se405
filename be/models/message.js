const mongoose = require('mongoose')    

const messageSchema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    sender_id:{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
    },
    receiver_id:{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
    },
    created_at: {
        type: Date,
        default: Date.now(),
    },
    content: {
        type: String,
    },
    is_image: {
        type: Boolean,
        default: false
    },
    image_link: {
        type: String,
        default: ""
    }
}, {
    versionKey: false
})

module.exports = mongoose.model('Message', messageSchema)