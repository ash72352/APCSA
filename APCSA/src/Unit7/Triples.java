package Unit7;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class Triples
{
 private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		number = num;

	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = number;
		int factor = 1;
		for(int i = 2; i <= c; i++)
		{
			if((a % i) == 0 && (b % i) == 0 && (c % i) == 0 && (i > factor))
				factor = i;
		}
		


		return factor;
	}

	public String toString()
	{
		String output="";
		
		int max = number;
		
		for(int a = 1; a <= max; a++)
		{
			for(int b = 1 + a; b <= max; b++)
			{
				for(int c = 1 + b; c <= max; c++)
				{
					if((a%2) == 0)
					{
						if((b%2) == 1)
						{
							if(greatestCommonFactor(a, b, c) == 1)
							{
								if(Math.pow( (Math.pow(a, 2) + Math.pow(b, 2)) , 0.5) == c && (c < max) && (a < max) && (b < max))
								{
									output = output + a + " " + b + " " + c + "\n";
								}
							}
						}
					}
					else if((a%2) == 1)
					{
						if((b%2) == 0)
						{
							if(greatestCommonFactor(a, b, c) == 1)
							{
								if(Math.pow( (Math.pow(a, 2) + Math.pow(b, 2)) , 0.5) == c && (c < max) && (a < max) && (b < max))
								{
									output = output + a + " " + b + " " + c + "\n";
								}
							}
						}
					}
					
				}
			}
		}





		return output;
	}
}