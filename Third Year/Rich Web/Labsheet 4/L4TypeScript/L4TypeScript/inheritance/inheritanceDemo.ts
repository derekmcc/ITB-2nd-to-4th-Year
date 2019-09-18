// ------------------------------------------------------------------------------------------------
// BankAccount class - this is the base class
// ------------------------------------------------------------------------------------------------

abstract class BankAccount {

	// State.
	private id: number;
	private accountHolder: string;
	protected balance: number = 0.0;
	private static nextId: number = 1;
	
	// Constructor, getters/setters.
	constructor(accountHolder: string = "") {
		this.accountHolder = accountHolder;
		this.id = BankAccount.nextId++;
	}

	getId(): number {
		return this.id;
	}	
	
	getAccountHolder(): string {
		return this. accountHolder;
	}
	
	setAccountHolder(accountHolder: string) {
		this.accountHolder = accountHolder;
	}

	getBalance(): number {
		return this.balance;
	}

	// Business methods.
	deposit(amount: number): number {
		this.balance += amount;
		return this.balance;
	}
	
	withdraw(amount: number): number {
		let newBalance: number = this.balance - amount;
		if (newBalance < -1000) {
			throw new RangeError("Cannot exceed overdraft limit");
		}
		else {
			this.balance = newBalance;
		}
		return this.balance;
	}
	
	toString(): string {
		return `[${this.id}] ${this.accountHolder}, ${this.balance}`;
	}
	
	// Abstract methods.
	public abstract getTermsAndConditions(): string;
	public abstract getGuaranteedLimit(): number;
}

// ------------------------------------------------------------------------------------------------
// SavingsAccount class - this is type of bank account that applies interest.
// ------------------------------------------------------------------------------------------------
class SavingsAccount extends BankAccount {

	// Define additional instance data.
	private premium: boolean;
	private goneOverdrawn: boolean;

	// Define additional class data.
	private static BASIC_INTEREST_RATE   = 0.015;	// Represents 1.5%
	private static PREMIUM_INTEREST_RATE = 0.030;	// Represents 3.0%
	private static GUARANTEED_LIMIT      = 50000;	// The first £50,000 of the balance in guaranteed.

	// Constructor.
	constructor(accountHolder: string, premium: boolean) {
		super(accountHolder);
		this.premium = premium;
	}

	// Additional methods.
	applyInterest(): void {
		if (this.balance < 0) {
			// Sorry mate, no interest if you're overdrawn.
		}
		else if (this.premium && !this.goneOverdrawn) {
			this.balance *= (1 + SavingsAccount.PREMIUM_INTEREST_RATE);
		}
		else {
			this.balance *= (1 + SavingsAccount.BASIC_INTEREST_RATE);
		}
	}
	
	// Overrides of members from superclass.
	withdraw(amount: number): number {
		super.withdraw(amount);
		if (this.balance < 0) {
			this.goneOverdrawn = true;
		}
		return this.balance;
	}
	
	toString(): string {
		return `${super.toString()} [${this.premium ? "Premium" : "Normal"} ${this.goneOverdrawn ? "gone overdrawn" : "not gone overdrawn"}]`; 
	}
	
	// Implementation of abstract members from superclass.
	getTermsAndConditions(): string {
		return "Savings Accounts accrue interest at 3% pa (premium accounts) or 1.5% otherwise. " +
		       "If the account goes overdrawn during the year, the 1.5%  interest rate applies regardless. " + 
		       "Savings Accounts are guaranteed by law for the first £" + SavingsAccount.GUARANTEED_LIMIT;
	}
	
	getGuaranteedLimit(): number {
		return SavingsAccount.GUARANTEED_LIMIT;
	}	
}


// ------------------------------------------------------------------------------------------------
// CurrentAccount class - this is type of bank account that has cheques.
// ------------------------------------------------------------------------------------------------
class CurrentAccount extends BankAccount {
	
	// Define additional instance data.
	private chequeBook: number[];
	private chequesWritten: number = 0;

	// Define additional class data.
	private static GUARANTEED_LIMIT = 30000;	// The first £30,000 of the balance in guaranteed.

	// Constructor.
	constructor(accountHolder: string, chequeBookSize: number) {
		super(accountHolder);
		this.chequeBook = new Array<number>(chequeBookSize);
	}

	// Additional methods.
	writeCheque(amount: number): void {
		if (this.chequesWritten === this.chequeBook.length) {
			console.log(`Can't write cheque for ${amount}`);
		} 
		else {
			console.log(`Written cheque for ${amount}`);
			this.chequeBook[this.chequesWritten++] = amount;
			this.withdraw(amount);
		}
	}

	displayCheques(): void {
		for (let i = 0; i < this.chequesWritten; i++) {
			console.log(`Cheque ${i}\t:${this.chequeBook[i]}`);
		}
	}
	
	// Overrides of members from superclass.
	toString(): string {
		return `${super.toString()} [${this.chequesWritten} cheques written]`;
	}
		
	// Implementation of abstract members from superclass.
	getTermsAndConditions(): string {
		return "Current Accounts do not accrue interest. " +
		       "Account holders can request a cheque book, and they can say how many cheques they're likely to need. " + 
		       "Current Accounts are guaranteed by law for the first £" + CurrentAccount.GUARANTEED_LIMIT;
	}
	
	getGuaranteedLimit(): number {
		return CurrentAccount.GUARANTEED_LIMIT;
	}

}

// ------------------------------------------------------------------------------------------------
// Client code.
// ------------------------------------------------------------------------------------------------
function processAccount(account: BankAccount) {

	console.log("\nProcessing account " + account.getId());
	account.withdraw(200);
	account.deposit(300);
	
	// Utilize type-specific behaviour (avoid doing this if possible)
	if (account instanceof SavingsAccount) {
		let temp: SavingsAccount = <SavingsAccount>account;
		temp.applyInterest();
		
	} else if (account instanceof CurrentAccount) { 
		let temp: CurrentAccount = <CurrentAccount>account;
		temp.writeCheque(25.00);
		temp.writeCheque(36.00);
		temp.writeCheque(49.00);
		temp.writeCheque(64.00);
		temp.displayCheques();
	}
	
	console.log(account.toString());
	console.log(account.getTermsAndConditions());
	console.log(`Additional amount that can be deposited within guarantee limit: ${account.getGuaranteedLimit() - account.getBalance()}`);
}

processAccount(new SavingsAccount("John", true));
processAccount(new CurrentAccount("Esme", 3));
