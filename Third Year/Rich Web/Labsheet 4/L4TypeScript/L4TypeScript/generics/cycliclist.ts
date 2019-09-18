class CyclicList<T> {
	
	// Define members. Note we can use the type parameter here.
	private elements: Array<T>;
	private currentPosition: number;
	private maxElements: number;
	
    // Define a constructor.  
	constructor(size: number) {
		this.elements = new Array<T>();
		this.currentPosition = 0;
		this.maxElements = size;
		
		// Pre-populate collection with nulls.
		for (let i = 0; i < this.maxElements; i++) {
			this.elements.push(null);
		}
	}
	
	insert(item: T): void {
		this.elements[this.currentPosition] = item;
		if (++this.currentPosition === this.maxElements) {
			this.currentPosition = 0;
		}
	}
	
	getItemAt(position: number): T {
		if (position >= this.maxElements) {
			throw new RangeError("Indexed beyond end of CyclicList");
		}
		else {
			return this.elements[position];
		}
	}
	
	toString(): string {
		let str = "";
		for (var item of this.elements) {
			if (item === null) {
				str += "[Null] ";
			}
			else {
				str += item + " ";
			}
		}
		return str;
	}
}

let lotteryNumbers = new CyclicList<number>(6);
lotteryNumbers.insert(19);
lotteryNumbers.insert(1);
lotteryNumbers.insert(2);
lotteryNumbers.insert(7);

let lotteryNumber0: number = lotteryNumbers.getItemAt(0);
console.log(`Lottery number 0 is: ${lotteryNumber0}`);
console.log(`Collection: ${lotteryNumbers.toString()}`);
