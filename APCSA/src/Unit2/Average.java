package Unit2;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Average
{
	//instance variables
	private double one, two, average;

	public void setNums(double num1, double num2)
	{
		one = num1;
		two = num2;

	}

	public void average( )
	{
		double sum= one + two;
		average = sum / 2;

	}
	public void print( )
	{
		System.out.println("The average of " + one + " and " + two + " is " + average + ".");


	}
}