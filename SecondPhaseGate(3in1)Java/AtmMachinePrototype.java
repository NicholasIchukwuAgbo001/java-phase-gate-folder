import java.util.ArrayList;
import java.util.Random;

public class AtmMachinePrototype {
    private final ArrayList<AtmMachineApp> accounts;

    public AtmMachinePrototype() {
        this.accounts = new ArrayList<>();
    }


    public String getAccountNumber1(String accountNumber) {
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
        if (firstName.matches("[a-zA-Z\\s]+") && lastName.matches("[a-zA-Z\\s]+") && !lastName.isEmpty() && firstName.length() >= 3  && lastName.length() >= 3) {
            Random random = new Random();
            String accountNumber = "419" + String.format("%7d", random.nextInt(1000000000));
            AtmMachineApp account = new AtmMachineApp(accountNumber, firstName, lastName, pin);
            accounts.add(account);
        } else {
            throw new IllegalArgumentException("Invalid input, Name Must be at least 3 characters");
        }
    }


    public String getAccountNumber(){
        return accounts.getLast().getAccountNumber();
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
        if (oldPin == newPin) {
            throw new IllegalArgumentException("New PIN cannot be the same as the old PIN.");
        }
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