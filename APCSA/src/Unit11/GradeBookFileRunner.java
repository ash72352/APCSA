package Unit11;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;
import java.io.File;

public class GradeBookFileRunner
{
   public static void main( String args[] ) throws Exception
   {
		out.println("Welcome to the Class Stats program!");
		
		Scanner k = new Scanner(new File(System.getProperty("user.dir") + "\\src\\Unit11\\" + "gradebook.dat"));

		String name = k.nextLine();

		int size = Integer.parseInt(k.nextLine());
		
		
		Class c = new Class(name, size);
		String sName = "-1";
		String grades = "-1";
		

		Student s;
		for(int i = 0; i< size; i ++)
		{

			sName = k.nextLine();

			grades = k.nextLine();

			s = new Student(sName, grades);
			c.addStudent(i, s);
		}
		
		out.println("\n");
		out.println(c);
		Class a = new Class(name, size);
		//Student[] p = new Student[size];
		List<Student> p = new ArrayList<Student>();
		/*for(int i = 0; i < size; i++)
		{
			p[i] = c.getStudent(i);
		}*/
		for(int i = 0; i < size; i++)
		{
			p.add(c.getStudent(i));
		}
		
		Student w;
		boolean isSorted = false;
		boolean yn = false;
		boolean goneThrough = false;
		/*while(isSorted == false)
		{
			yn = true;
			for(int i = 0; i < size-1; i++)
			{
				if(p[i].getAverage() > p[i + 1].getAverage())
				{
					w = p[i+1];
					p[i + 1] = p[i];
					p[i] = w;
					goneThrough = true;
					if(goneThrough)
					{
						yn = false;
						break;
					}
				}
				
			}
			if(yn)
				isSorted=true;
		}
		for(int i = 0; i < size; i++)
		{
			
			a.addStudent(i, p[i]);
			
		}*/
		
		while(isSorted == false)
		{
			yn = true;
			for(int i = 0; i < size-1; i++)
			{
				if(p.get(i).getAverage() > p.get(i + 1).getAverage())
				{
					w = p.get(i+1);
					p.set(i + 1, p.get(i));
					p.set(i,w);
					goneThrough = true;
					if(goneThrough)
					{
						yn = false;
						break;
					}
				}
				
			}
			if(yn)
				isSorted=true;
		}
		for(int i = 0; i < size; i++)
		{
			
			a.addStudent(i, p.get(i));
			
		}
		c = a;
		out.println(c);
		out.println("Failure List = " + c.getFailureList(70));	
		out.println("Highest Average = " + c.getStudentWithHighestAverage());
		out.println("Lowest Average = " + c.getStudentWithLowestAverage());
								
		out.println(String.format("Class Average = %.2f",c.getClassAverage()));
		
		
		
		
		
		
		
		
		
		
		
		
		
		k.close();
	}		
}