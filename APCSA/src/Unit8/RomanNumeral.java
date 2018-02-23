package Unit8;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class RomanNumeral
{
	private int number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
		
		roman = str;
	}

	public RomanNumeral(int orig)
	{
		number = orig;
	}

	public void setNumber(int num)
	{
		
		number = num;

	}

	public void setRoman(String rom)
	{
		roman = rom;
	}

	public int getNumber()
	{
		number = 0;
		String[] split = new String[roman.length()];
		String lastOne = "", lastTwo = "";
		boolean add = true;
		int index = 0;
		
		for(int i = 0; i < roman.length(); i++)
		{
			split[index] = roman.charAt(i) + "";
			index++;
		}
		
		for(int a = 0; a < roman.length(); a++)
		{
			if((a+1) >= roman.length())
			{
				for(int c = 0; c < 13; c++)
				{
					if(LETTERS[c].equalsIgnoreCase(split[a]) && lastTwo != split[a])
					{
						number = number + NUMBERS[c];
					}
				}
				break;
			}
			else
			{
				for(int b = 0; b < 13; b++)
				{
					if((split[a] + split[a+1]).equalsIgnoreCase(LETTERS[b]))
					{
						number = number + NUMBERS[b];
						lastOne = split[a];
						lastTwo = split[a+1];
						add = false;
						
					}
					else if(split[a].equalsIgnoreCase(LETTERS[b]) && add == true && lastTwo != split[a])
					{
						number = number + NUMBERS[b];
						lastOne = split[a];
						
					}
			
				}
			}
			add = true;
			
		}
		
		return number;
	}

	public void toRoman()
	{

		roman = "";
		
		int temp = number;
		int num = 0;
		String rom = "";
		int slot = 0;
		int prev = 0;
		String last = "";
		boolean remove = true;
		
		int[] split = new int[13];
		for(int i = 0; i < 13; i++)
		{
			if((temp - NUMBERS[i]) >=0)
			{
				while(temp - NUMBERS[i] >= 0)
				{
					split[i]++;
					temp = temp - NUMBERS[i];
				}
				
			}
		}
		int counter = 0;
		for(int i = 0; i < 13; i++)
		{
			counter = split[i];
			while(counter > 0)
			{
				roman = roman + LETTERS[i];
				counter--;
			}
			
		}
		
		
	}
	public String toString()
	{
		toRoman();
		return roman + "\n";
	}
}