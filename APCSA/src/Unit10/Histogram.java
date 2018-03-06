package Unit10;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;

	public Histogram()
	{




	}

	public Histogram(char[] values, String fName)
	{
		
		fileName = fName;
		letters = new ArrayList<Character>();
		count = new ArrayList<Integer>();
		for(int i = 0; i <values.length; i++)
		{
			letters.add(values[i]);
			count.add(0);
			
		}
		
		
		
		
		
		
		out.println("search letters = "+letters);
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		Scanner k = new Scanner(new File(System.getProperty("user.dir") + "\\src\\Unit10\\" + fileName));
		char[] c;
		int temp = 0;
		while(k.hasNextLine())
		{
			c = k.nextLine().toCharArray();
			temp = 0;
			for(int i = 0; i < c.length; i++)
			{
				for(int a = 0; a < letters.size(); a++)
				{
					if(c[i] == letters.get(a))
					{
						temp = count.get(a);
						count.set(a, temp+1);
					}
				}
			}
		}






	}

	public char mostFrequent()
	{
		char m = ' ';
		int temp = 0;
		for(int i = 0; i < letters.size(); i++)
		{
			if(temp <count.get(i))
			{
				m = letters.get(i);
				temp = count.get(i);
			}
			
			
		}
		return m;
	}

	public char leastFrequent()
	{
		char m = ' ';
		int temp = count.get(0);
		for(int i = 0; i < letters.size(); i++)
		{
			if(temp >count.get(i))
			{
				m = letters.get(i);
				temp = count.get(i);
			}
			
			
		}

		return m;
	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}