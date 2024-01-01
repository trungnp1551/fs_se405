const mongoose = require('mongoose')

const Message = require("../models/message");

exports.createMessage = async (content, is_image, image_link, sender_id, receiver_id, created_at) =>{
    try {
        
        const newMessage = new Message({
            id: new mongoose.Types.ObjectId(),
            sender_id,
            receiver_id,
            created_at,
            content,
            is_image,
            image_link,
        })
        await newMessage.save()
        return newMessage
    } catch (error) {
        console.log('err create message')
    }
}