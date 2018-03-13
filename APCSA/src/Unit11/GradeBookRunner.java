package Unit11;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class GradeBookRunner
{
   public static void main( String args[] )
   {
		out.println("Welcome to the Class Stats program!");
		
		Scanner k = new Scanner(System.in);
		
		
		out.println("What is the name of this class?");
		String name = k.nextLine();
		
		out.println("\n");
		
		out.println("How many students are in this class?");
		int size = k.nextInt();
		
		out.println("\n");
		
		Class c = new Class(name, size);
		String sName = "-1";
		String grades = "-1";
		
		k.nextLine();
		Student s;
		for(int i = 0; i< size; i ++)
		{

			out.println("Enter the name of Student " + (i+1) + "\t:\t");
			sName = k.nextLine();

			out.println("Enter the grades for " + sName + "\nUse the format x - grades ( 2 - 100 100)\t:\t");
			grades = k.nextLine();
			out.println(grades);
			s = new Student(sName, grades);
			c.addStudent(i, s);
		}
		
		out.println("\n");
		out.println(c);
		
		for(int i = 0; i < size; i++)
		{
			out.println(String.format(c.getStudentName(i) + "\'s average %.2f",c.getStudentAverage(i)));
		}
		
		out.println("Failure List = " + c.getFailureList(70));	
		out.println("Highest Average = " + c.getStudentWithHighestAverage());
		out.println("Lowest Average = " + c.getStudentWithLowestAverage());
								
		out.println(String.format("Class Average = %.2f",c.getClassAverage()));
		
		
		
		
		
		
		
		
		
		
		
		
		
		k.close();
		
	}		
}