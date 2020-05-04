'use strict'

function evaluateData() {
	let showBox = document.getElementById("showBox");
	let dataString = showBox.innerHTML;

	dataString = dataString.replace(/\s/g, "");
	gatherData(dataString).then((parsedData) => {
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
			}
			resolve(answer)
		} catch(err) {
			reject(err);
		}
	})
}

function gatherData(dataString) {
	return new Promise((resolve, reject) => {
		try{
			let parsedData = {
				numbers: [],
				operator: ''
			};
			for (let i = 0; i < dataString.length; i++) {
				let val = parseInt(dataString.charAt(i));
				if (isNaN(val)) {
					parsedData.operator = dataString.charAt(i);
				} else {
					parsedData.numbers.push(val);
				}
			}
			resolve(parsedData);
		} catch(err) {
			reject(err);
		}
	})
}