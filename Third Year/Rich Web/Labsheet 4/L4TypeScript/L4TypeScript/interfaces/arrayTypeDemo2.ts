interface IStringDictionary {
    [index: string]: string;
}

let capitalCities: IStringDictionary = {};

capitalCities["Norway"] = "Oslo";
capitalCities["UK"] = "London";
capitalCities["Romania"] = "Bucharest";

console.log(capitalCities["Norway"]);
