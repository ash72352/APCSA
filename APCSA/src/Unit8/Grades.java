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
	public Grades()
	{
		
	}
	
	public Grades(int s, String a)
	{
		size = s;
		grades = new double[s];
		String[] g = new String[s];
		int counter = 0;
		int c = 0;
		int[] spaces = new int[s - 1];
		for(int i = 0; i < a.length(); i++)
		{
			
			if(a.charAt(i) == ' ')
			{
				
				spaces[c] = i;
				c++;
			}
			
		}
		int index = 0;
		for(int i = 0; i < s-1; i++)
		{

			if(i == 0)
			{
				g[index] = a.substring(0, spaces[i]);
				index++;
				g[index] = a.substring(spaces[i] + 1, spaces[i + 1]);
				
				index++;
			}
			else if(i + 1 == s-1)
			{
				g[index] = a.substring(spaces[i] + 1);
			}
			else
			{
				g[index] = a.substring(spaces[i] + 1, spaces[i + 1]);
				index++;
			}
			
		}
		for(int i = 0; i < s; i++)
		{
			grades[i] = Double.parseDouble(g[i]);
		}
		
	}
	
	public void setGrades(int s, String a)
	{
		size = s;
		grades = new double[s];
		String[] g = new String[s];
		int counter = 0;
		int c = 0;
		int[] spaces = new int[s - 1];
		for(int i = 0; i < a.length(); i++)
		{
			
			if(a.charAt(i) == ' ')
			{
				
				spaces[c] = i;
				c++;
			}
			
		}
		int index = 0;
		for(int i = 0; i < s-1; i++)
		{

			if(i == 0)
			{
				g[index] = a.substring(0, spaces[i]);
				index++;
				g[index] = a.substring(spaces[i] + 1, spaces[i + 1]);
				
				index++;
			}
			else if(i + 1 == s-1)
			{
				g[index] = a.substring(spaces[i] + 1);
			}
			else
			{
				g[index] = a.substring(spaces[i] + 1, spaces[i + 1]);
				index++;
			}
			
		}
		for(int i = 0; i < s; i++)
		{
			grades[i] = Double.parseDouble(g[i]);
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
		return output;
	}



}