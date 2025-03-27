const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
const db = require("./db");

const app = express();
app.use(cors());
app.use(bodyParser.json());

// CREATE: Add a new user
app.post("/users", (req, res) => {
    const { city,email,message,mobile,name,subject } = req.body;
    const sql = "INSERT INTO `demonodemujunityfest`.`messages` (`id`, `city`, `email`, `message`, `mobile`, `name`, `subject`) VALUES ('?', '?', '?', '?', '?', '?', '?');\n";
    db.query(sql, [name, email], (err, result) => {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: "Message added", id: result.insertId });
    });
});

// READ: Get all users
app.get("/users", (req, res) => {
    db.query("SELECT * FROM `demonodemujunityfest`.`messages`", (err, results) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json(results);
    });
});

// READ: Get a single user by ID
app.get("/users/:id", (req, res) => {
    db.query("SELECT * FROM `demonodemujunityfest`.`messages` WHERE id = ?", [req.params.id], (err, results) => {
        if (err) return res.status(500).json({ error: err.message });
        if (results.length === 0) return res.status(404).json({ message: "User not found" });
        res.json(results[0]);
    });
});


const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
