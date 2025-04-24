package bankApp;
import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private final ArrayList<Account> accounts = new ArrayList<>();

    public String createAccount(String firstName, String lastName, int pin) {
        String accountNumber;
        if (firstName.matches("[a-zA-Z\\s]+") && lastName.matches("[a-zA-Z\\s]+") && !lastName.isEmpty()) {
            Random random = new Random();
            accountNumber = String.format("%010d", random.nextInt(1000000000));
            Account account = new Account(accountNumber, firstName, lastName, pin);
            accounts.add(account);
        } else {
            throw new IllegalArgumentException("Invalid input. try again");
        }
        return accountNumber;
    }


    public String getAccountNumber2(){
        return accounts.getLast().getAccountNumber();
    }


    public void closeAccount(String accountNumber, int pin) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPin() == pin) {
                accounts.remove(account);
                return;
            }

            if(account.getPin() != pin) {
                throw new IllegalArgumentException("Invalid pin");
            }

        }
        throw new IllegalArgumentException("Account not found");
    }

    public void deposit(String accountNumber, int pin, double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.getPin() == pin) {
                    account.depositMoney(pin, amount);
                    return;
                } else {
                    throw new IllegalArgumentException("Invalid PIN");
                }
            }
        }
        throw new IllegalArgumentException("Account number not found");
    }



    public void withdraw(String accountNumber, int pin, double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.getPin() == pin) {
                    account.withdrawMoney(pin, amount);
                    return;
                } else {
                    throw new IllegalArgumentException("Invalid PIN");
                }
            }
        }
        throw new IllegalArgumentException("Account number not found");
    }


    public double getBalance(String accountNumber, int pin) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.getPin() == pin) {
                    return account.getBalance();
                } else {
                    throw new IllegalArgumentException("Invalid PIN");
                }
            }
        }
        throw new IllegalArgumentException("Account number not found");
    }


    public void changePin(String accountNumber, int oldPin, int newPin) {
        if (oldPin == newPin) {
            throw new IllegalArgumentException("New PIN cannot be the same as the old PIN.");
        }
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPin() == oldPin) {
                account.changePin(oldPin, newPin);
                return;
            }
            if(!account.getAccountNumber().equals(accountNumber)){
                throw new IllegalArgumentException("Account not  found");
            }

            if(account.getPin() != oldPin) {
                throw new IllegalArgumentException("Invalid old PIN");
            }
        }
        throw new IllegalArgumentException(" Something went wrong or Account not  found");
    }

    public boolean isValidPin(String accountNumber, int pin) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPin() == pin) {
                return true;
            }
            if (!account.getAccountNumber().equals(accountNumber)) {
                throw new IllegalArgumentException("Account not  found");
            }

            if (account.getPin() != pin) {
                throw new IllegalArgumentException("Invalid PIN");
            }

        }
        return false;
    }

    public void transferMoney(String accountNumber1, String accountNumber2, int pin, double amount) {
        Account account1 = null;
        Account account2 = null;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber1)) {
                account1 = account;
            } else if (account.getAccountNumber().equals(accountNumber2)) {
                account2 = account;
            }
        }
        if (account1 != null && account2 != null && !account1.getAccountNumber().equals(account2.getAccountNumber())) {
            if (account1.getPin() == pin) {
                if (account1.getBalance() >= amount) {
                    account1.transferMoney(account2, amount, pin);
                } else {
                    throw new IllegalArgumentException("Insufficient balance");
                }
            } else {
                throw new IllegalArgumentException("Invalid PIN");
            }
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

//    public void transfer(int sender, int reciever, amount, pin){
//        getAccountNumber(reciever).deposit(amount);
//        getAccountNumber(sender).withdraw(amount, pin);
//    }
}

