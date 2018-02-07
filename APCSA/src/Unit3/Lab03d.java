package Unit3;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Lab03d
{
	public static void main( String[] args )
	{
		int a,b,c,d;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter x one :: ");
		a = keyboard.nextInt();
		
		System.out.println("Enter y one :: ");
		b = keyboard.nextInt();
		
		System.out.println("Enter x two :: ");
		c = keyboard.nextInt();
		
		System.out.println("Enter y two :: ");
		d = keyboard.nextInt();
		
		Distance test = new Distance();
		test.setCoordinates(a, b, c, d);
		test.calcDistance();
		test.print();
		
		System.out.println();
		
		System.out.println("Enter x one :: ");
		a = keyboard.nextInt();
		
		System.out.println("Enter y one :: ");
		b = keyboard.nextInt();
		
		System.out.println("Enter x two :: ");
		c = keyboard.nextInt();
		
		System.out.println("Enter y two :: ");
		d = keyboard.nextInt();
		
		test.setCoordinates(a, b, c, d);
		test.calcDistance();
		test.print();
		
		
			
	}
}