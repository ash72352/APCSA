package LabAssessmentOne;

public class tester 
{

	public static void main(String[] args) 
	{
		resturant luigi = new resturant("Luigi's Italian Food", 20);
		
		System.out.println(luigi);
		String groupOne =luigi.seat();
		System.out.println(groupOne);
		int tableNum = Integer.parseInt(""+groupOne.charAt(groupOne.length()-1));
		System.out.println(luigi.getTable(tableNum));
		plate p = new plate("David");
		luigi.getTable(tableNum).addPlate(p);
		System.out.println(luigi.getTable(tableNum).getplate(0));
		
		

	}

}
