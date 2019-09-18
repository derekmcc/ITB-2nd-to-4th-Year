var Employee = /** @class */ (function () {
    function Employee(name, salary) {
        this.name = name;
        this.salary = salary;
    }
    Employee.prototype.payRise = function (amount) {
        this.salary += amount;
    };
    Employee.prototype.isHigherTaxPayer = function () {
        return this.salary > Employee.taxThreshold;
    };
    Employee.prototype.setName = function (newName) {
        this.name = newName;
    };
    Employee.prototype.getSalary = function () {
        return this.salary;
    };
    Employee.getTaxThreshold = function () {
        return Employee.taxThreshold;
    };
    Employee.taxThreshold = 42000;
    return Employee;
}());
var emp1 = new Employee("Lydia", 10000);
emp1.payRise(100000);
console.log("Higher tax? " + emp1.isHigherTaxPayer());
// This statement causes an compiler error - 'Employee.tax_threshold' is inaccessible.
// console.log("Tax threshold is " + Employee.taxThreshold);
// This statement is OK.
console.log("Tax threshold is " + Employee.getTaxThreshold());
