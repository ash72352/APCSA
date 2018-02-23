package Unit8;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.lang.System;
import java.lang.Math;
import java.util.Scanner;

public class Grades
{
	//instance variables
	private int size;
	private double[] grades;
	

	//constructor
	public void Grades()
	{
		
	}
	
	public void Grades(int s)
	{
		size = s;
		grades = new double[s];
		Scanner k = new Scanner(System.in);
		double input = 0.0;
		for(int i = 0; i < size; i++)
		{
			System.out.println("Enter grade #" + (i+1) + ":");

			input = k.nextDouble();

			grades[i] = input;
			
		}
	}
	
	public void setGrades(int s)
	{
		size = s;
		grades = new double[s];
		Scanner k = new Scanner(System.in);
		double input = 0.0;
		for(int i = 0; i < size; i++)
		{
			System.out.println("Enter grade #" + (i+1) + ":");
			input = k.nextDouble();
			grades[i] = input;
			
		}
	}

	//set method



	private double getSum()
	{
		double sum=0.0;
		
		for(int i = 0; i < size; i++)
		{
			sum = sum + grades[i];
		}


		return sum;
	}

	public double getAverage()
	{
		double average=0.0;
		average = getSum() / size;


		return average;
	}


	//toString method
	public String toString()
	{
		String output ="";
		for(int i = 0; i < size; i++)
		{
			output = output + "grade #" + i + ":\t" + grades[i] + "\n";
		}
		output = output + "The average is: " + getAverage() + ".";
		return output;
	}



}