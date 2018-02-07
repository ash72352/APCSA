package Unit3;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Quadratic
{
	private int a, b, c;
	private double rootOne;
	private double rootTwo;
	private double fourAC;
	private double bSquared;


	public Quadratic(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;

	}

	public void setEquation(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;

	}

	public void calcRoots( )
	{
		fourAC = 4*a*c;
		bSquared = b * b;
		double twoA = 2*a;
		double negB = -1 * b;
		rootOne = (negB + Math.pow((bSquared - fourAC), 0.5))/twoA;
		rootTwo = (negB - Math.pow((bSquared - fourAC), 0.5))/twoA;

	}

	public void print( )
	{
		if((bSquared - fourAC) < 0)
		{
			System.out.println("ERROR :: Unreal Roots.");
		}
		else if((bSquared - fourAC) >= 0)
		{
			System.out.println("root one :: ");
			System.out.printf("%.2f\n", rootOne);
			
			System.out.println("root two :: ");
			System.out.printf("%.2f\n", rootTwo);

		}

		
	}
}