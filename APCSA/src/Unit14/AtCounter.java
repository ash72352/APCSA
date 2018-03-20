package Unit14;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Arrays;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;
   private int[][] places;

	public AtCounter()
	{
		atCount=0;
		atMat = new char[][]{		{'@','-','@','-','-','@','-','@','@','@'},
									{'@','@','@','-','@','@','-','@','-','@'},
									{'-','-','-','-','-','-','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','-','@'},
									{'-','@','-','@','-','@','-','@','-','@'},
									{'@','@','@','@','@','@','-','@','@','@'},
									{'-','@','-','@','-','@','-','-','-','@'},
									{'-','@','@','@','-','@','-','-','-','-'},
									{'-','@','-','@','-','@','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','@','@'}};
		places = new int[10][10];
	}

	public int countAts(int r, int c)
	{
		out.println(r + " , " + c);
		//add in recursive code to count up the # of @s connected
		//start checking at spot [r,c]
		if(atMat[r][c] == '@' && places[r][c] != 1)
		{
			out.println("a");
			atCount++;
			places[r][c] = 1;
			if(r-1 >= 0)
			{
				countAts(r-1, c);
			}
			if(c-1 >= 0)
			{
				countAts(r, c-1);
			}
			if(r-1>=0 && c-1>=0)
				countAts(r-1,c-1);
			if(r-1>=0 && c+1 <10)
				countAts(r-1, c+1);
			if(r+1 <10 && c+1<10)
				countAts(r+1, c+1);
			if(r+1<10 && c-1>=0)
				countAts(r+1, c-1);
			if(c+1 <10)
				countAts(r, c+1);
			if(r+1<10)
				countAts(r+1, c);
			
			
		}

		return atCount;
	}

	public int getAtCount()
	{
		return atCount;
	}

	public String toString()
	{
		String output="";
		output+=getAtCount()+" @s connected.";
		
		for(int i = 0; i < places.length; i ++)
		{
			out.print(Arrays.toString(places[i]));
			out.print(Arrays.toString(atMat[i]));
			out.println();
		}
		return output;
	}
}