package Unit6;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab06g
{
	public static void main ( String[] args )
	{
		//add test cases
		LoopStats test = new LoopStats();
		
		test.setNums(1, 5);
		int total = test.getTotal();
		int odd = test.getOddCount();
		int even = test.getEvenCount();
		System.out.println("1\t5 \nTotal: " + total + "\nEven Count: " + even + "\nOdd Count: " + odd + "\n");
		
		test.setNums(2, 8);
		total = test.getTotal();
		odd = test.getOddCount();
		even = test.getEvenCount();
		System.out.println("2\t8 \nTotal: " + total + "\nEven Count: " + even + "\nOdd Count: " + odd + "\n");
		
		test.setNums(5, 15);
		total = test.getTotal();
		odd = test.getOddCount();
		even = test.getEvenCount();
		System.out.println("5\t15 \nTotal: " + total + "\nEven Count: " + even + "\nOdd Count: " + odd + "\n");
		
		
		
		
		
					
	}
}