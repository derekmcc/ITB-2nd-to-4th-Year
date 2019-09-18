// ------------------------------------------------------------------------------------------------
// Interfaces.
// ------------------------------------------------------------------------------------------------

interface ILoggable {
	logBrief(): void;
	logVerbose(): void;
}

interface IFreezable {
	freeze(): void;
	unfreeze(): void;
}


// ------------------------------------------------------------------------------------------------
// Helper class, for use in conjunction with Calculator (see below).
// ------------------------------------------------------------------------------------------------
class Operation {
		
	constructor (public operand1: number, public operator: string, public operand2: number) {}
	
	public toString(): string {
		return `${this.operand1} ${this.operator} ${this.operand2}`;
	}
}


// ------------------------------------------------------------------------------------------------
// Calculator class, implements the interfaces.
// ------------------------------------------------------------------------------------------------
class Calculator implements ILoggable, IFreezable {

	private operations = new Array<Operation>();
	private frozen: boolean = false;

	// Implementation of Loggable.
	logBrief(): void {
		console.log("\nBrief log of operations:");
		console.log("------------------------");
		console.log("Number of operations: " + this.operations.length);
		console.log("\n");
	}

	logVerbose(): void {
		console.log("\nVerbose log of operations:");
		console.log("--------------------------");
		for(var op of this.operations) {
			console.log(op);
		}
		console.log("\n");
	}

	// Implementation of IFreezable.
	freeze(): void{
		this.frozen = true;
	}

	unfreeze():void {
		this.frozen = false;
	}

	// Functionality.
	add(num1: number, num2: number): void {
		if (!this.frozen) {
			this.operations.push(new Operation(num1, "+", num2));
			console.log(num1+num2);
		}
	}

	subtract(num1: number, num2: number): void {
		if (!this.frozen) {
			this.operations.push(new Operation(num1, "-", num2));
			console.log(num1-num2);
		}
	}

	multiply(num1: number, num2: number): void {
		if (!this.frozen) {
			this.operations.push(new Operation(num1, "*", num2));
			console.log(num1*num2);
		}
	}

	divide(num1: number, num2: number): void {
		if (!this.frozen) {
			this.operations.push(new Operation(num1, "/", num2));
			console.log(num1/num2);
		}
	}
}


// ------------------------------------------------------------------------------------------------
// Client code.
// ------------------------------------------------------------------------------------------------
function doSomeCalculations(calc: Calculator): void {
	calc.add(100, 200);
	calc.subtract(50, 22);
	calc.multiply(6, 7);
	calc.divide(54, 18);
}

function doLogging(loggableObj: ILoggable): void {
	loggableObj.logBrief();
	loggableObj.logVerbose();
}

let calc = new Calculator();

calc.freeze();
doSomeCalculations(calc);

calc.unfreeze();
doSomeCalculations(calc);

doLogging(calc);

