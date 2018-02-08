package Unit5;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class CharacterAnalyzer
{
	private char theChar;
	private int charAsNum;
	public CharacterAnalyzer()
	{


	}

	public CharacterAnalyzer(char c)
	{
		theChar = c;
		charAsNum = theChar;

	}

	public void setChar(char c)
	{
		theChar = c;
		charAsNum = theChar;

	}
	public int getASCII( )
	{

		return charAsNum;
	}

	public char getChar()
	{
		return theChar;
	}

	public boolean isUpper( )
	{
		/*String charAsString = theChar + "";
		String up = charAsString.toUpperCase();
		if(charAsString == up)
			return true;
		else
			return false;*/
		if(charAsNum > 64 && charAsNum < 91)
			return true;
		else
			return false;
	}

	public boolean isLower( )
	{
		/*String charAsString = theChar + "";
		String lower = charAsString.toLowerCase();
		if(charAsString == lower)
			return true;
		else
			return false;*/
		if(charAsNum > 96 && charAsNum < 123)
			return true;
		else
			return false;
	}
	
	public boolean isNumber( )
	{
		if(charAsNum > 47 && charAsNum < 58)
			return true;
		else
			return false;
	}	



	public String toString()
	{
		boolean isNum = isNumber();
		boolean isLow = isLower();
		boolean isUp = isUpper();

		if(isLow == true)
			return ""+getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";
		else if(isUp == true)
			return ""+getChar() + " is an uppercase character. ASCII == " + getASCII() + "\n";
		else
			return ""+getChar() + " is a number. ASCII == " + getASCII() + "\n";
	}
}