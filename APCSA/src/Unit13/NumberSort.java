package Unit13;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -



public class NumberSort
{
	//instance variables and other methods not shown
	public NumberSort()
	{
	}
	
	
	private static int getNumDigits(int number)
	{
		
		char[] c = ("" + number).toCharArray();
		
		int count = c.length;
		
		return count;
	}
	
	public static int[] getSortedDigitArray(int number)
	{
		
		int numDig = getNumDigits(number);
		
		int[] sorted = new int[numDig];
		
		int num = number;
		
		for(int i = 0; i < sorted.length; i++)
		{
			sorted[numDig-1-i] = num%10;
			num = num/10;
		}
		
		int[] temp = sorted;
		
		boolean isSorted = false;
		boolean goneThrough = false;
		boolean yn = false;
		
		while(isSorted == false)
		{
			yn = true;
			for(int i = 0; i < temp.length-1; i++)
			{
				if(temp[i]> temp[i + 1])
				{
					num = temp[i+1];
					temp[i + 1] = temp[i];
					temp[i] = num;
					goneThrough = true;
					if(goneThrough)
					{
						yn = false;
						break;
					}
				}
				
			}
			if(yn)
				isSorted=true;
		}
		sorted = temp;
		
		
		
		
		return sorted;
	}
}