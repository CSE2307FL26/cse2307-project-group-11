package test;

import main.BankAccount;
import main.UserAccount;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UserAccountTest {
    @Test
    public void testNumAccountsOfNewUser() {
        UserAccount user = new UserAccount();

        assertEquals(0, user.getNumberOfAccounts());
    }

    @Test
    public void testNumAccountsAfterOneAccountAdded() {
        UserAccount user = new UserAccount();
        BankAccount bankAccount = new BankAccount();
        user.addAccount(bankAccount);

        assertEquals(1, user.getNumberOfAccounts());
    }

    @Test
    public void testNumAccountsAfterDeletingOne() {
        UserAccount user = new UserAccount();
        BankAccount firstBankAccount = new BankAccount();
        BankAccount secondBankAccount = new BankAccount();

        user.addAccount(firstBankAccount);
        user.addAccount(secondBankAccount);

        int originalNumberOfAccounts = user.getNumberOfAccounts();
        user.deleteAccount(2);
        int updatedNumberOfAccounts = user.getNumberOfAccounts();
        assertEquals(1, originalNumberOfAccounts - updatedNumberOfAccounts);
    }
}
