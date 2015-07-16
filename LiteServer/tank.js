var express = require('express');
var app = express();

app.get('/init', function (request, response) {
	console.log('tank ready');
	response.send('ok');
});

app.get('/motor/l', function (request, response) {
	console.log('to left');
	response.send('l');
});

app.get('/motor/r', function (request, response) {
	console.log('to right');
	response.send('r');
});

app.get('/motor/u', function (request, response) {
	console.log('to forward');
	response.send('f');
});

app.get('/motor/d', function (request, response) {
	console.log('to backrward');
	response.send('b');
});

var port = 8090;
app.listen(port);
console.log('Listening on port: ' + port);