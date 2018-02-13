package Unit6;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

import java.io.IOException;
import java.util.Scanner;

public class Lab06f
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		//add test cases
		char[] cha = new char[1];
		char ch = '.';
		out.println("Sentence:\t");
		String sent = keyboard.nextLine().toString();
		while(ch == '.')
		{
			out.println("Char:\t");
			try
			{
				cha = keyboard.nextLine().toCharArray();
				ch = cha[0];
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				out.println("That is not a char!");
				
			}
		}
		
		//char ch = cha[0];
		LetterRemover test = new LetterRemover(sent, ch);
		String clean = test.removeLetters();
		out.println(test.toString() + "\n" + "Letter removed:\t" + clean);
		
		
		
		
		
											
	}
}