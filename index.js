const app = require('express')();
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const Restaurant = require('./models/Restaurant');

app.use(bodyParser.json());
mongoose.connect('mongodb://mongo:IRAJgNz6RhadhYhlLB96@containers-us-west-5.railway.app:5791',
    {
        useNewUrlParser: true,
        useUnifiedTopology: true,
        useCreateIndex: true,
        useFindAndModify: false
    }
)
    .then(() => console.log("MongoDB successfully connected"))
    .catch(err => console.log(err));

app.post('/rating', (req, res) => {
    const newRestaurant = new Restaurant(req.body);
    newRestaurant.save()
        .then(() => res.send('OK'))
        .catch(() => res.status(400).send('OK'))
})

app.get('/rating', (req, res) => {
    Restaurant.aggregate(
        [
            {
                "$group": {
                    _id: "$name",
                    "shopSanitation": { "$avg": { "$ifNull": ["$sanitation", 0] } },
                    "maskUse": { "$avg": { "$ifNull": ["$maskUse", 0] } },
                    "socialDistancing": { "$avg": { "$ifNull": ["$socialDistancing", 0] } },
                    "shopName": { "$addToSet": "$name" },
                    "shopAddress": { "$addToSet": "$address" },
                }
            }
        ]
    )
        .then(doc => res.send(doc));
});

const port = process.env.PORT || 5000

app.listen(port, () => {
    console.log(`Server running on port ${port}`)
});