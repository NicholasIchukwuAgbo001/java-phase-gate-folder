const Account = require('./account.js')

class Bank {

    constructor() {
    this.accounts = []
    }

    CreateAccount = (firstName, lastName, pin) => {
        const accountNumber = Math.floor(Math.random() * 1000000000).toString().padStart(10, '0');
        const account = new Account(accountNumber, firstName, lastName, pin);
        this.accounts.push(account);
        return accountNumber;
      
    }

   validateName = (name) => {
        const regex = /^[a-zA-Z\s]+$/;
        if (!regex.test(name)) {
            throw new Error("Invalid name, Name must contain only letters.");
        }
    }

    validatePin = (pin) => {
        const regex = /^[0-9]{4}$/;
        if (!regex.test(pin)) {
            throw new Error("Invalid PIN, PIN must be 4 digits.");  
        }
    }

    validateAccountNumber = (accountNumber) => {
        const regex = /^[0-9]{10}$/;
        if (!regex.test(accountNumber)) {
            throw new Error("Invalid account number, Account number must be 10 digits.");
        }
    }

    validateAmount = (amount) => {
        if (amount <= 0) {
            throw new Error("Invalid amount, Amount must be positive.");
        }
        if (typeof amount !== 'number') {
            throw new Error("Invalid amount, Amount must be a number.");
        }
    }
    

    getAccount = (accountNumber) => {
        return this.accounts[this.accounts.length - 1].accountNumber;
    }



    closeAccount(accountNumber, pin) {
        let account = this.accounts.find(acc => acc.accountNumber === accountNumber);
        if (!account) {
            throw new Error("Account not found.");
        }
        if (account.pin !== pin) {
            throw new Error("Invalid PIN.");
        }
        this.accounts = this.accounts.filter(acc => acc.accountNumber !== accountNumber);
    }

    deposit = (accountNumber, amount, pin) => {
        for(let account of this.accounts) {
            if (account.accountNumber === accountNumber) {
                if(account.pin === pin) {
                    account.deposit(amount, pin);
                    return;
                }else{
                    throw new Error("Invalid PIN. Cannot deposit.");
                }
            }
        }
        throw new Error("Account not found.");
    }

    withdraw = (accountNumber, amount, pin) => {
        for(let account of this.accounts) {
            if (account.accountNumber === accountNumber) {
                if(account.pin === pin) {
                    account.withdraw(amount, pin);
                    return;
                }else{
                    throw new Error("Invalid PIN. Cannot withdraw.");
                }
            }
        }
        throw new Error("Account not found.");
    }

    getBalance = (accountNumber, pin) => {
        for(let account of this.accounts) {
            if (account.accountNumber === accountNumber) {
                if(account.pin === pin) {
                    return account.getBalance();
                }else{
                    throw new Error("Invalid PIN. Cannot get balance.");
                }
            }
        }
        throw new Error("Account not found.");
    }

    changePin = (accountNumber, oldPin, newPin) => {
        if(oldPin === newPin) {
            throw new Error("New PIN must be different from old PIN.");
        }

        for(let account of this.accounts) {
            if (account.accountNumber === accountNumber) {
                if(account.pin === oldPin) {
                    account.pin = newPin;
                    return;
                }else{
                    throw new Error("Invalid PIN. Cannot change PIN.");
                }
            }
        }
        throw new Error("Account not found.");
    }

    isValidPin = (accountNumber, pin) => {
        for(let account of this.accounts) {
            if (account.accountNumber === accountNumber && account.pin === pin) {
                return true;
            }

            if(account.accountNumber !== accountNumber) {
                throw new Error("Account not found.");
            }

            if(account.pin !== pin) {
                throw new Error("Invalid PIN.");
            }
        }
        return false;
    }

   
transfer(senderAccountNumber, recipientAccountNumber, amount, pin) {
    let senderAccount = this.accounts.find(acc => acc.accountNumber === senderAccountNumber);
    if (!senderAccount) {
        throw new Error("Sender account not found.");
    }
    if (senderAccount.pin !== pin) {
        throw new Error("Invalid PIN for sender account.");
    }
    if (senderAccount.balance < amount) {
        throw new Error("Insufficient balance.");
    }

    senderAccount.balance -= amount;

    let recipientAccount = this.accounts.find(acc => acc.accountNumber === recipientAccountNumber);
    if (!recipientAccount) {
        throw new Error("Recipient account not found.");
    }

    recipientAccount.balance += amount;
}

}

module.exports = Bank;