package Unit11;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.List;
import java.util.ArrayList;

public class Grades
{
	//private double[] grades;
	private List<Double> grades;
	
	public Grades()
	{
		setGrades("");
	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public void setGrades(String gradeList)
	{
		int count = 0;
		//int size = 0;
		char[] c = gradeList.toCharArray();
		for(int i = 0; i < gradeList.length(); i++)
		{
			if(c[i] == ' ')
			{
				break;
			}
			else
			{
				count++;
			}
		}
		String list = gradeList.substring(count + 3);
		//size = Integer.parseInt(gradeList.substring(0, count));
		count = 0;
		int index = 0;
		String s = "";
		//grades = new double[size];
		grades = new ArrayList<Double>();
		//int gradesIndex = 0;
		char[] a = list.toCharArray();
		for(int i = 0; i< list.length(); i++)
		{
			if(a[i] != ' ')
			{
				index = i;
				while(i < a.length && a[i] != ' ')
				{
					count++;
					i++;
				}
				s = list.substring(index,i);
				grades.add(Double.parseDouble(s));
				//grades[gradesIndex] = Double.parseDouble(s);
				//gradesIndex++;
				
			}
		}


	}
	
	public void setGrade(int spot, double grade)
	{
		
		//grades[spot] = grade;
		grades.set(spot, grade);
		
	}
	
	public double getSum()
	{
		double sum=0.0;
		
		//for(int i = 0; i<grades.length; i++)
		for(int i = 0; i<grades.size(); i++)
		{
			//sum += grades[i];
			sum += grades.get(i);
		}
		
		
		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;
		
		/*for(int i = 0; i<grades.length;i++)
		{
			if(low > grades[i])
			{
				low = grades[i];
			}
		}*/
		for(int i = 0; i<grades.size();i++)
		{
			if(low > grades.get(i))
			{
				low = grades.get(i);
			}
		}




		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;
		
		/*for(int i = 0; i<grades.length;i++)
		{
			if(high < grades[i])
			{
				high = grades[i];
			}
		}*/
		for(int i = 0; i<grades.size();i++)
		{
			if(high < grades.get(i))
			{
				high = grades.get(i);
			}
		}




		return high;
	}
	
	public int getNumGrades()
	{
		return grades.size();
	}
	
	public String toString()
	{
		String output= "";
		
		/*for(int i =0; i<grades.length;i++)
		{
			output = output + grades[i] + " ";
		}*/
		for(int i =0; i<grades.size();i++)
		{
			output = output + grades.get(i) + " ";
		}





		return output;
	}	
}