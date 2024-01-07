public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Сума вкладу може бути негативною");
        }

        balance += amount;
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount < 0) {
            throw new NegativeAmountException("Сума зняття не може бути негативною");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Недостатньо коштів на рахунку");
        }
        balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + "\nAccount Name: " + accountName + "\nBalance: " + balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

}
