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
            System.out.print("Enter your first name: ");
            firstName = userInputCollection.nextLine();
            if (!firstName.isEmpty() && firstName.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.print("Please enter a valid name using only letters and spaces: ");
            }
        }


        while (true) {
            System.out.print("Enter your last name: ");
            lastName = userInputCollection.nextLine();
            if (!lastName.isEmpty() && lastName.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.print("Please enter a valid name using only letters and spaces: ");
            }
        }

        while(true) {
            try {
                System.out.print("Enter your PIN: ");
                pin = userInputCollection.nextInt();
                break;
            }catch(InputMismatchException e) {
                System.out.print("Please enter integer only,");
                userInputCollection.next();
            }
        }

        String accountNumber = String.valueOf(accounts.size() + 1);
        AtmMachineApp account = new AtmMachineApp(accountNumber, firstName, lastName, pin);
        accounts.add(account);

        System.out.println("Account created successfully.");
        System.out.println("Account Number: " + accountNumber);
    }

    public void closeAccount() {
        System.out.print("Enter account number: ");
        accountNumber = userInputCollection.next();
        while (true) {
            if (accountNumber.isEmpty()) {
                System.out.print("Invalid account number. Please enter your account number: ");
                accountNumber = userInputCollection.next();
            } else if (!accountNumber.matches("\\d+")) {
                System.out.print("Invalid account number. Please enter number only: ");
                accountNumber = userInputCollection.next();
            } else {
                break;
            }
        }

        while(true) {
            try {
                System.out.print("Enter your PIN: ");
                pin = userInputCollection.nextInt();
                break;
            }catch(InputMismatchException e) {
                System.out.print("Please enter integer only,");
                userInputCollection.next();
            }
        }

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.getPin() == pin) {
                    accounts.remove(account);
                    System.out.println("Account closed successfully.");
                } else {
                    System.out.println("Invalid PIN.");
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void deposit() {

        System.out.print("Enter account number: ");
        accountNumber = userInputCollection.next();
        while (true) {
            if (accountNumber.isEmpty()) {
                System.out.print("Invalid account number. Please enter your account number: ");
                accountNumber = userInputCollection.next();
            } else if (!accountNumber.matches("\\d+")) {
                System.out.print("Invalid account number. Please enter number only: ");
                accountNumber = userInputCollection.next();
            } else {
                break;
            }
        }


        while(true) {
            try {
                System.out.print("Enter your PIN: ");
                pin = userInputCollection.nextInt();
                break;
            }catch(InputMismatchException e) {
                System.out.print("Please enter integer only,");
                userInputCollection.next();
            }
        }

        while (true) {
            try {
                System.out.print("Enter amount to deposit: ");
                amount = userInputCollection.nextDouble();
                if (amount <= 0) {
                    System.out.println("Invalid amount. Please enter a positive amount.");
                }else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input, Please enter a valid amount,");
                userInputCollection.next();
            }
        }


        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.depositMoney(pin, amount);
                return;
            }
        }
        System.out.println("Invalid account number");
    }

    public void withdraw() {
        System.out.print("Enter account number: ");
        accountNumber = userInputCollection.next();
        while (true) {
            if (accountNumber.isEmpty()) {
                System.out.print("Invalid account number. Please enter your account number: ");
                accountNumber = userInputCollection.next();
            } else if (!accountNumber.matches("\\d+")) {
                System.out.print("Invalid account number. Please enter number only: ");
                accountNumber = userInputCollection.next();
            } else {
                break;
            }
        }

        while(true) {
            try {
                System.out.print("Enter your PIN: ");
                pin = userInputCollection.nextInt();
                break;
            }catch(InputMismatchException e) {
                System.out.print("Please enter integer only,");
                userInputCollection.next();
            }
        }

        while(true) {
            try {
                System.out.print("Enter amount to withdraw: ");
                amount = userInputCollection.nextDouble();
                break;
            }catch(InputMismatchException e) {
                System.out.print("Invalid input, Please enter integer only,");
                userInputCollection.next();
            }
        }

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.withdrawMoney(pin, amount);
                return;
            }
        }
        System.out.println("invalid account number");
    }

    public void getBalance() {
        System.out.print("Enter account number: ");
        accountNumber = userInputCollection.next();
        while (true) {
            if (accountNumber.isEmpty()) {
                System.out.print("Invalid account number. Please enter your account number: ");
                accountNumber = userInputCollection.next();
            } else if (!accountNumber.matches("\\d+")) {
                System.out.print("Invalid account number. Please enter number only: ");
                accountNumber = userInputCollection.next();
            } else {
                break;
            }
        }

        while(true) {
            try {
                System.out.print("Enter your PIN: ");
                pin = userInputCollection.nextInt();
                break;
            }catch(InputMismatchException e) {
                System.out.print("Please enter integer only,");
                userInputCollection.next();
            }
        }

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Balance: " + account.getBalance());
                return;
            }
        }
        System.out.println("invalid account number");
    }

    public void changePin() {
        System.out.print("Enter account number: ");
        accountNumber = userInputCollection.next();
        while (true) {
            if (accountNumber.isEmpty()) {
                System.out.print("Invalid account number. Please enter your account number: ");
                accountNumber = userInputCollection.next();
            } else if (!accountNumber.matches("\\d+")) {
                System.out.print("Invalid account number. Please enter number only: ");
                accountNumber = userInputCollection.next();
            } else {
                break;
            }
        }

        while(true) {
            try {
                System.out.print("Enter your PIN: ");
                oldPin = userInputCollection.nextInt();
                break;
            }catch(InputMismatchException e) {
                System.out.print("Please enter integer only,");
                userInputCollection.next();
            }
        }

        while(true) {
            try {
                System.out.print("Enter your PIN: ");
                newPin = userInputCollection.nextInt();
                break;
            }catch(InputMismatchException e) {
                System.out.print("Please enter integer only,");
                userInputCollection.next();
            }
        }

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.changePin(oldPin, newPin);
                return;
            }
        }
        System.out.println("invalid PIN ");
    }

    public void transferMoney() {
        System.out.print("Enter account number: ");
        accountNumber1 = userInputCollection.next();
        while (true) {
            if (accountNumber1.isEmpty()) {
                System.out.print("Invalid account number. Please enter your account number: ");
                accountNumber1 = userInputCollection.next();
            } else if (!accountNumber1.matches("\\d+")) {
                System.out.print("Invalid account number. Please enter number only: ");
                accountNumber1 = userInputCollection.next();
            } else {
                break;
            }
        }

        System.out.print("Enter receiver account number: ");
        accountNumber2 = userInputCollection.next();
        while (true) {
            if (accountNumber2.isEmpty()) {
                System.out.print("Invalid account number. Please enter your account number: ");
                accountNumber2 = userInputCollection.next();
            } else if (!accountNumber2.matches("\\d+")) {
                System.out.print("Invalid account number. Please enter number only: ");
                accountNumber2 = userInputCollection.next();
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("Enter amount to transfer: ");
                amount = userInputCollection.nextDouble();
                if (amount <= 0) {
                    System.out.println("Invalid amount. Please enter a positive amount.");
                }else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input, Please enter a valid amount,");
                userInputCollection.next();
            }
        }

        while(true) {
            try {
                System.out.print("Enter your PIN: ");
                oldPin = userInputCollection.nextInt();
                break;
            }catch(InputMismatchException e) {
                System.out.print("Please enter integer only,");
                userInputCollection.next();
            }
        }

        AtmMachineApp account1 = null;
        AtmMachineApp account2 = null;

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber1)) {
                account1 = account;
            } else if (account.getAccountNumber().equals(accountNumber2)) {
                account2 = account;
            }
        }
        if (account1 != null && account2 != null) {
            account1.transferMoney(account2, amount, pin);
        } else {
            System.out.println("account not found");
        }
    }

    public static void main(String[] args) {
        AtmMachinePrototype app = new AtmMachinePrototype();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Close Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check balance");
            System.out.println("6. Change PIN");
            System.out.println("7. Transfer Money");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    app.createAccount();
                    break;
                case 2:
                    app.closeAccount();
                case 3:
                    app.deposit();
                    break;
                case 4:
                    app.withdraw();
                    break;
                case 5:
                    app.getBalance();
                    break;
                case 6:
                    app.changePin();
                    break;
                case 7:
                    app.transferMoney();
                    break;
                case 8:
                    System.out.println("Thank you for banking with us....");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}


