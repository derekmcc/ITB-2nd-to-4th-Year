Qinterface ISearchFunc {
    (src: string, subStr: string): boolean;
}

let mySearchFunc: ISearchFunc;

mySearchFunc = function(sourceString: string, subString: string) {
    return sourceString.search(subString) != -1;
}

console.log(mySearchFunc("Super swans", "swan"));  // true
console.log(mySearchFunc("Super swans", "duck"));  // false