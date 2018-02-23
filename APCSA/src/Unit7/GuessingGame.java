package Unit7;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import java.util.Random;
import static java.lang.System.*;

public class GuessingGame
{
	private int upperBound;

	public GuessingGame()
	{


	}
	public GuessingGame(int stop)
	{
		upperBound = stop;

	}
	
	public void setNum(int stop)
	{
		upperBound = stop;
	}

	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		Random r = new Random();
		int input = 0, target, counter = 0;
		target = r.nextInt(upperBound) + 1;
		
		while(target != input)
		{
			System.out.println("Enter a number between 1 and " + upperBound);
			input = keyboard.nextInt();
			counter++;
		}
		System.out.println("It took " + counter + " guesses to guess " + target + ".");
		System.out.println("You guessed wrong " + (1 -(1.0 / counter)) * 100 + "% of the time");
		
		



	}

	public String toString()
	{
		String output="";
		return output;
	}
}