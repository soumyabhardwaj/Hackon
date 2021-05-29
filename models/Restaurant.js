const mongoose = require('mongoose');

const RestaurantSchema = mongoose.Schema({
    name: String,
    address: String,
    phone: Number,
    sanitation: Number,
    socialDistancing: Number,
    maskUse: Number,
});

module.exports = mongoose.model('Restaurant', RestaurantSchema);