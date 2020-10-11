const express = require('express')
var bodyParser = require('body-parser')
const { Client } = require('pg')
const app = express()
const port = 3000

var constring = 'postgresql://postgres:123@db-suppliers:5432/onparty-suppliers';

app.all('*', function(req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'PUT, GET, POST, DELETE, OPTIONS');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
  });

// create application/json parser
var jsonParser = bodyParser.json()
 
// create application/x-www-form-urlencoded parser
var urlencodedParser = bodyParser.urlencoded({ extended: true })

app.get('/v1/suppliers/cnpj/:cnpj', async (req, res) => {
    const client = new Client({
        connectionString: constring
    });
    await client.connect()  
        .then(() => console.log('connected'))
        .catch(err => console.error('connection error', err.stack))
    var result = await client.query(`select * from tb_supplier where cnpj = ${req.params.cnpj}`);
    if (result.rows.length == 0) {
        return res.status(404);
    }
    res.json(result.rows[0]);
  });
  
  app.post('/v1/suppliers/', jsonParser, async (req, res) => {
    const client = new Client({
        connectionString: constring
    });
    await client.connect()  
        .then(() => console.log('connected'))
        .catch(err => console.error('connection error', err.stack))
    await client.query(
    `INSERT INTO TB_SUPPLIER VALUES (    
    ${req.body.id},
    ${req.body.cnpj},
    '${req.body.name}',
    '${req.body.email}',
    '${req.body.address}',
    ${req.body.number},
    '${req.body.addressComplement}',
    ${req.body.telephone},
    ${req.body.cep},
    '${req.body.status}')`)
        .then(
            result => {
                client.end(); 
                return res.send(result.rows[0]);
        })
        .catch(() => client.end())
});
  
app.listen(port, () => {
  console.log(`Supplier api listening at http://localhost:${port}`)
})
