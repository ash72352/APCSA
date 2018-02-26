package Unit7;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class TriangleThree
{
 private int size;
 private String letter;

	public TriangleThree()
	{
	}

	public TriangleThree(int count, String let)
	{
		letter = let;
		size = count;
	}

	public void setTriangle(String let, int sz )
	{
		letter = let;
		size = sz;
	}

	public String getTriangle()
	{
		String triangle = "";
		int length = size;
		int counter = 1;
		for(int a = 1; a <= size; a++)
		{
			for(int i = 1; i <= length - 1; i++)
				triangle = triangle + " ";
			for(int c = 1; c <= counter; c++)
				triangle = triangle + letter;
			triangle = triangle + "\n";
			counter++;
			length--;
		}
		
		return triangle;
	}

	public String toString()
	{
		String output=getTriangle();
		
		return output;
	}
}