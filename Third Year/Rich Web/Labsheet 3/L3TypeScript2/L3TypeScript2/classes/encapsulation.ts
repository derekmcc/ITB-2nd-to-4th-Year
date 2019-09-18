class Employee {
  private name: string;
  private salary: number;

  constructor(name: string, salary: number) {
    this.name = name;
    this.salary = salary;
  }   
  
  getName(): string { 
    return this.name;
  }
  
  setName(newName: string): void { 
    this.name = newName;
  }
  
  getSalary(): number {
	return this.salary
  }
}

var emp1 = new Employee("Lydia", 10000);
emp1.setName("George");
console.log(emp1.getName() + ' earns ' + emp1.getSalary());