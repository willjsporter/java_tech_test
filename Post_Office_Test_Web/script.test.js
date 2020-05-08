'use strict'

var chai = require("chai");
var chaiAsPromised = require("chai-as-promised");
chai.use(chaiAsPromised);
var assert = chai.should();

const runOperations = require('./script.js').runOperations;

describe('runOperations', function () {
    it('should add when operator is +', function () {
        return runOperations(6, 3, '+').should.eventually.equal(9);
        }
    );

    it('should subtract when operator is -', function () {
            return runOperations(6, 3, '-').should.eventually.equal(3);
        }
    );
});
