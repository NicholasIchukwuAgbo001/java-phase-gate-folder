class Account{
    constructor(accountNumber, firstName, lastName, pin) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.balance = 0;
        this.isClosed = false;
    }

    getFirstName = () => {
        return this.firstName;
    }

    getLastName = () => {
        return this.lastName;
    }

    getAccountNumber = () => {
        return this.accountNumber;
    }

    getBalance = () => {
        return this.balance;
    }

    getPin = () => {
        return this.pin;
    }

    isClosed = () => {
        return this.isClosed;
    }

    closeAccount = () => {
        this.isClosed = true;
    }

    deposit = (amount, pin) => {
        if (this.isClosed) {
            throw new Error("Account is closed. Cannot deposit.");
        }
        if (amount <= 0) {
            throw new Error("Deposit amount must be positive.");
        }
        if (pin !== this.pin) {
            throw new Error("Invalid PIN. Cannot deposit.");
        }
        if (typeof amount !== 'number') {
            throw new Error("Deposit amount must be a number.");
        }
        this.balance += amount;
    }

    withdraw = (amount, pin) => {
        if (this.isClosed) {
            throw new Error("Account is closed. Cannot withdraw.");
        }
        if (amount <= 0) {
            throw new Error("Withdrawal amount must be positive.");
        }
        if (pin !== this.pin) {
            throw new Error("Invalid PIN. Cannot withdraw.");
        }
        if (typeof amount !== 'number') {
            throw new Error("Withdrawal amount must be a number.");
        }
        if (amount > this.balance) {
            throw new Error("Insufficient funds for withdrawal.");
        }
        this.balance -= amount;
    }


    transfer = (amount, pin, accountNumber) => {
        if (this.isClosed) {
            throw new Error("Account is closed. Cannot transfer.");
        }
        if (amount <= 0) {
            throw new Error("Transfer amount must be positive.");
        }
        if (pin !== this.pin) {
            throw new Error("Invalid PIN. Cannot transfer.");
        }
        if (typeof amount !== 'number') {
            throw new Error("Transfer amount must be a number.");
        }
        if (amount > this.balance) {
            throw new Error("Insufficient funds for transfer.");
        }
        this.withdraw(amount, pin);
        accountNumber.deposit(amount, accountNumber.getPin());
    }

}

module.exports = Account;