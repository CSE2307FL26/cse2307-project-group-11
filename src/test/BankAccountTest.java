package test;

import main.BankAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
            // do nothing, test passes
        }
    }

    public void testBalance() {
        BankAccount testAccount = new BankAccount();
        assertEquals(0, testAccount.getBalance(), 0.01);
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

    @Test
    public void testBalance() {
        BankAccount testAccount = new BankAccount();
        assertEquals(0, testAccount.getBalance(), 0.01);
    }
}

