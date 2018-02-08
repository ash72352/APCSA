


package Unit2;

public class SavingsAccount
{
    private double balance;
    private double interestRate;

    public SavingsAccount()
    {
        balance = 0;
        interestRate = 0;
    }


    public SavingsAccount(double initialBalance, double initialRate)
    {
        balance = initialBalance;
        interestRate = initialRate;
    }

  
    public void deposit(double amount)
    {
        balance = balance + amount;
    }


    public void withdraw(double amount)
    {
        balance = balance - amount;
    }


    public double getBalance()
    {
        return balance;
    }
    public void addInterest()
    {
    	balance = ((interestRate) * balance) + balance;
    }
}
