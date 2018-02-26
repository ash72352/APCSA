package Unit8;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Lab14d
{
	public static void main( String args[] )
	{
		Grades gradeTest = new Grades(5, "100 90 85 72.5 95.6");
		System.out.println(gradeTest);
		System.out.println("average = " + String.format("%.2f",gradeTest.getAverage())+"\n\n");

		gradeTest.setGrades(3,"50.0 100.0 80.0");
		System.out.println(gradeTest);
		System.out.println("average = " + String.format("%.2f",gradeTest.getAverage())+"\n\n");

		gradeTest.setGrades(3, "93.4 -90.0 90.0");
		System.out.println(gradeTest);
		System.out.println("average = " + String.format("%.2f",gradeTest.getAverage())+"\n\n");

		gradeTest.setGrades(9, "1 2 3 4 5 6 7 8 9");
		System.out.println(gradeTest);
		System.out.println("average = " + String.format("%.2f",gradeTest.getAverage())+"\n\n");
		
		
	}
}