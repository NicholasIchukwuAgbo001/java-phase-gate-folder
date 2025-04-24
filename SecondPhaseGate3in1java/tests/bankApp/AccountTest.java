package bankApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

        Account account1 = new Account("1","Nicholas", "Ichukwu", 1010);
    Account account2 = new Account("2","John", "Adah", 1212);


        @Test
        public void testAtmMachineAppIsCreated1() {
            assertNotNull(account1);
        }

        @Test
        public void testAtmMachineAppIsCreated2() {
            assertNotNull(account2);
        }

        @Test
        public void testCreateAccount1() {
            assertEquals("Nicholas", account1.getFirstName());
            assertEquals("Ichukwu", account1.getLastName());
            assertEquals(1010, account1.getPin());
        }

        @Test
        public void testCreateAccount2() {
            assertEquals("John", account2.getFirstName());
            assertEquals("Adah", account2.getLastName());
            assertEquals(1212, account2.getPin());
        }

        @Test
        public void testCloseAccount() {
            account1.closeAccount();
            assertTrue(account1.isClosed());
        }

        @Test
        public void testDepositMoney() {
            account1.depositMoney(1010,100);
            assertEquals(100, account1.getBalance(), 0.00);
        }

        @Test
        public void testDepositAmountIsLessThanZero_throwException() {
            assertThrows(IllegalArgumentException.class, () -> account1.depositMoney(1010, -200));
        }

        @Test
        public void testInvalidPinWhenDepositingMoney_throwException() {
            assertThrows(IllegalArgumentException.class, () -> account1.depositMoney(1234, 200));
        }

        @Test
        public void testWithdrawMoney() {
            account1.depositMoney(1010,500);
            account1.withdrawMoney(1010,200);
            assertEquals(300, account1.getBalance(), 0.00);
        }

        @Test
        public void testWithdrawAmountIsMoreThanBalance_throwException() {
            account1.depositMoney(1010,500);
            assertThrows(IllegalArgumentException.class, () -> account1.withdrawMoney(1010, 800));
        }

        @Test
        public void testInvalidPinWhenWithdrawing_throwException() {
            account1.depositMoney(1010,500);
            assertThrows(IllegalArgumentException.class, () -> account1.withdrawMoney(1257, 200));
        }

        @Test
        public void testWhenWithdrawingWhileAccountIsClose_throwException() {
            account1.closeAccount();
            assertThrows(IllegalArgumentException.class, () -> account1.withdrawMoney(1010, 300));
        }

        @Test
        public void testCheckAccountBalance() {
            account1.depositMoney(1010,200.6);
            assertEquals(200.6, account1.getBalance(), 0.00);
        }

        @Test
        public void testTransferMoneyValid() {
            account1.depositMoney(1010, 700);
            account1.withdrawMoney(1010, 200);
            account1.transferMoney(account2, 200, 1010);
            assertEquals(300, account1.getBalance(), 0.00);
            assertEquals(200, account2.getBalance(), 0.00);
        }

        @Test
        public void testInvalidPinWhenTransferingMoney_throwException() {
            account1.depositMoney(1010,500);
            assertThrows(IllegalArgumentException.class, () -> account1.transferMoney(account2, 1263, 200));
        }

        @Test
        public void testTransferMoneyWhileAccountIsClose_throwException() {
            account1.closeAccount();
            assertThrows(IllegalArgumentException.class, () -> account1.transferMoney(account2, 1010, 300));
        }


        @Test
        public void testTransferIsMoreThanBalance_throwException() {
            account1.depositMoney(1010,500);
            assertThrows(IllegalArgumentException.class, () -> account1.transferMoney(account2, 1010, 700));
        }


        @Test
        public void testChangePin() {
            account1.changePin(1010,2020);
            assertEquals(2020, account1.getPin());
        }

    }

