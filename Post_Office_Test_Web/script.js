'use strict'

async function evaluateData() {
	let showBox = document.getElementById("showBox");
	let dataString = showBox.innerHTML;

	dataString = dataString.replace(/\s/g, "");
	await gatherData(dataString)
		.then(async (parsedData) => {
			let value1 = Promise.resolve(parsedData.numbers[0]);
			for(let i = 0; i < parsedData.operator.length; i ++) {
				 await value1.then(value => {
					let operationI = runOperations(value, parsedData.numbers[i+1], parsedData.operator[i]);
					value1 = new Promise(resolve => resolve(operationI))
				})
			}
			return value1;
		})
		.then((answer) => {
		showBox.textContent = answer;
	}).catch((err) => console.log(err))
}

function addToShowBox(input) {
	let showBox = document.getElementById("showBox");
	showBox.innerHTML += input;
	return;
}

function runOperations(numOne, numTwo, operator) {
	return new Promise((resolve, reject) => {
		try {
			let answer = 0;
			switch (operator){
				case "+":
					answer = numOne + numTwo;
					break;
				case "-":
					answer = numOne - numTwo;
					break;
				case "*":
					answer = numOne * numTwo;
					break;
				case "/":
					answer = numOne / numTwo;
					break;
			}
			resolve(answer)
		} catch(err) {
			reject(err);
		}
	})
}

function gatherData(dataString) {
	return new Promise((resolve, reject) =>
	{
		try{
			let parsedData = {
				numbers: [],
				operator: []
			};
			let calculationComponents = dataString.split(/([\+\-\*\/])/);
			calculationComponents.forEach(component => {
				if (isNaN(parseInt(component))) {
					parsedData.operator.push(component);
				} else {
					parsedData.numbers.push(parseInt(component));
				}
			});
			resolve(parsedData);
		} catch(err) {
			reject(err);
		}
	});
}

function clearShowBox() {
	let showBox = document.getElementById("showBox");
	showBox.innerHTML = '';
}

module.exports = {
	runOperations: runOperations,
	clearShowBox: clearShowBox,
	evaluateData: evaluateData
};
