function duplicate<T>(item: T, count: number): Array<T> {
	let result = new Array<T>();
	for (let i = 0; i < count; i++) {
		result.push(item);
	}
	return result;
}

let arr = duplicate<string>("Hello", 3);
console.log(arr);
