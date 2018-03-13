package Unit11;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.List;


public class Class
{
	private String name;
	//private Student[] studentList;
	private List<Student> studentList;
	
	public Class()
	{
		name="";
		//studentList=new Student[0];
		studentList = new ArrayList<Student>();
	}
	
	public Class(String nam, int stuCount)
	{
		
		name = nam;
		//studentList = new Student[stuCount];
		studentList = new ArrayList<Student>();
		for(int i = 0; i<stuCount; i++)
		{
			studentList.add(null);
		}
	}
	
	public void addStudent(int stuNum, Student s)
	{
		
		//studentList[stuNum] = s;
		studentList.set(stuNum, s);
		
	}
	
	public String getClassName()
	{
	   return name;	
	}
	public Student getStudent(String n)
	{
		/*for(int i = 0; i < studentList.length; i++)
		{
			if(studentList[i].getName().equals(n))
			{
				return studentList[i];
			}
		}*/
		
		for(int i = 0; i < studentList.size(); i++)
		{
			if(studentList.get(i).getName().equals(n))
			{
				return studentList.get(i);
			}
		}
	   return null;	
	}
	public Student getStudent(int i)
	{
		//return studentList[i];
	   return studentList.get(i);	
	}
	
	public double getClassAverage()
	{
		double classAverage=0.0;
		
		/*for(int i = 0; i < studentList.length; i++)
		{
			classAverage += studentList[i].getAverage();
		}
		classAverage = classAverage/studentList.length;*/
		
		for(int i = 0; i < studentList.size(); i++)
		{
			classAverage += studentList.get(i).getAverage();
		}
		classAverage = classAverage/studentList.size();
		
		return classAverage;
	}
	
	public double getStudentAverage(int stuNum)
	{
		//return studentList[stuNum].getAverage();
		return studentList.get(stuNum).getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		/*for(int i = 0; i < studentList.length; i++)
		{
			if(studentList[i].getName().equals(stuName))
			{
				return studentList[i].getAverage();
			}
		}*/
		
		for(int i = 0; i < studentList.size(); i++)
		{
			if(studentList.get(i).getName().equals(stuName))
			{
				return studentList.get(i).getAverage();
			}
		}


		return 0.0;
	}
	
	public String getStudentName(int stuNum)
	{
		//return studentList[stuNum].getName();
		return studentList.get(stuNum).getName();
	}

	public String getStudentWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		String hName ="";
		
		/*for(int i = 0; i<studentList.length;i++)
		{
			if(high < studentList[i].getAverage())
			{
				high = studentList[i].getAverage();
				hName = studentList[i].getName();
			}
		}*/
		
		for(int i = 0; i<studentList.size();i++)
		{
			if(high < studentList.get(i).getAverage())
			{
				high = studentList.get(i).getAverage();
				hName = studentList.get(i).getName();
			}
		}









		return hName;
	}

	public String getStudentWithLowestAverage()
	{
		double low = Double.MAX_VALUE;
		String hName ="";		
		/*for(int i = 0; i<studentList.length;i++)
		{
			if(low > studentList[i].getAverage())
			{
				low = studentList[i].getAverage();
				hName = studentList[i].getName();
			}
		}*/
		
		for(int i = 0; i<studentList.size();i++)
		{
			if(low > studentList.get(i).getAverage())
			{
				low = studentList.get(i).getAverage();
				hName = studentList.get(i).getName();
			}
		}





		return hName;
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="";
		
		/*for(int i = 0; i < studentList.length; i++)
		{
			if(studentList[i].getAverage() <= failingGrade)
			{
				output = output + studentList[i].getName() + " ";
			}
		}*/
		
		for(int i = 0; i < studentList.size(); i++)
		{
			if(studentList.get(i).getAverage() <= failingGrade)
			{
				output = output + studentList.get(i).getName() + " ";
			}
		}




		return output;
	}
	
	public String toString()
	{
		String output=""+getClassName()+"\n";
		
		/*for(int i = 0; i < studentList.length; i++)
		{
			output = output + studentList[i] + "\t" + studentList[i].getAverage() + "\n";
		}*/
		
		for(int i = 0; i < studentList.size(); i++)
		{
			output = output + studentList.get(i) + "\t" + studentList.get(i).getAverage() + "\n";
		}



		return output;
	}  	
}