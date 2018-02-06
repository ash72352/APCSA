package Unit3;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import java.lang.Math.*;

public class Triangle
{
	private int sideA, sideB, sideC;
	private double perimeter;
	private double theArea;

	public Triangle()
	{
	   setSides(0,0,0);
	   perimeter=0;
	   theArea=0;
	}

	public Triangle(int a, int b, int c)
	{


	}


	public void setSides(int a, int b, int c)
	{
		sideA = a;
		sideB = b;
		sideC = c;

	}

	public void calcPerimeter( )
	{
		perimeter = sideA + sideB + sideC;

	}

	public void calcArea( )
	{
		double s;
		s = perimeter / 2;
		theArea = Math.pow((s*(s-sideA) * (s-sideB) * (s-sideC)),0.5);

	}

	public void print( )
	{


		System.out.println("\n\n");
		System.out.println("For a triangle with side lengths of " + sideA + ", " + sideB + ", and " + sideC + " the area of the triangle is " + theArea + ".");
	}
}