package Unit12;



//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;
		
	}



	public int compareTo(Word rhs)
	{

		if(this.toString().length() == rhs.toString().length())
			return 0;
		else if(this.toString().length() > rhs.toString().length())
			return 1;
		else
			return -1;

	}

	public String toString()
	{
		return word;
	}
}