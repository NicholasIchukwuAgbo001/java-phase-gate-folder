import java.util.Scanner;
import java.util.InputMismatchException;

public static void main(String[] args) {

    AtmMachinePrototype option = new AtmMachinePrototype();
    Scanner userInputCollection = new Scanner(System.in);

    int choice;
    String firstName;
    String lastName;
    int pin;
    String accountNumber;
    double amount;
    int newPin;
    int oldPin;
    String accountNumber1;
    String accountNumber2;

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

        while (true) {
            try {
                System.out.print("\nEnter your choice: ");
                choice = userInputCollection.nextInt();
                userInputCollection.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid userInputCollection, Please enter a valid choice,");
                userInputCollection.nextLine();
            }
        }

        switch (choice) {

            case 1:

                while (true) {
                    try {
                        System.out.print("\nEnter your first name: ");
                        firstName = userInputCollection.nextLine();
                        if (!firstName.matches("[a-zA-Z\\s]+")) {
                            throw new IllegalArgumentException("Invalid first name. Please enter a name containing only letters and spaces.");
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                    }
                }


                while (true) {
                    try {
                        System.out.print("\nEnter your last name: ");
                        lastName = userInputCollection.nextLine();
                        if (!lastName.matches("[a-zA-Z\\s]+")) {
                            throw new IllegalArgumentException("Invalid last name. Please enter a name containing only letters and spaces.");
                        }
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
                        option.getPin(pin);
                        break;
                    } catch (Exception e) {
                        System.out.println("\nInvalid input. Please enter a valid PIN.");
                    }
                }


                try {
                    option.createAccount(firstName, lastName, pin);
                    System.out.println("\nAccount created successfully.");
                    System.out.println("Your account number is: " + option.getAccountNumber());
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
                        option.getAccountNumber(accountNumber);
                        break;
                    }catch (IllegalArgumentException e) {
                    System.out.println("\n" + e.getMessage());}
                }

                while (true) {
                    try {
                        System.out.print("\nEnter your PIN: ");
                        String pinStr = userInputCollection.nextLine();
                        pin = Integer.parseInt(pinStr);
                        option.getPin(pin);
                        break;
                    } catch (Exception e) {
                        System.out.println("\nInvalid input. Please enter a valid PIN.");
                    }
                }


                try {
                    option.closeAccount(accountNumber, pin);
                    System.out.println("\nAccount closed successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("\nAccount not found or invalid PIN.");
                }
                break;
            case 3:

                while (true) {
                    try {
                        System.out.print("\nEnter your account number: ");
                        accountNumber = userInputCollection.nextLine();
                        option.getAccountNumber(accountNumber);
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
                        option.getPin(pin);
                        break;
                    } catch (Exception e) {
                        System.out.println("\nInvalid input. Please enter a valid PIN.");
                    }
                }


                while (true) {
                    try {
                        System.out.print("\nEnter the amount to deposit: ");
                        amount = userInputCollection.nextDouble();
                        userInputCollection.nextLine();
                        option.getAmount(amount);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("\nInvalid userInputCollection. Please enter a valid amount.");
                        userInputCollection.nextLine();
                    }
                }

                try {
                    option.deposit(accountNumber, pin, amount);
                    System.out.println("\nDeposit successful.");
                } catch (IllegalArgumentException e) {
                    System.out.println("\nAccount not found or invalid PIN.");
                }
                break;
            case 4:
                while (true) {
                    try {
                        System.out.print("\nEnter your account number: ");
                        accountNumber = userInputCollection.nextLine();
                        option.getAccountNumber(accountNumber);
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
                        option.getPin(pin);
                        break;
                    } catch (Exception e) {
                        System.out.println("\nInvalid input. Please enter a valid PIN.");
                    }
                }

                while(true) {
                    try {
                        System.out.print("\nEnter the amount to withdraw: ");
                        amount = userInputCollection.nextDouble();
                        userInputCollection.nextLine();
                        option.withdraw(accountNumber, pin, amount);
                        break;
                    }catch (IllegalArgumentException e) {
                    System.out.println("\n" + e.getMessage());}
                }

                try {
                    option.withdraw(accountNumber, pin, amount);
                    System.out.println("\nWithdrawal successful.");
                } catch (IllegalArgumentException e) {
                    System.out.println("\nAccount not found or invalid PIN.");
                }
                break;
            case 5:
                while (true) {
                    try {
                        System.out.print("\nEnter your account number: ");
                        accountNumber = userInputCollection.nextLine();
                        option.getAccountNumber(accountNumber);
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
                        option.getPin(pin);
                        break;
                    } catch (Exception e) {
                        System.out.println("\nInvalid input. Please enter a valid PIN.");
                    }
                }

                try {
                    double balance = option.getBalance(accountNumber, pin);
                    System.out.println("\nYour balance is: " + balance);
                } catch (IllegalArgumentException e) {
                    System.out.println("\nAccount not found or invalid PIN.");
                }
                break;
            case 6:
                while (true) {
                    try {
                        System.out.print("\nEnter your account number: ");
                        accountNumber = userInputCollection.nextLine();
                        option.getAccountNumber(accountNumber);
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
                        option.getPin(oldPin);
                        break;
                    } catch (Exception e) {
                        System.out.println("\nInvalid input. Please enter a valid PIN.");
                    }
                }


                while (true) {
                    try {
                        System.out.print("\nEnter your new PIN: ");
                        String pinStr = userInputCollection.nextLine();
                        newPin = Integer.parseInt(pinStr);
                        option.getPin(newPin);
                        break;
                    } catch (Exception e) {
                        System.out.println("\nInvalid input. Please enter a valid PIN.");
                    }
                }


                try {
                    option.changePin(accountNumber, oldPin, newPin);
                    System.out.println("\nPIN changed successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("\nAccount not found or invalid old PIN.");
                }
                break;

            case 7:

                while (true) {
                    try {
                        System.out.print("\nEnter your account: ");
                        accountNumber1 = userInputCollection.nextLine();
                        option.getAccountNumber(accountNumber1); // Validate the account number
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
                        option.getAccountNumber(accountNumber2); // Validate the account number
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
                        option.getPin(pin);
                        break;
                    } catch (Exception e) {
                        System.out.println("\nInvalid input. Please enter a valid PIN.");
                    }
                }

                while (true) {
                    try {
                        System.out.print("\nEnter the amount to transfer: ");
                        amount = userInputCollection.nextDouble();
                        userInputCollection.nextLine();
                        option.getAmount(amount); // Validate the amount
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("\nInvalid userInputCollection. Please enter a valid amount.");
                        userInputCollection.nextLine();
                    }
                }

                try {
                    option.transferMoney(accountNumber1, accountNumber2, pin, amount);
                    System.out.println("\nTransfer successful.");
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