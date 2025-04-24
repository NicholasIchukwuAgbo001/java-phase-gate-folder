const bank = require('./bank.js');
const bankeBank = new bank();

test("Test create account 1", () => {
    let accountNumber = bankeBank.CreateAccount("Nicholas", "Ichukwu", "1111");
})

test("Test create account 2", () => {
    let accountNumber = bankeBank.CreateAccount("Ade", "Ojo", "1122");
})

test("Close Account with wrong PIN", () => {
    let accountNumber = bankeBank.CreateAccount("Nicholas", "Ichukwu", "1111");
    expect(() => {
    bankeBank.closeAccount(accountNumber, "1122");
    }).toThrow("Invalid PIN.");

})

test("Close Account with wrong AccountNumber", () => {
    let accountNumber = bankeBank.CreateAccount("Nicholas", "Ichukwu", "1111");
    expect(() => {
    bankeBank.closeAccount("2634764373", "1122");
    }).toThrow("Account not found.");

})

test("Test deposit into account 1", () => {
    let accountNumber = bankeBank.CreateAccount("Nicholas", "Ichukwu", "1111");
    bankeBank.deposit(accountNumber, 1000, "1111");
    expect(bankeBank.getBalance(accountNumber, "1111")).toBe(1000);
})

test("Test deposit into account 2", () => {
    let accountNumber = bankeBank.CreateAccount("Ade", "Ojo", "1122");
    bankeBank.deposit(accountNumber, 2000, "1122");
    expect(bankeBank.getBalance(accountNumber, "1122")).toBe(2000);
})

test("withdraw from account 1", () => {
    let accountNumber = bankeBank.CreateAccount("Nicholas", "Ichukwu", "1111");
    bankeBank.deposit(accountNumber, 1000, "1111");
    bankeBank.withdraw(accountNumber, 500, "1111");
    expect(bankeBank.getBalance(accountNumber, "1111")).toBe(500);
})


test("Test withdraw more than balance from account 1", () => {
    let accountNumber = bankeBank.CreateAccount("Nicholas", "Ichukwu", "1111");
    expect(() => {
        bankeBank.withdraw(accountNumber, 600, "1111");
    }).toThrow("Insufficient funds for withdrawal.");
})

test("Test withdraw more than balance from account 2", () => {
    let accountNumber = bankeBank.CreateAccount("Ade", "Ojo", "1122");
    expect(() => {
        bankeBank.withdraw(accountNumber, 2000, "1122");
    }).toThrow("Insufficient funds for withdrawal.");
})

test("Test deposit negative amount into account 1", () => { 
    let accountNumber = bankeBank.CreateAccount("Nicholas", "Ichukwu", "1111");
    expect(() => {
        bankeBank.deposit(accountNumber, -500, "1111");
    }).toThrow("Deposit amount must be positive.");
}
)   

test("Test deposit negative amount into account 2", () => {  
    let accountNumber = bankeBank.CreateAccount("Ade", "Ojo", "1122");
    expect(() => {
        bankeBank.deposit(accountNumber, -500, "1122");
    }).toThrow("Deposit amount must be positive.");
})

test("Test withdraw negative amount from account 1", () => {
    let accountNumber = bankeBank.CreateAccount("Nicholas", "Ichukwu", "1111");
    expect(() => {
        bankeBank.withdraw(accountNumber, -500, "1111");
    }).toThrow("Withdrawal amount must be positive.");
})

test("Test withdraw negative amount from account 2", () => {
    let accountNumber = bankeBank.CreateAccount("Ade", "Ojo", "1122");
    expect(() => {
        bankeBank.withdraw(accountNumber, -500, "1122");
    }).toThrow("Withdrawal amount must be positive.");
})


test("Test get balance with wrong AccountNumber", () => {
    let accountNumber = bankeBank.CreateAccount("Nicholas", "Ichukwu", "1111");
    expect(() => {
        bankeBank.getBalance("2634764373", "1111");
    }).toThrow("Account not found.");
})

test("Tranfer from account 1 to account 2", () => {
    let accountNumber1 = bankeBank.CreateAccount("Nicholas", "Ichukwu", "1111");
    let accountNumber2 = bankeBank.CreateAccount("Ade", "Ojo", "1122");
    bankeBank.deposit(accountNumber1, 1000, "1111");
    bankeBank.transfer(accountNumber1, accountNumber2, 500, "1111");
    expect(bankeBank.getBalance(accountNumber1, "1111")).toBe(500);
    expect(bankeBank.getBalance(accountNumber2, "1122")).toBe(500);
})