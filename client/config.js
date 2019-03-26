// config.js

const config = {
    db: {
        host: 'localhost',
        port: 3306,
        databases: 'tractor',
        username: 'localhost',
        password: 'localhost',
    },
    app:{
        masterKey:"tractor",
        port: 3000,
    }
};


module.exports = config;