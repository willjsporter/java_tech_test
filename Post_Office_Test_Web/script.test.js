'use strict'

var jsdom = require('mocha-jsdom');
global.document = jsdom({
    url: "http://localhost"
});



var chai = require("chai");
var chaiAsPromised = require("chai-as-promised");
chai.use(chaiAsPromised);
var should = chai.should();

const runOperations = require('./script.js').runOperations;
const clearShowBox = require('./script.js').clearShowBox;

describe('runOperations', function () {
    it('should add when operator is +', function () {
        return runOperations(6, 3, '+').should.eventually.equal(9);
        }
    );

    it('should subtract when operator is -', function () {
            return runOperations(6, 3, '-').should.eventually.equal(3);
        }
    );

    it('should multiply when operator is *', function () {
            return runOperations(6, 3, '*').should.eventually.equal(18);
        }
    );

    it('should divide when operator is /', function () {
            return runOperations(6, 3, '/').should.eventually.equal(2);
        }
    );
});

describe('clear button', function () {
    it('should remove all data from showBox display', function () {
        var showBox = document.createElement('div');
        showBox.id = 'showBox';
        showBox.innerHTML = '1+2';
        document.body.appendChild(showBox);

        clearShowBox()

        document.getElementById('showBox').innerHTML.should.equal('')
    })
})
