'use strict'

//async added for testing purposes.
// Shouldn't degrade performance of calculator given that human input can't be as fast as code can run.

async function evaluateData() {
	let showBox = document.getElementById("showBox");
	let dataString = showBox.innerHTML;

	dataString = dataString.replace(/\s/g, "");
	await gatherData(dataString).then((parsedData) => {
		runOperations(parsedData.numbers[0], parsedData.numbers[1], parsedData.operator).then((answer) => {
			showBox.textContent = answer;
		})
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
				operator: ''
			};
			let calculationComponents = dataString.split(/([\+\-\*\/])/);
			calculationComponents.forEach(component => {
				if (isNaN(parseInt(component))) {
					parsedData.operator = component;
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
