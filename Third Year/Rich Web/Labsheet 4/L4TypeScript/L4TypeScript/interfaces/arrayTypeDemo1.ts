interface IStringArray {
    [index: number]: string;
}

let cities: IStringArray;
cities = ["London", "Paris", "NY"];
console.log(cities[0]);
