package test;

import main.Bank;
import main.BankAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount testAccount = new BankAccount();
        testAccount.deposit(50);
        assertEquals(50, testAccount.getBalance(), 0.01);
    }

    @Test
    public void testInvalidDeposit() {
        BankAccount testAccount = new BankAccount();
        try {
            testAccount.deposit(-50);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing, test passes
        }
    }

    @Test
    public void testWithdraw() {
        BankAccount testAccount = new BankAccount();
        testAccount.deposit(100);
        testAccount.withdraw(50);
        assertEquals(50, testAccount.getBalance(), 0.01);
    }

    @Test
    public void testInvalidWithdraw() {
        BankAccount testAccount = new BankAccount();
        testAccount.deposit(100);
        try{
            testAccount.withdraw(-50);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing, test passes.
        }
    }

    @Test
    public void testInsufficientBalance() {
        BankAccount testAccount = new BankAccount();
        testAccount.deposit(100);
        try {
            testAccount.withdraw(200);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing
        }
    }
    
    @Test
    public void testInitialAccount() {
        Bank bank = new Bank();
        assertEquals(1, bank.getAccountCount());
    }

    @Test
    public void testCreateAdditionalAccount() {
        Bank bank = new Bank();
        bank.createAccount();

        assertEquals(2, bank.getAccountCount());
    }

    @Test
    public void testNewAccountBalance() {
        Bank bank = new Bank();
        BankAccount newAccount = bank.createAccount();

        assertEquals(0, newAccount.getBalance(), 0.01);
    }

    @Test
    public void testExistingAccountUnchanged() {
        Bank bank = new Bank();
        BankAccount firstAccount = bank.getAccount(0);
        firstAccount.deposit(100);

        bank.createAccount();

        assertEquals(100, firstAccount.getBalance(), 0.01);
        assertEquals(0, bank.getAccount(1).getBalance(), 0.01);
    }

    @Test
    public void testNewAccountExists() {
        Bank bank = new Bank();
        BankAccount newAccount = bank.createAccount();

        assertNotNull(newAccount);
    }
}

