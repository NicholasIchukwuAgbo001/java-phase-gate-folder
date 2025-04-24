const Bank = require('./bank.js');
const bank = new Bank();
console.log("\nHELLO WELCOME TO BANKE BANK");

while (true) {
    console.log("\n1. Create Account");
    console.log("2. Close Account");
    console.log("3. Deposit Money");
    console.log("4. Withdraw Money");
    console.log("5. Check balance");
    console.log("6. Change PIN");
    console.log("7. Transfer Money");
    console.log("8. Exit");

    const prompt = require('prompt-sync')();
    let choice = prompt("Enter your choice: ");

    let firstName;
    let lastName;
    let pin;
    let accountNumber;
    let amount;
    let newPin;
    let toAccountNumber;

    
    switch (choice){
        case '1':
           while (true) {
            try{
            firstName = prompt("Enter your first name: ").trim();
            bank.validateName(firstName);
            break
            }catch(error) {
                console.log(error.message);
            }
        }

            while (true) {
            try{
            lastName = prompt("Enter your last name: ").trim(); 
            bank.validateName(lastName);
            break;
            }catch(error) {
                console.log(error.message);
            }
        }
            while (true) {
            try{
            pin = prompt("Enter your PIN: ").trim(); 
            bank.validatePin(pin);
            break;
            }catch(error) {
                console.log(error.message);
            }
        }
        
         try{
            bank.CreateAccount(firstName, lastName, pin);
            console.log("\nAccount created successfully.");
            console.log("Account Number: " + bank.getAccount(accountNumber));
            console.log("Account Holder: " + firstName + " " + lastName);
            break;
            }catch(error) {
                console.log(error.message);
            }
           break;

           case '2':
            while (true) {
                try{
                accountNumber = prompt("Enter your account number: ").trim(); 
                bank.validateAccountNumber(accountNumber);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }
         
             while (true) {
                try{
                pin = prompt("Enter your PIN: ").trim(); 
                bank.validatePin(pin);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            try {
                bank.closeAccount(accountNumber, pin);
                console.log("\nAccount closed successfully.");
            } catch (error) {
                console.log(error.message);
            }
            break;
        
        case '3':
            while (true) {
                try{
                accountNumber = prompt("Enter your account number: ").trim(); 
                bank.validateAccountNumber(accountNumber);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            while (true) {
                try{
                amount = parseFloat(prompt("Enter amount to deposit: "));
                bank.validateAmount(amount);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            while (true) {
                try{
                pin = prompt("Enter your PIN: ").trim(); 
                bank.validatePin(pin);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            try {
                bank.deposit(accountNumber, amount, pin);
                console.log(`\nDeposit of ${amount} was successful.`);
            } catch (error) {
                console.log(error.message);
            }
            break;
        case '4':
            while (true) {
                try{
                accountNumber = prompt("Enter your account number: ").trim(); 
                bank.validateAccountNumber(accountNumber);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            while (true) {
                try{
                amount = parseFloat(prompt("Enter amount to withdraw: "));
                bank.validateAmount(amount);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            while (true) {
                try{
                pin = prompt("Enter your PIN: ").trim(); 
                bank.validatePin(pin);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            try {
                bank.withdraw(accountNumber, amount, pin);
                console.log(`\nWithdrawal of ${amount} was successful.`);
            } catch (error) {
                console.log(error.message);
            }
            break;
        case '5':
            while (true) {
                try{
                accountNumber = prompt("Enter your account number: ").trim(); 
                bank.validateAccountNumber(accountNumber);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            while (true) {
                try{
                pin = prompt("Enter your PIN: ").trim(); 
                bank.validatePin(pin);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            try {
                let balance = bank.getBalance(accountNumber, pin);
                console.log(`\nYour balance is: ${balance}`);
            }
            catch (error) {
                console.log(error.message);
            }
            break;
        case '6':
            while (true) {
                try{
                accountNumber = prompt("Enter your account number: ").trim(); 
                bank.validateAccountNumber(accountNumber);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            while (true) {
                try{
                pin = prompt("Enter your old PIN: ").trim(); 
                bank.validatePin(pin);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            while (true) {
                try{
                newPin = prompt("Enter your new PIN: ").trim(); 
                bank.validatePin(newPin);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            try {
                bank.changePin(accountNumber, pin, newPin);
                console.log("\nPIN changed successfully.");
            } catch (error) {
                console.log(error.message);
            }
            break;
        case '7':
            while (true) {
                try{
                accountNumber = prompt("Enter your account number: ").trim(); 
                bank.validateAccountNumber(accountNumber);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            while (true) {
                try{
                toAccountNumber = prompt("Enter the account number to transfer to: ").trim();
                bank.validateAccountNumber(toAccountNumber);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            while (true) {
                try{
                amount = parseFloat(prompt("Enter amount to transfer: "));
                bank.validateAmount(amount);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }

            while (true) {
                try{
                pin = prompt("Enter your PIN: ").trim(); 
                bank.validatePin(pin);
                break;
                }catch(error) {
                    console.log(error.message);
                }
            }


            try {
                bank.transfer(accountNumber, toAccountNumber, amount, pin);
                console.log(`\nTransfer of ${amount} was successful.`);
            } catch (error) {
                console.log(error.message);
            }
            break;
        case '8':
            console.log("Exiting...");
            return;
        default:
            console.log("Invalid choice. Please try again.");
    }
}



    
