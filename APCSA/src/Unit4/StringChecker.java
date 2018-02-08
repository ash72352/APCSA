package Unit4;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StringChecker
{
	private String word;

	public StringChecker()
	{


	}

	public StringChecker(String s)
	{
		word = s;

	}

 public void setString(String s)
 {
 	word=s;
 }

	public boolean findLetter(char c)
	{
		int let = word.indexOf(c);
		if(let >= 0)
			return true;
		else
			return false;
	}

	public boolean findSubString(String s)
	{
		String seq = s;

		int len = seq.length();
		String check;
		int yn;
		yn = word.indexOf(seq.charAt(0));
		if(yn < 0)
			return false;
		check = word.substring(yn, yn+len);
		if(check.equals(seq))
			return true;
		else
			return false;
	}

	public String currentString()
	{
		return word;
	}
}