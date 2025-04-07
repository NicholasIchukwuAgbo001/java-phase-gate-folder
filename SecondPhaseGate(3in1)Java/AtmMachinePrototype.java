import java.util.ArrayList;

public class AtmMachinePrototype {
    private final ArrayList<AtmMachineApp> accounts;

    public AtmMachinePrototype() {
        this.accounts = new ArrayList<>();
    }


    public String getAccountNumber(String accountNumber) {
        if (accountNumber != null && !accountNumber.isEmpty() && accountNumber.matches("\\d+")) {
            return accountNumber;
        } else {
            throw new IllegalArgumentException("Invalid account number");
        }
    }

   public void getPin(int pin) {
        String pin2 = String.valueOf(pin);
        if (pin2.length() == 4 && pin2.matches("\\d+")) {

        } else {
            throw new IllegalArgumentException("Invalid PIN. PIN must be a 4-digit number");
        }
    }

    public double getAmount(double amount) {
        if (amount > 0) {
            return amount;
        } else {
            throw new IllegalArgumentException("Invalid amount. Amount must be a positive number");
        }
    }


    public void createAccount(String firstName, String lastName, int pin) {
        if (!firstName.isEmpty() && firstName.matches("[a-zA-Z\\s]+") && !lastName.isEmpty() && lastName.matches("[a-zA-Z\\s]+")) {
            String accountNumber = String.valueOf(accounts.size() + 1);
            AtmMachineApp account = new AtmMachineApp(accountNumber, firstName, lastName, pin);
            accounts.add(account);
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public int getAccountNumber(){
        return accounts.size();
    }

    public void closeAccount(String accountNumber, int pin) {
        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPin() == pin) {
                accounts.remove(account);
                return;
            }
        }
        throw new IllegalArgumentException("Account not found or invalid PIN");
    }

    public void deposit(String accountNumber, int pin, double amount) {
        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPin() == pin) {
                account.depositMoney(pin, amount);
                return;
            }
        }
        throw new IllegalArgumentException("Account not found or invalid PIN");
    }

    public void withdraw(String accountNumber, int pin, double amount) {
        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPin() == pin) {
                account.withdrawMoney(pin, amount);
                return;
            }
        }
        throw new IllegalArgumentException("Account not found or invalid PIN");
    }

    public double getBalance(String accountNumber, int pin) {
        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPin() == pin) {
                return account.getBalance();
            }
        }
        throw new IllegalArgumentException("Account not found or invalid PIN");
    }

    public void changePin(String accountNumber, int oldPin, int newPin) {
        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPin() == oldPin) {
                account.changePin(oldPin, newPin);
                return;
            }
        }
        throw new IllegalArgumentException("Account not found or invalid old PIN");
    }

    public void transferMoney(String accountNumber1, String accountNumber2, int pin, double amount) {
        AtmMachineApp account1 = null;
        AtmMachineApp account2 = null;
        for (AtmMachineApp account : accounts) {
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

}