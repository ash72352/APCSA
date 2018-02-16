package Unit6;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class LoopStats
{
	private int start, stop;

	public LoopStats()
	{


	}

	public LoopStats(int beg, int end)
	{
		start = beg;
		stop = end;

	}

	public void setNums(int beg, int end)
	{
		start = beg;
		stop = end;

	}

	public int getEvenCount()
	{
		int evenCount=0;
		int evenOrOdd = 0;
		if((start%2) == 0)
		{
			evenOrOdd = 0;

		}
		else if((start%2) == 1)
		{
			evenOrOdd = 1;
		}
		
		for(int i = start + evenOrOdd; i <= stop; i = i + 2)
		{
			evenCount = evenCount + 1;
		}




		return evenCount;
	}

	public int getOddCount()
	{
		int oddCount=0;
		int evenOrOdd = 0;
		if((start%2) == 0)
		{
			evenOrOdd = 1;

		}
		else if((start%2) == 1)
		{
			evenOrOdd = 0;
		}
		
		for(int i = start + evenOrOdd; i <= stop; i = i + 2)
		{
			oddCount = oddCount + 1;
		}





		return oddCount;
	}

	public int getTotal()
	{
		int total=0;
		for(int i = start; i<=stop; i++)
			total = total + i;



		return total;
	}
	
	public String toString()
	{
		return start + " " + stop;
	}
}