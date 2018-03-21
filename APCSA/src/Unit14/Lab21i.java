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

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		Scanner k = new Scanner(new File(System.getProperty("user.dir") + "\\src\\Unit14\\" + "lab21i.dat"));
		int size = k.nextInt();
		k.nextLine();
		String line = k.nextLine();
		Maze test = new Maze(size, line);
		out.print(test);
	}
}