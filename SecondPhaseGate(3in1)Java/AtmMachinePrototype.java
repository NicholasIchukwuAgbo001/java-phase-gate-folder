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
        System.out.print("\nEnter account number: ");
        accountNumber = userInputCollection.next();
        userInputCollection.nextLine();
        while (true) {
            if (accountNumber.isEmpty()) {
                System.out.print("\nInvalid account number. Please enter your account number: \n");
                accountNumber = userInputCollection.next();
            } else if (!accountNumber.matches("\\d+")) {
                System.out.print("\nInvalid account number. Please enter number only: \n");
                accountNumber = userInputCollection.next();
                userInputCollection.nextLine();
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("\nEnter your PIN: ");
                String userInput = userInputCollection.nextLine();
                if (userInput.trim().isEmpty()) {
                    System.out.print("\nPIN cannot be empty. \n");
                    continue;
                }
                pin = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter number only.\n");
                userInputCollection.nextLine();
            }
        }


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

        System.out.print("\nEnter account number: ");
        accountNumber = userInputCollection.next();
        userInputCollection.nextLine();
        while (true) {
            if (accountNumber.isEmpty()) {
                System.out.print("\nInvalid account number. Please enter your account number: \n");
                accountNumber = userInputCollection.next();
            } else if (!accountNumber.matches("\\d+")) {
                System.out.print("\nInvalid account number. Please enter number only: \n");
                accountNumber = userInputCollection.next();
            } else {
                break;
            }
        }


        while (true) {
            try {
                System.out.print("\nEnter your PIN: ");
                String userInput = userInputCollection.nextLine();
                if (userInput.trim().isEmpty()) {
                    System.out.print("\nPIN cannot be empty. \n");
                    continue;
                }
                pin = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter number only.\n");
            }
        }

        while (true) {
            try {
                System.out.print("\nEnter amount to deposit: ");
                amount = userInputCollection.nextDouble();
                userInputCollection.nextLine();
                if (amount <= 0) {
                    System.out.println("\nInvalid amount. Please enter a positive amount.\n");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("\nInvalid input, Please enter a valid amount.\n");
                userInputCollection.nextLine();
            }
        }

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
        System.out.print("\nEnter account number: ");
        accountNumber = userInputCollection.next();
        userInputCollection.nextLine();
        while (true) {
            if (accountNumber.isEmpty()) {
                System.out.print("\nInvalid account number. Please enter your account number: \n");
                accountNumber = userInputCollection.next();
                userInputCollection.nextLine();
            } else if (!accountNumber.matches("\\d+")) {
                System.out.print("\nInvalid account number. Please enter number only: \n");
                accountNumber = userInputCollection.next();
                userInputCollection.nextLine();
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("\nEnter your PIN: ");
                String userInput = userInputCollection.next();
                userInputCollection.nextLine();
                if (userInput.trim().isEmpty()) {
                    System.out.print("\nPIN cannot be empty. \n");
                    continue;
                }
                pin = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter number only.\n");
            }
        }


        while (true) {
            try {
                System.out.print("\nEnter amount to withdraw: ");
                amount = userInputCollection.nextDouble();
                userInputCollection.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("\nInvalid input, Please enter integer only.\n");
                userInputCollection.next();
                userInputCollection.nextLine();
            }
        }

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
        System.out.print("\nEnter account number: ");
        accountNumber = userInputCollection.next();
        userInputCollection.nextLine();
        while (true) {
            if (accountNumber.isEmpty()) {
                System.out.print("\nInvalid account number. Please enter your account number: \n");
                accountNumber = userInputCollection.next();
            } else if (!accountNumber.matches("\\d+")) {
                System.out.print("\nInvalid account number. Please enter number only: \n");
                accountNumber = userInputCollection.next();
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("\nEnter your PIN: ");
                String userInput = userInputCollection.nextLine();
                if (userInput.trim().isEmpty()) {
                    System.out.print("\nPIN cannot be empty. \n");
                    continue;
                }
                pin = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter number only.\n");
            }
        }


        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Balance: " + account.getBalance());
                return;
            }
        }
        System.out.println("invalid account number\n");
    }

    public void changePin() {
        System.out.print("\nEnter account number: ");
        accountNumber = userInputCollection.next();
        userInputCollection.nextLine();
        while (true) {
            if (accountNumber.isEmpty()) {
                System.out.print("\nInvalid account number. Please enter your account number: \n");
                accountNumber = userInputCollection.nextLine();
            } else if (!accountNumber.matches("\\d+")) {
                System.out.print("\nInvalid account number. Please enter number only: \n");
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("\nEnter your old PIN: ");
                String userInput = userInputCollection.nextLine();
                if (userInput.trim().isEmpty()) {
                    System.out.print("\nPIN cannot be empty. \n");
                    continue;
                }
                oldPin = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter number only.\n");
            }
        }


        while (true) {
            try {
                System.out.print("\nEnter your new PIN: ");
                String userInput = userInputCollection.nextLine();
                if (userInput.trim().isEmpty()) {
                    System.out.print("\nPIN cannot be empty. \n");
                    continue;
                }
                newPin = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter number only.\n");
            }
        }


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
        System.out.print("\nEnter your account number: ");
        accountNumber1 = userInputCollection.next();
        userInputCollection.nextLine();
        while (true) {
            if (accountNumber1.isEmpty()) {
                System.out.print("\nInvalid account number. Please enter your account number: \n");
                accountNumber1 = userInputCollection.nextLine();
            } else if (!accountNumber1.matches("\\d+")) {
                System.out.print("\nInvalid account number. Please enter number only: \n");
                accountNumber1 = userInputCollection.nextLine();
            } else {
                break;
            }
        }

        System.out.print("\nEnter receiver account number: ");
        accountNumber2 = userInputCollection.next();
        userInputCollection.nextLine();
        while (true) {
            if (accountNumber2.isEmpty()) {
                System.out.print("\nInvalid account number. Please enter your account number: \n");
                accountNumber2 = userInputCollection.next();
                userInputCollection.nextLine();
            } else if (!accountNumber2.matches("\\d+")) {
                System.out.print("\nInvalid account number. Please enter number only: \n");
                accountNumber2 = userInputCollection.next();
                userInputCollection.nextLine();
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("\nEnter amount to transfer: ");
                amount = userInputCollection.nextDouble();
                userInputCollection.nextLine();
                if (amount <= 0) {
                    System.out.println("\nInvalid amount. Please enter a positive amount.\n");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("\nInvalid input, Please enter a valid amount.\n");
                userInputCollection.nextLine();
            }
        }

        while (true) {
            try {
                System.out.print("\nEnter your PIN: ");
                String userInput = userInputCollection.nextLine();
                if (userInput.trim().isEmpty()) {
                    System.out.print("\nPIN cannot be empty. \n");
                    continue;
                }
                pin = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.print("\nPlease enter number only.\n");
            }
        }


        AtmMachineApp account1 = null;
        AtmMachineApp account2 = null;

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber1)) {
                account1 = account;
                System.out.println("Transfer  successful\n");
            } else if (account.getAccountNumber().equals(accountNumber2)) {
                account2 = account;
                System.out.println("Transfer  successful\n");
            }
        }
        if (account1 != null && account2 != null) {
            try {
                account1.transferMoney(account2, amount, pin);
            } catch (IllegalArgumentException e) {
                System.out.println("Insufficient Balance");
            }
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


