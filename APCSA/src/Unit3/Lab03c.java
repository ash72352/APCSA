package Unit3;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Lab03c
{
	public static void main( String[] args )
 {
	int a,b,c;
	Scanner keyboard = new Scanner(System.in);
	
	System.out.println("Enter a :: ");
	a = keyboard.nextInt();
	
	System.out.println("Enter b :: ");
	b = keyboard.nextInt();
	
	System.out.println("Enter c :: ");
	c = keyboard.nextInt();
 	Quadratic test = new Quadratic(a,b,c);
 	test.calcRoots();
 	test.print();
 	
 	System.out.println("Enter a :: ");
	a = keyboard.nextInt();
	
	System.out.println("Enter b :: ");
	b = keyboard.nextInt();
	
	System.out.println("Enter c :: ");
	c = keyboard.nextInt();
	
 	test.setEquation(a, b, c);
 	test.calcRoots();
 	test.print();
 	
		
		
 }
}