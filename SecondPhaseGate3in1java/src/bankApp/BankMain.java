package bankApp;
import java.util.Scanner;
import java.util.InputMismatchException;


public class BankMain {

    public static void main(String[] args) {

        Bank option = new Bank();

        Scanner userInputCollection = new Scanner(System.in);

        int choice;
        String firstName;
        String lastName;
        int pin;
        int confirmPin;
        String accountNumber;
        double amount;
        int newPin;
        int oldPin;
        String accountNumber1;
        String accountNumber2;

        System.out.println("\nHELLO WELCOME TO BANKE BANK");

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Close Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check balance");
            System.out.println("6. Change PIN");
            System.out.println("7. Transfer Money");
            System.out.println("8. Exit");

            while (true) {
                try {
                    System.out.print("\nEnter your choice: ");
                    String input = userInputCollection.nextLine();
                    if (input.isEmpty()) {
                        System.out.print("choice can't be empty, Please enter a valid choice\n");
                        continue;
                    }
                    choice = Integer.parseInt(input);
                    break;
                } catch (Exception e) {
                    System.out.print("Invalid input, Please enter a valid choice\n ");
                }
            }

            switch (choice) {

                case 1:

                    while (true) {
                        try {
                            System.out.print("\nEnter your first name: ");
                            firstName = userInputCollection.nextLine();
                            validateName(firstName);
                            break;
                        } catch (Exception e) {
                            System.out.println("\n" + e.getMessage());
                        }
                    }


                    while (true) {
                        try {
                            System.out.print("\nEnter your last name: ");
                            lastName = userInputCollection.nextLine();

                            validateName(lastName);
                            break;
                        } catch (Exception e) {
                            System.out.println("\n" + e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter your PIN: ");
                            String pinStr = userInputCollection.nextLine();
                            pin = Integer.parseInt(pinStr);
                            validatePin(pin);
                            System.out.print("\nConfirm your PIN: ");
                            String confirmPinStr = userInputCollection.nextLine();
                            confirmPin = Integer.parseInt(confirmPinStr);
                            if (confirmPin != pin) {
                                System.out.println("\nPIN do not match. Please try again.");
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid PIN. PIN must be a 4-digit number");
                        }
                    }

                    try {
                        option.createAccount(firstName, lastName, pin);
                        System.out.println("\nWELCOME TO BANKE BANK 🤝");
                        System.out.println("\nAccount created successfully. " + firstName + "  " +  lastName );
                        System.out.println("Your account number is: " + option.getAccountNumber2());
                        System.out.println("Save your account number for future transactions/use.");
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                    }

                    break;
                case 2:
                    while (true) {
                        try {
                            System.out.print("\nEnter your account number: ");
                            accountNumber = userInputCollection.nextLine();
                            validateAccountNumber(accountNumber);
                            break;
                        }catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage());}
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter your PIN: ");
                            String pinStr = userInputCollection.nextLine();
                            pin = Integer.parseInt(pinStr);
                            validatePin(pin);
                            System.out.print("\nConfirm your PIN: ");
                            String confirmPinStr = userInputCollection.nextLine();
                            confirmPin = Integer.parseInt(confirmPinStr);
                            if (confirmPin != pin) {
                                System.out.println("\nPIN do not match. Please try again.");
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid PIN. PIN must be a 4-digit number");
                        }
                    }


                    try {
                        option.closeAccount(accountNumber, pin);
                        System.out.println("\nAccount closed successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                    }
                    break;
                case 3:

                    while (true) {
                        try {
                            System.out.print("\nEnter your account number: ");
                            accountNumber = userInputCollection.nextLine();
                            validateAccountNumber(accountNumber);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage());
                        }
                    }


                    while (true) {
                        try {
                            System.out.print("\nEnter the amount to deposit: ");
                            amount = userInputCollection.nextDouble();
                            userInputCollection.nextLine();
                            validateAmount(amount);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage());
                        }

                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter your PIN: ");
                            String pinStr = userInputCollection.nextLine();
                            pin = Integer.parseInt(pinStr);
                            validatePin(pin);
                            System.out.print("\nConfirm your PIN: ");
                            String confirmPinStr = userInputCollection.nextLine();
                            confirmPin = Integer.parseInt(confirmPinStr);
                            if (confirmPin != pin) {
                                System.out.println("\nPIN do not match. Please try again.");
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid PIN. PIN must be a 4-digit number");
                        }
                    }

                    try {
                        option.deposit(accountNumber, pin, amount);
                        System.out.println("\nDeposit of ₦" + amount + " was successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                    }
                    break;
                case 4:
                    while (true) {
                        try {
                            System.out.print("\nEnter your account number: ");
                            accountNumber = userInputCollection.nextLine();
                            validateAccountNumber(accountNumber);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter your PIN: ");
                            String pinStr = userInputCollection.nextLine();
                            pin = Integer.parseInt(pinStr);
                            validatePin(pin);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid PIN. PIN must be a 4-digit number");
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter the amount to withdraw: ");
                            amount = userInputCollection.nextDouble();
                            userInputCollection.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("\nInvalid input. Please enter a valid amount.");
                            userInputCollection.nextLine();
                        }
                    }

                    try {
                        option.withdraw(accountNumber, pin, amount);
                        System.out.println("\nWithdrawal of ₦" + amount + " was successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                    }
                    break;
                case 5:
                    while (true) {
                        try {
                            System.out.print("\nEnter your account number: ");
                            accountNumber = userInputCollection.nextLine();
                            validateAccountNumber(accountNumber);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter your PIN: ");
                            String pinStr = userInputCollection.nextLine();
                            pin = Integer.parseInt(pinStr);
                            validatePin(pin);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid PIN. PIN must be a 4-digit number");
                        }
                    }

                    try {
                        double balance = option.getBalance(accountNumber, pin);
                        System.out.println("\nYour balance is: ₦" + balance);
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                    }
                    break;
                case 6:
                    while (true) {
                        try {
                            System.out.print("\nEnter your account number: ");
                            accountNumber = userInputCollection.nextLine();
                            validateAccountNumber(accountNumber);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter your old PIN: ");
                            String pinStr = userInputCollection.nextLine();
                            oldPin = Integer.parseInt(pinStr);
                            validatePin(oldPin);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid PIN. PIN must be a 4-digit number");
                        }
                    }


                    while (true) {
                        try {
                            System.out.print("\nEnter your new PIN: ");
                            String pinStr = userInputCollection.nextLine();
                            newPin = Integer.parseInt(pinStr);
                            validatePin(newPin);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid PIN. PIN must be a 4-digit number");
                        }
                    }


                    try {
                        option.changePin(accountNumber, oldPin, newPin);
                        System.out.println("\nPIN changed successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                    }
                    break;

                case 7:

                    while (true) {
                        try {
                            System.out.print("\nEnter your account: ");
                            accountNumber1 = userInputCollection.nextLine();
                            validateAccountNumber(accountNumber1);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter receiver account: ");
                            accountNumber2 = userInputCollection.nextLine();
                            if (accountNumber2.equals(accountNumber1)) {
                                throw new IllegalArgumentException("Cannot transfer to the same account.");
                            }
                            validateAccountNumber(accountNumber2);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter the amount to transfer: ");
                            amount = userInputCollection.nextDouble();
                            userInputCollection.nextLine();
                            validateAmount(amount);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("\nInvalid userInputCollection. Please enter a valid amount.");
                            userInputCollection.nextLine();
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("\nEnter your PIN: ");
                            String pinStr = userInputCollection.nextLine();
                            pin = Integer.parseInt(pinStr);
                            validatePin(pin);
                            System.out.print("\nConfirm your PIN: ");
                            String confirmPinStr = userInputCollection.nextLine();
                            confirmPin = Integer.parseInt(confirmPinStr);
                            if (confirmPin != pin) {
                                System.out.println("\nPIN do not match. Please try again.");
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid PIN. PIN must be a 4-digit number");
                        }
                    }


                    try {
                        option.transferMoney(accountNumber1, accountNumber2, pin, amount);
                        System.out.println("\nTransfer of ₦" + amount + " was successful.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                    }
                    break;

                case 8:
                    System.out.println("Thanks for banking with us (BANKE BANK) 🤗...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void validateName(String name) {
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Invalid name, Name must contain only letters.");
        }
    }

    private static void validatePin(int pin) {
        String pin2 = String.valueOf(pin);
        if (pin2.length() != 4 || !pin2.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid PIN. PIN must be a 4-digit number");
        }
    }

    private static void validateAccountNumber(String accountNumber) {
        if (accountNumber.isEmpty() || !accountNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid account number");
        }
    }

  private static void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
    }
}