package bankApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    Bank bank = new Bank();

    @Test
    public void testCreateAccount1() {
        String accountNumber = bank.createAccount("Nicholas", "Ichukwu", 1234);
    }

    @Test
    public void testCreateAccount2() {
        String accountNumber = bank.createAccount("john", "adah", 1122);
    }

    @Test
    public void testCloseAccount() {
        String accountNumber = bank.createAccount("john", "adah", 1234);
        bank.closeAccount(accountNumber, 1234);
        assertThrows(IllegalArgumentException.class, () -> bank.getBalance(accountNumber, 1234));
    }

    @Test
    public void testDeposit() {
        String accountNumber = bank.createAccount("idowu", "moses", 1122);
        bank.deposit(accountNumber, 1122, 2000);
        assertEquals(2000, bank.getBalance(accountNumber, 1122) );
    }

    @Test
    public void testDepositIsLessThanOrEqualZero() {
        String accountNumber = bank.createAccount("idowu", "moses", 1122);
        assertThrows(IllegalArgumentException.class, () -> bank.deposit(accountNumber,  1122, 0));
    }

    @Test
    public void testDepositWithWrongPin() {
        String accountNumber = bank.createAccount("idowu", "moses", 1122);
        assertThrows(IllegalArgumentException.class, () -> bank.deposit(accountNumber,  1111, 0));
    }

    @Test
    public void testWithdraw() {
        String accountNumber = bank.createAccount("idowu", "moses", 1122);
        bank.deposit(accountNumber, 1122, 2000);
        bank.withdraw(accountNumber, 1122, 1000);
        assertEquals(1000, bank.getBalance(accountNumber, 1122) );
    }

    @Test
    public void testWithdrawIsLessThanOrEqualZero() {
        String accountNumber = bank.createAccount("idowu", "moses", 1122);
        assertThrows(IllegalArgumentException.class, () -> bank.withdraw(accountNumber,  1122, 0));
    }

    @Test
    public void testWithdrawWithWrongPin() {
        String accountNumber = bank.createAccount("idowu", "moses", 1122);
        bank.deposit(accountNumber, 1122, 1000);
        assertThrows(IllegalArgumentException.class, () -> bank.withdraw(accountNumber,  1111, 0));
    }

    @Test
    public void testChangePin() {
        String accountNumber = bank.createAccount("Idowu", "moses", 1122);
        bank.changePin(accountNumber, 1122, 1111);
        assertTrue(bank.isValidPin(accountNumber, 1111));
    }

    @Test
    public void testOldPinMustNotEqualToNewPin() {
        String accountNumber = bank.createAccount("Idowu", "moses", 1122);
        assertThrows(IllegalArgumentException.class, () -> bank.changePin(accountNumber, 1122, 1122));
    }


    @Test
    public void testTransfer() {
        String accountNumber1 = bank.createAccount("Niko", "Ichukwu", 5555);
        String accountNumber2 = bank.createAccount("idowu", "moses", 1122);
        bank.deposit(accountNumber1, 5555, 2000);
        bank.transferMoney(accountNumber1, accountNumber2, 5555, 500);
    }

        @Test
        public void testTransferWithWrongPin() {
            String accountNumber1 = bank.createAccount("Niko", "Ichukwu", 5555);
            String accountNumber2 = bank.createAccount("idowu", "moses", 1122);
            bank.deposit(accountNumber1, 5555, 2000);
            assertThrows(IllegalArgumentException.class, () -> bank.transferMoney(accountNumber1, accountNumber2, 1155, 500));
        }

    @Test
    public void testTransferIsGreaterThanBalance() {
        String accountNumber1 = bank.createAccount("Niko", "Ichukwu", 5555);
        String accountNumber2 = bank.createAccount("idowu", "moses", 1122);
        bank.deposit(accountNumber1, 5555, 2000);
        assertThrows(IllegalArgumentException.class, () -> bank.transferMoney(accountNumber1, accountNumber2, 5555, 5000));
    }

    @Test
    public void testTransferAccountNotFound() {
        String accountNumber1 = bank.createAccount("Niko", "Ichukwu", 5555);
        String accountNumber2 = bank.createAccount("idowu", "moses", 1122);
        bank.deposit(accountNumber1, 5555, 2000);
        assertThrows(IllegalArgumentException.class, () -> bank.transferMoney(accountNumber2, accountNumber2, 1155, 500));
    }

}