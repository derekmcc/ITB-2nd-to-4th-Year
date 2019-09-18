var Employee = /** @class */ (function () {
    function Employee(name, salary) {
        this.name = name;
        this.salary = salary;
    }
    Employee.prototype.getName = function () {
        return this.name;
    };
    Employee.prototype.setName = function (newName) {
        this.name = newName;
    };
    Employee.prototype.getSalary = function () {
        return this.salary;
    };
    return Employee;
}());
var emp1 = new Employee("Lydia", 10000);
emp1.setName("George");
console.log(emp1.getName() + ' earns ' + emp1.getSalary());
