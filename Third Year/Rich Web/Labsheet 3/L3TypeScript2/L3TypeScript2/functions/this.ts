// Using nested functions
function LuckyNumberGenerator1(name: string) {
 
    this.name = name;

    setInterval(function () {
        console.log("Next lucky number for " + this.name + " is " + Math.random());
    }, 1000);
}

// Using lambdas
function LuckyNumberGenerator2(name: string) {
 
    this.name = name;

    setInterval( () => {
        console.log("Next lucky number for " + this.name + " is " + Math.random());
    }, 1000);
}

// Client code
var gen1 = new LuckyNumberGenerator1("Janet");
var gen2 = new LuckyNumberGenerator2("John");



