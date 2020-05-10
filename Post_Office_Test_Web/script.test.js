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
const evaluateData = require('./script.js').evaluateData;

let showBox;

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
    afterEach(removeShowBox);

    it('should remove all data from showBox display', async function () {
        createShowBox('1+2');

        await clearShowBox();
        document.getElementById('showBox').innerHTML.should.equal('');

    })
});

describe('evaluateData', function () {
    afterEach(removeShowBox);

    it('can add numbers with 2 or more digits', async function () {
        createShowBox('123+234');

        await evaluateData();
        document.getElementById('showBox').innerHTML.should.equal('357');
    });

    it('can subtract numbers with 2 or more digits', async function () {
        createShowBox('123-24');

        await evaluateData();
        document.getElementById('showBox').innerHTML.should.equal('99');
    });

    it('can multiply numbers with 2 or more digits', async function () {
        createShowBox('12*200');

        await evaluateData();
        document.getElementById('showBox').innerHTML.should.equal('2400');
    });

    it('can divide numbers with 2 or more digits', async function () {
        createShowBox('1800/30');

        await evaluateData();
        document.getElementById('showBox').innerHTML.should.equal('60');
    });
});


function createShowBox(displayText) {
    showBox = document.createElement('div');
    showBox.id = 'showBox';
    showBox.innerHTML = displayText;
    document.body.appendChild(showBox);
}
function removeShowBox() {
    var elem = document.getElementById('showBox');
    return elem.parentNode.removeChild(elem);
}
