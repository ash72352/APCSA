/*(Print a table) Write a program that displays the following table: 
 * a a^2 a^3 
 * 1 1 1 
 * 2 4 8 
 * 3 9 27 
 * 4 16 64 
 * 1.5 */

package Unit0;

public class Unit0ReviewExercise1 {

	public static void main(String[] args) 
	{
		System.out.println("a   a^2   a^3");
		System.out.println("--------------");
		for(int i = 1; i<=4; i++)
		{
			if(square(i) < 10)
				System.out.println(i + " | " + square(i) + " | " + cube(i));
			else if(square(i) > 10 && square(i) < 100)
				System.out.println(i + " | " + square(i) + "| " + cube(i));
		}

	}
	
	public static double square(double a)
	{
		double b = a * a;
		return b;
	}
	public static double cube(double a)
	{
		double b = a * a * a;
		return b;
	}

}

