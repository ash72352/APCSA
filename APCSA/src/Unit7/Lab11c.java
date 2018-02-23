package Unit7;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;


public class Lab11c
{
	public static void main( String args[] ) 
	{
		Scanner k = new Scanner(System.in);
		TriangleThree t = new TriangleThree();
		String let;
		int count;
		
		
		out.println("Letter: ");
		let = k.nextLine();
		
		out.println("Size: ");
		count = k.nextInt();
		t.setTriangle(let, count);
		
		String tri = t.getTriangle();
		
		out.println("\n" + tri);
		
		
		
		
		
		
	}
}