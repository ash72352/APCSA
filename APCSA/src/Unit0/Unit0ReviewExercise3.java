/*(Population projection) The U.S. Census Bureau projects population based on the following assumptions:
 * * One birth every 7 seconds
 * * One death every 13 seconds
 * * One new immigrant every 45 seconds
 * Write a program to display the population for each of the next five years.
 * Assume the current population is 312,032,486 and one year has 365 days, 1 year has 31536000 seconds.
 * Hint: In Java, if two integers perform division, the result is an integer.
 * The fractional part is truncated.
 * For example, 5/ 4 is 1 (not 1.25) and 10/ 4 is 2 (not 2.5).
 * To get an accurate result with the fractional part, one of the values involved in the division must be a number with a decimal point.
 * For example, 5.0/ 4 is 1.25 and 10/ 4.0 is 2.5.*/


package Unit0;

public class Unit0ReviewExercise3
{

	public static void main(String[] args) 
	{
		int birthCheck = 7;
		int deathCheck = 13;
		int immigrateCheck = 45;
		int displayCheck = 31536000;
		double population = 312032486;
		int year = 1;
		for(int i = 0; i<(31536000 * 6); i++)
		{
			if(i == birthCheck)
			{
				population = birth(population);
				birthCheck = birthCheck + 7;
			}
			if(i == deathCheck)
			{
				population = death(population);
				deathCheck = deathCheck + 13;
			}
			if(i == immigrateCheck)
			{
				population = immigrant(population);
				immigrateCheck = immigrateCheck + 45;
				
			}
			if(i == displayCheck)
			{
				System.out.println("Year " + year + " population: " + population);
				displayCheck = displayCheck + 31536000;
				year++;
			}
		}
	

	}
	
	public static double birth(double a)
	{
		a++;
		return a;
	}
	
	public static double death(double a)
	{
		a--;
		return a;
	}
	
	public static double immigrant(double a)
	{
		a++;
		return a;
	}
}