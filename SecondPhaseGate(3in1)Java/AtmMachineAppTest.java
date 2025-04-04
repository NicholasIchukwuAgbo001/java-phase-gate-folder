import org.junit.Test;

import static org.junit.Assert.*;

public class AtmMachineAppTest {

    AtmMachineApp account1 = new AtmMachineApp("Nicholas", "Ichukwu", 1010);
    AtmMachineApp account2 = new AtmMachineApp("John", "Adah", 1212);


    @Test
    public void testAtmMachineAppIsCreated() {
        assertNotNull(account1);
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
        assertEquals(100, account1.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawMoney() {
        account1.depositMoney(1010,500);
        account1.withdrawMoney(1010,200);
        assertEquals(300, account1.getBalance(), 0.01);
    }

    @Test
    public void testCheckAccountBalance() {
        account1.depositMoney(1010,200.6);
        assertEquals(200.6, account1.getBalance(), 0.01);

    }

    @Test
    public void testTransferMoney() {
        account1.depositMoney(1010,700);
        account1.transferMoney(account2,200, 1010);
        assertEquals(500, account1.getBalance(), 0.01);
        assertEquals(200, account2.getBalance(), 0.01);
    }

    @Test
    public void testChangePin() {
        account1.changePin(1010,2020);
        assertEquals(2020, account1.getPin());
    }

}