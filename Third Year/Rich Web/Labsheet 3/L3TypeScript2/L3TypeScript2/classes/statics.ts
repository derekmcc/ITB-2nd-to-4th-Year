class Employee {
  private name: string;
  private salary: number;

  private static taxThreshold: number = 42000;
  
  constructor(name: string, salary: number) {
    this.name = name;
    this.salary = salary;
  }   
 
  payRise(amount: number): void {
    this.salary += amount;
  }
  
  isHigherTaxPayer(): boolean {
    return this.salary > Employee.taxThreshold;
  }
  
  setName(newName: string): void { 
    this.name = newName;
  }
  
  getSalary(): number {
	return this.salary
  }
  
  static getTaxThreshold(): number {
	return Employee.taxThreshold;
  }
}

var emp1 = new Employee("Lydia", 10000);
emp1.payRise(100000);
console.log("Higher tax? " + emp1.isHigherTaxPayer());

// This statement causes an compiler error - 'Employee.tax_threshold' is inaccessible.
// console.log("Tax threshold is " + Employee.taxThreshold);

// This statement is OK.
console.log("Tax threshold is " + Employee.getTaxThreshold());
