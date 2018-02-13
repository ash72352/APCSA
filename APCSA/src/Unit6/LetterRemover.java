package Unit6;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class LetterRemover
{
 private String sentence;
 private char lookFor;

	public LetterRemover()
	{
		//call set
		setRemover("",'a');
	}

	//add in second constructor
	public LetterRemover(String s, char rem)
	{
		//call set
		setRemover(s,rem);
	}
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String charAsString = lookFor + "";
		String cleaned=sentence;
		cleaned = cleaned.replaceAll(charAsString, "");

		/*int counter = cleaned.indexOf(lookFor);
		for(int i = 1; i <= counter; i++)
		{
			
		}*/
		





		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor;
	}
}