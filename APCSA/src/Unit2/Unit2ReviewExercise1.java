package Unit2;

public class Unit2ReviewExercise1 
{

	public static void main(String[] args) 
	{
		SavingsAccount test = new SavingsAccount(1000, 0.1);
		System.out.println("Initial Balance: " + test.getBalance());
		test.addInterest();
		System.out.println("Balance after interest is added: " + test.getBalance());

	}

}
