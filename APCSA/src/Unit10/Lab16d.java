package Unit10;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab16d
{
	public static void main( String args[] )
	{
		//make a new MadLib
		MadLib test = new MadLib("src/Unit10/story.dat");
		
		out.println(test.toString());
	}
}