import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class AtmMachinePrototype {
    private final ArrayList<AtmMachineApp> accounts;
    private final Scanner userInputCollection;
    int pin;
    double amount;
    String accountNumber;
    String firstName;
    String lastName;
    int oldPin;
    int newPin;
    String accountNumber1;
    String accountNumber2;

    public AtmMachinePrototype() {
        this.accounts = new ArrayList<>();
        this.userInputCollection = new Scanner(System.in);
    }

    private String getAccountNumber() {
        while (true) {
            System.out.print("\nEnter account number: ");
            String accountNumber = userInputCollection.next();
            userInputCollection.nextLine();
            if (accountNumber != null && !accountNumber.isEmpty() && accountNumber.matches("\\d+")) {
                return accountNumber;
            } else {
                System.out.print("\nInvalid account number. Please enter your account number: \n");
            }
        }
    }

    private int getPin(String display) {
        while (true) {
            try {
                System.out.print(display);
                String userInput = userInputCollection.nextLine();
                if (userInput != null && !userInput.trim().isEmpty()) {
                    if (userInput.length() != 4 || !userInput.matches("\\d+")) {
                        System.out.print("\nInvalid PIN. Please enter a 4-digit PIN: \n");
                    } else {
                        return Integer.parseInt(userInput);
                    }
                } else {
                    System.out.print("PIN cannot be empty. ");
                }
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter number only,\n");
            }
        }
    }

    private double getAmount() {
        while (true) {
            try {
                System.out.print("\nEnter amount: ");
                double amount = userInputCollection.nextDouble();
                userInputCollection.nextLine();
                if (amount > 0) {
                    return amount;
                } else {
                    System.out.println("\nInvalid amount. Please enter a positive amount.\n");
                }
            } catch (InputMismatchException e) {
                System.out.print("\nInvalid input, Please enter a valid amount.\n");
                userInputCollection.nextLine();
            }
        }
    }



    public void createAccount() {

        while (true) {
            System.out.print("\nEnter your first name: ");
            firstName = userInputCollection.nextLine();
            if (!firstName.isEmpty() && firstName.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.print("\nPlease enter a valid name using only letters and spaces: \n");
            }
        }


        while (true) {
            System.out.print("\nEnter your last name: ");
            lastName = userInputCollection.nextLine();
            if (!lastName.isEmpty() && lastName.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.print("\nPlease enter a valid name using only letters and spaces: \n");
            }
        }

        while (true) {
            try {
                System.out.print("\nEnter your PIN: ");
                String userInput = userInputCollection.nextLine();
                if (userInput.trim().isEmpty()) {
                    System.out.print("PIN cannot be empty. ");
                    continue;
                }
                if (userInput.length() != 4 || !userInput.matches("\\d+")) {
                    System.out.print("\nInvalid PIN. Please enter a 4-digit PIN: \n");
                } else {
                    pin = Integer.parseInt(userInput);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter number only,\n");
            }
        }


        accountNumber = String.valueOf(accounts.size() + 1);
        AtmMachineApp account = new AtmMachineApp(accountNumber, firstName, lastName, pin);
        accounts.add(account);

        System.out.println("\nAccount created successfully.");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Account Number: " + accountNumber);
    }

    public void closeAccount() {
        accountNumber = getAccountNumber();
        pin = getPin("\nEnter your PIN: ");

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.getPin() == pin) {
                    accounts.remove(account);
                    System.out.println("\nAccount closed successfully.\n");
                } else {
                    System.out.println("\nInvalid PIN.\n");
                }
                return;
            }
        }
        System.out.println("\nAccount not found.\n");
    }


    public void deposit() {
        accountNumber = getAccountNumber();
        pin = getPin("\nEnter your PIN: ");
        amount = getAmount();

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.getPin() == pin) {
                    account.depositMoney(pin, amount);
                    System.out.println("\nDeposited successfully.\n");
                } else {
                    System.out.println("\nInvalid PIN.\n");
                }
                return;
            }
        }
        System.out.println("\nInvalid account number\n");
    }


    public void withdraw() {
        accountNumber = getAccountNumber();
        pin = getPin("\nEnter your PIN: ");
        amount = getAmount();

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.getPin() == pin) {
                    try {
                        account.withdrawMoney(pin, amount);
                        System.out.println("\nWithdraw successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nInsuficient balance.\n");
                    }
                } else {
                    System.out.println("\nInvalid PIN.");
                }
                return;
            }
        }
        System.out.println("\nAccount not found.");
    }

    public void getBalance() {
        accountNumber = getAccountNumber();
        pin = getPin("\nEnter your PIN: ");

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("\nBalance: " + account.getBalance());
                return;
            }
        }
        System.out.println("invalid account number\n");
    }

    public void changePin() {
        accountNumber = getAccountNumber();
        oldPin = getPin("\nEnter your old PIN: ");
        newPin = getPin("\nEnter your new PIN: ");

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                try {
                    account.changePin(oldPin, newPin);
                    System.out.println("PIN changed successfully.\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("\nInvalid old PIN. Please try again.\n");
                }
                return;
            }
        }
        System.out.println("\nAccount Not Found. ");
    }

    public void transferMoney() {
        accountNumber1 = getAccountNumber();
        accountNumber2 = getAccountNumber();
        amount = getAmount();
        pin = getPin("\nEnter your PIN: ");

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
                try {
                    account1.transferMoney(account2, amount, pin);
                    System.out.println("Transfer successful\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Insufficient Balance");
                }
            } else {
                System.out.println("Invalid PIN");
            }
        } else if (account1 != null && account2 != null && account1.getAccountNumber().equals(account2.getAccountNumber())) {
            System.out.println("Cannot transfer money to the same account");
        } else {
            System.out.println("Account not found");
        }
    }



    public static void main(String[] args) {
        AtmMachinePrototype option = new AtmMachinePrototype();
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("\nWELCOME TO BANKE BANK 🤝");

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Close Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check balance");
            System.out.println("6. Change PIN");
            System.out.println("7. Transfer Money");
            System.out.println("8. Exit");

            while(true) {
                try {
                    System.out.print("\nEnter your choice: ");
                    choice = input.nextInt();
                    input.nextLine();
                    break;
                }catch (InputMismatchException e) {
                    System.out.print("Invalid input, Please enter a valid choice,");
                    input.nextLine();
                }
            }

            switch (choice) {
                case 1:
                    option.createAccount();
                    break;
                case 2:
                    option.closeAccount();
                    break;
                case 3:
                    option.deposit();
                    break;
                case 4:
                    option.withdraw();
                    break;
                case 5:
                    option.getBalance();
                    break;
                case 6:
                    option.changePin();
                    break;
                case 7:
                    option.transferMoney();
                    break;
                case 8:
                    System.out.println("Thanks you for banking with us(BANKE BANK)🤗...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }

        }

    }

}


