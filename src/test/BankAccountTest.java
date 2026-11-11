package test;

import main.BankAccount;

import main.Transaction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testTransactionHistoryOfNewAccount() {
        BankAccount testAccount = new BankAccount();
        assertEquals(0, testAccount.getTransactionHistory().size());
    }

    @Test
    public void testTransactionHistoryOfSingleDeposit() {
        BankAccount testAccount = new BankAccount();
        testAccount.deposit(50);
        ArrayList<Transaction> transactions = testAccount.getTransactionHistory();

        Transaction firstTransaction = new Transaction("deposit",50);
        assertEquals(firstTransaction,transactions.get(0));
    }
    @Test
    public void testTransactionHistoryOfMultipleDeposits() {
        BankAccount testAccount = new BankAccount();
        testAccount.deposit(50);
        testAccount.deposit(20);
        ArrayList<Transaction> transactions = testAccount.getTransactionHistory();

        Transaction firstTransaction = new Transaction("deposit",50);
        Transaction secondTransaction = new Transaction("deposit",20);

        assertEquals(firstTransaction,transactions.get(0));
        assertEquals(secondTransaction,transactions.get(1));
    }
}
