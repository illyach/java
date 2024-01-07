import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        // Ініціалізація об'єкта BankAccount перед кожним тестом
        account = new BankAccount(1, "illya lupu", 1000);
    }


    @After
    public void tearDown() {
        // Закриття ресурсів, якщо це потрібно
    }

    @Test
    public void depositPositiveAmount() throws NegativeAmountException {
        account.deposit(100);
        assertEquals(1100, account.getBalance(),0.001);
    }


    @Test
    public void depositNegativeAmount() {
        try {
            account.deposit(-100);
            fail("Expected NegativeAmountException was not thrown");
        } catch (NegativeAmountException e) {
            assertEquals("Сума вкладу може бути негативною", e.getMessage());
        }
        assertEquals(1000, account.getBalance(), 0.001); // Додайте третій параметр для порівняння double
    }


    @Test
    public void withdrawPositiveAmount() throws NegativeAmountException, InsufficientFundsException {
        account.withdraw(100);
        assertEquals(900, account.getBalance(), 0.001);
    }


    @Test
    public void withdrawNegativeAmount() {
        try {
            account.withdraw(-100);
            fail("Expected NegativeAmountException was not thrown");
        } catch (NegativeAmountException e) {
            assertEquals("Сума зняття не може бути негативною", e.getMessage());
        } catch (InsufficientFundsException e) {
            fail("Unexpected InsufficientFundsException thrown");
        }
        assertEquals(1000, account.getBalance(), 0.001); // Додайте третій параметр для порівняння double
    }


    @Test
    public void withdrawInsufficientFunds() {
        // Arrange
        double initialBalance = account.getBalance();

        // Act & Assert
        InsufficientFundsException exception = assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(2000);
        });

        assertEquals("Недостатньо коштів на рахунку", exception.getMessage());
        assertEquals(initialBalance, account.getBalance(), 0.001);
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000, account.getBalance(), 0.001);
    }




    @Test
    public void testDepositAndWithdraw() throws NegativeAmountException, InsufficientFundsException {
        account.deposit(200);
        assertEquals(1200, account.getBalance(), 0.001);

        account.withdraw(300);
        assertEquals(900, account.getBalance(), 0.001);
    }
}
