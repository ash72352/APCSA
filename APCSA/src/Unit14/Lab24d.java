package Unit14;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner (new File(System.getProperty("user.dir") + "\\src\\Unit14\\" + "lab24d.dat"));
		
		int size = file.nextInt();
		file.nextLine();
		TicTacToe test;
		for(int i = 0; i<size; i++)
		{
			String word = file.next();
			test = new TicTacToe(word);
			out.println(test);



	   }
		
		
		
		
		
		
	}
}



