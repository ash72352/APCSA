package Unit6;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.lang.Math;

public class Lab06i
{
	public static void main ( String[] args )
	{
		//add test cases
		Prime test = new Prime();
		
		boolean isPrime;
		int x;
		
		x = 24;
		test.setPrime(x);
		isPrime = test.isPrime();
		if(isPrime == true)
			System.out.println(x + " is prime!\n");
		else
			System.out.println(x + " is not prime.\n");
		
		x = 7;
		test.setPrime(x);
		isPrime = test.isPrime();
		if(isPrime == true)
			System.out.println(x + " is prime!\n");
		else
			System.out.println(x + " is not prime.\n");
		
		x = 100;
		test.setPrime(x);
		isPrime = test.isPrime();
		if(isPrime == true)
			System.out.println(x + " is prime!\n");
		else
			System.out.println(x + " is not prime.\n");
		
		x = 113;
		test.setPrime(x);
		isPrime = test.isPrime();
		if(isPrime == true)
			System.out.println(x + " is prime!\n");
		else
			System.out.println(x + " is not prime.\n");
		
		x = 65535;
		test.setPrime(x);
		isPrime = test.isPrime();
		if(isPrime == true)
			System.out.println(x + " is prime!\n");
		else
			System.out.println(x + " is not prime.\n");
		
		x = 2;
		test.setPrime(x);
		isPrime = test.isPrime();
		if(isPrime == true)
			System.out.println(x + " is prime!\n");
		else
			System.out.println(x + " is not prime.\n");
		
		x = 7334;
		test.setPrime(x);
		isPrime = test.isPrime();
		if(isPrime == true)
			System.out.println(x + " is prime!\n");
		else
			System.out.println(x + " is not prime.\n");
		
		x = 7919;
		test.setPrime(x);
		isPrime = test.isPrime();
		if(isPrime == true)
			System.out.println(x + " is prime!\n");
		else
			System.out.println(x + " is not prime.\n");
		
		x = 1115125003;
		test.setPrime(x);
		isPrime = test.isPrime();
		if(isPrime == true)
			System.out.println(x + " is prime!\n");
		else
			System.out.println(x + " is not prime.\n");
		
		
		
		
		
		
		
		
	}	
}