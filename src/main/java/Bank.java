import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public int generateUniqueAccountNumber() {
        // Генерируем случайное число от 1 до 9999
        int accountNumber = (int) (Math.random() * 9999) + 1;

        // Проверяем, не существует ли уже счет с таким номером
        for (BankAccount account : this.accounts) {
            if (account.getAccountNumber() == accountNumber) {
                // Если существует, генерируем новый номер
                accountNumber = generateUniqueAccountNumber();
            }
        }

        return accountNumber;
    }

    public void createAccount(String accountName, double initialDeposit) {
        int accountNumber = generateUniqueAccountNumber(); // Implement this method
        BankAccount account = new BankAccount(accountNumber, accountName, initialDeposit);
        this.accounts.add(account);
    }


    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : this.accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws InsufficientFundsException, AccountNotFoundException, NegativeAmountException {
        BankAccount fromAccount = this.findAccount(fromAccountNumber);
        BankAccount toAccount = this.findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}