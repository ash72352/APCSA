package Unit7;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class Lab10e
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		int response;
		String yn = "y";
		GuessingGame test = new GuessingGame();
		
		while(yn.equalsIgnoreCase("y"))
		{
			System.out.println("Guessing Game - how many numbers?");
			response = keyboard.nextInt();
			test.setNum(response);
			test.playGame();
			System.out.println("Do you want to play again? (y/n)");
			yn = keyboard.next();
		}
		System.out.println("Thanks for playing!");




	}
}