package Unit13;



//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class Lab15d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner k = new Scanner(new File(System.getProperty("user.dir") + "\\src\\Unit13\\" + "lab15d.dat"));
		int runs = k.nextInt();
		k.nextLine();
		FancyWords test;
		int currentRun = 0;
		do
		{
			test = new FancyWords(k.nextLine());
			out.println(test);
			currentRun++;
		}while(currentRun<runs);


		
		
		
	}
}