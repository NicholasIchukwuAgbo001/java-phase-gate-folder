package bankApp;

public class Account {
        private final String firstName;
        private final String lastName;
        private int pin;
        private double balance;
        private Boolean isClosed;
        private final String accountNumber;


        public Account(String accountNumber, String firstName, String lastName, int pin) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.pin = pin;
            this.balance = 0;
            this.isClosed = false;
            this.accountNumber = accountNumber;
        }


        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getPin() {
            return pin;
        }

        public double getBalance() {
            return balance;
        }

        public Boolean isClosed() {
            return this.isClosed;
        }

        public void closeAccount() {
            isClosed = true;
        }

        public void depositMoney(int pin, double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0.");
            }
            if (this.pin == pin && !isClosed) {
                balance += amount;
            } else if (this.pin != pin) {
                throw new IllegalArgumentException("Invalid pin");
            }
        }

        public void withdrawMoney(int pin, double amount) {
            if (this.pin == pin && !isClosed && this.balance >= amount) {
                balance -= amount;
            } else if (this.pin != pin) {
                throw new IllegalArgumentException("Invalid pin");
            } else if (isClosed) {
                throw new IllegalArgumentException("Account closed");
            } else if (amount > this.balance) {
                throw new IllegalArgumentException("Insufficient balance");
            }
        }

        public void transferMoney(Account account2, double amount, int pin) {
            if (this.pin == pin && !isClosed && this.balance >= amount) {
                this.withdrawMoney(pin, amount);
                account2.depositMoney(account2.getPin(), amount);
            } else{
                throw new IllegalArgumentException("Insufficient balance");
            }
            if (this.pin != pin) {
                throw new IllegalArgumentException("Invalid pin");
            } else if (isClosed) {
                throw new IllegalArgumentException("Account closed");
            }
        }

        public void changePin(int oldPin, int newPin) {
            if (this.pin == oldPin) {
                this.pin = newPin;
            } else {
                throw new IllegalArgumentException("Invalid pin");
            }
        }

        public String getAccountNumber() {
            return accountNumber;
        }
    }




