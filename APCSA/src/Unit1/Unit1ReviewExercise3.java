package Unit1;

import java.util.Random;

public class Unit1ReviewExercise3 {

	public static void main(String[] args) 
	{
		Random generator = new Random();
		
		int roll = generator.nextInt(6) + 1;
		
		System.out.println(roll);
		

	}

}
