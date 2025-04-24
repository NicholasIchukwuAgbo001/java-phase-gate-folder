const account = require("./account.js")

let account1 = new account("1", "Nicholas", "Ichukwu", 1111)
let account2 = new account("2", "Ade", "Ojo", 1122)


test("Test account1 creation", () => {
    expect(account1.accountNumber).toBe("1");
    expect(account1.firstName).toBe("Nicholas");
    expect(account1.lastName).toBe("Ichukwu");
    expect(account1.pin).toBe(1111);
})

test("Test account2 creation", () => {
    expect(account2.accountNumber).toBe("2");
    expect(account2.firstName).toBe("Ade");
    expect(account2.lastName).toBe("Ojo");
    expect(account2.pin).toBe(1122);
})

test("deposit into account1", () => {
    account1.deposit(1000, 1111);
    expect(account1.getBalance()).toBe(1000);
})

test("deposit into account2", () => {
    account2.deposit(2000, 1122);
    expect(account2.getBalance()).toBe(2000);
})

test("withdraw from account1", () => {
    account1.withdraw(500, 1111);
    expect(account1.getBalance()).toBe(500);
})

test("withdraw from account2", () => {
    account2.withdraw(1000, 1122);
    expect(account2.getBalance()).toBe(1000);
})

test("withdraw more than balance from account1", () => {
    expect(() => {
        account1.withdraw(600, 1111);
    }).toThrow("Insufficient funds for withdrawal.");
})

test("withdraw more than balance from account2", () => {
    expect(() => {
        account2.withdraw(2000, 1122);
    }).toThrow("Insufficient funds for withdrawal.");
})

test("deposit negative amount into account1", () => {
    expect(() => {
        account1.deposit(-500, 1111);
    }).toThrow("Deposit amount must be positive.");
})

test("deposit negative amount into account2", () => {  
    expect(() => {
        account2.deposit(-1000, 1122);
    }).toThrow("Deposit amount must be positive.");
})

test("withdraw negative amount from account1", () => {
    expect(() => {
        account1.withdraw(-500, 1111);
    }).toThrow("Withdrawal amount must be positive.");
})

test("withdraw negative amount from account2", () => {
    expect(() => {
        account2.withdraw(-1000, 1122);
    }).toThrow("Withdrawal amount must be positive.");
})

test("deposit with wrong pin into account1", () => {
    expect(() => {
        account1.deposit(500, 2222);
    }).toThrow("Invalid PIN. Cannot deposit.");
})

test("deposit with wrong pin into account2", () => {
    expect(() => {
        account2.deposit(1000, 2222);
    }).toThrow("Invalid PIN. Cannot deposit.");
})

test("withdraw with wrong pin from account1", () => {
    expect(() => {
        account1.withdraw(500, 2222);
    }).toThrow("Invalid PIN. Cannot withdraw.");
})

test("withdraw with wrong pin from account2", () => {
    expect(() => {
        account2.withdraw(1000, 2222);
    }).toThrow("Invalid PIN. Cannot withdraw.");
})

test("deposit non-numeric amount into account1", () => {
    expect(() => {
        account1.deposit("500", 1111);
    }).toThrow("Deposit amount must be a number.");
})

test("deposit non-numeric amount into account2", () => {
    expect(() => {
        account2.deposit("1000", 1122);
    }).toThrow("Deposit amount must be a number.");
})  

test("withdraw non-numeric amount from account1", () => {
    expect(() => {
        account1.withdraw("500", 1111);
    }).toThrow("Withdrawal amount must be a number.");
})

test("withdraw non-numeric amount from account2", () => {
    expect(() => {
        account2.withdraw("1000", 1122);
    }).toThrow("Withdrawal amount must be a number.");
})

test("transfer from account1 to account2", () => {
    account1.transfer(200, 1111, account2);
    expect(account1.getBalance()).toBe(300);
    expect(account2.getBalance()).toBe(1200);
})

test("transfer more than balance from account1 to account2", () => {
    expect(() => {
        account1.transfer(500, 1111, account2);
    }).toThrow("Insufficient funds for transfer.");
})

test("transfer negative amount from account1 to account2", () => {
    expect(() => {
        account1.transfer(-200, 1111, account2);
    }).toThrow("Transfer amount must be positive.");
})

test("transfer with wrong pin from account1 to account2", () => {   
    expect(() => {
        account1.transfer(200, 2222, account2);
    }).toThrow("Invalid PIN. Cannot transfer.");
})  

test("transfer from closed account1 to account2", () => {
    account1.closeAccount();
    expect(() => {
        account1.transfer(200, 1111, account2);
    }).toThrow("Account is closed. Cannot transfer.");
})

test("transfer from account1 to closed account2", () => {
    account2.closeAccount();
    expect(() => {
        account1.transfer(200, 1111, account2);
    }).toThrow("Account is closed. Cannot transfer.");
})

test("transfer from closed account1 to closed account2", () => {
    account1.closeAccount();
    account2.closeAccount();
    expect(() => {
        account1.transfer(200, 1111, account2);
    }).toThrow("Account is closed. Cannot transfer.");
})

test("close account1", () => {
    account1.closeAccount();
    expect(account1.isClosed).toBe(true);
})

test("close account2", () => {
    account2.closeAccount();
    expect(account2.isClosed).toBe(true);
})






