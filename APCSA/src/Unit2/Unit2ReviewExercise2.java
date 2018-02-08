package Unit2;

import java.util.*;

public class Unit2ReviewExercise2 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a velocity: ");
		double v = keyboard.nextDouble();
		
		System.out.println("Enter an acceleration: ");
		double a = keyboard.nextDouble();
		
		//length = v^2/(2a)
		
		double length = (v * v)/(2 * a);
		
		System.out.println("The minimum runway length for this airplane is " + length + ".");
		
		

	}

}
