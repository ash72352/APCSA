package Unit6;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{


	}

	public Prime(int num)
	{
		number = num;

	}

	public void setPrime(int num)
	{
		number = num;

	}

	public boolean isPrime()
	{
		boolean isPrime = true;
		for(int i = 1; i<=number; i++)
		{
			if(number % i == 0)
				isPrime = false;
		}






		return isPrime;
	}

	public String toString()
	{
		String output= "";







		return output;
	}
}