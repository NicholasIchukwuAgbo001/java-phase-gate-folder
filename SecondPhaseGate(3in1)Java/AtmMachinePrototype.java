import java.util.ArrayList;
import java.util.Scanner;

public class AtmMachinePrototype {
    private final ArrayList<AtmMachineApp> accounts;
    private final Scanner userInputCollection;

    public AtmMachinePrototype() {
        this.accounts = new ArrayList<>();
        this.userInputCollection = new Scanner(System.in);
    }

    public void createAccount() {

        System.out.print("Enter your first name: ");
        String firstName = userInputCollection.next();

        System.out.print("Enter your last name: ");
        String lastName = userInputCollection.next();

        System.out.print("Enter your PIN: ");
        int pin = userInputCollection.nextInt();

        String accountNumber = String.format("%010d", accounts.size() + 1);
        AtmMachineApp account = new AtmMachineApp(accountNumber, firstName, lastName, pin);
        accounts.add(account);

        System.out.println("Account created successfully.");

        System.out.println("Account Number: " + accountNumber);
    }


    public void deposit() {
        System.out.print("Enter account number: ");
        String accountNumber = userInputCollection.next();

        System.out.print("Enter PIN: ");
        int pin = userInputCollection.nextInt();

        System.out.print("Enter amount to deposit: ");
        double amount = userInputCollection.nextDouble();

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
        String accountNumber = userInputCollection.next();

        System.out.print("Enter PIN: ");
        int pin = userInputCollection.nextInt();

        System.out.print("Enter amount to withdraw: ");
        double amount = userInputCollection.nextDouble();

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
        String accountNumber = userInputCollection.next();

        System.out.print("Enter PIN: ");
        int pin = userInputCollection.nextInt();

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
        String accountNumber = userInputCollection.next();

        System.out.print("Enter old PIN: ");
        int oldPin = userInputCollection.nextInt();

        System.out.print("Enter new PIN: ");
        int newPin = userInputCollection.nextInt();

        for (AtmMachineApp account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.changePin(oldPin, newPin);
                return;
            }
        }
        System.out.println("invalid PIN ");
    }

    public void transferMoney() {
        System.out.print("Enter your account number: ");
        String accountNumber1 = userInputCollection.next();

        System.out.print("Enter receiver account number: ");
        String accountNumber2 = userInputCollection.next();

        System.out.print("Enter amount to transfer: ");
        double amount = userInputCollection.nextDouble();

        System.out.print("Enter your PIN: ");
        int pin = userInputCollection.nextInt();

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
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check balance");
            System.out.println("5. Change PIN");
            System.out.println("6. Transfer Money");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    app.createAccount();
                    break;
                case 2:
                    app.deposit();
                    break;
                case 3:
                    app.withdraw();
                    break;
                case 4:
                    app.getBalance();
                    break;
                case 5:
                    app.changePin();
                    break;
                case 6:
                    app.transferMoney();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}


