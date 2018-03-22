package Unit14;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;

	public FancyWord()
	{
		mat = new char[1][1];
	}

   public FancyWord(String s)
	{
	   mat = new char[s.length()][s.length()];
	   char[] c = s.toCharArray();
	   mat[0] = c;
	   for(int i = 1; i <(s.length()-1);i++)
	   {
		   for(int a = 0; a < s.length(); a++)
		   {
			   if(s.length()%2 == 1)
			   {
				   if(a!=i && a!=s.length()-i-1)
				   {
					   mat[i][a] = ' ';
				   }
				   else if(i == s.length()-i-1)
				   {
					   mat[i][a] = c[i];
				   }
				   else
				   {
					   mat[i][a] = c[a];
				   }
			   }
			   else
			   {
				   if(a!=i && a!=s.length()-i-1)
				   {
					   mat[i][a] = ' ';
				   }
				   else
				   {
					   mat[i][a] = c[a];
				   }
			   }
		   }
	   }
	   mat[s.length()-1] = c;


	}

	public String toString()
	{
		String output="";
		for(int i = 0; i < mat[0].length;i++)
		{
			for(int a = 0; a < mat[0].length;a++)
				output = output + mat[i][a];
			output = output + "\n";
		}




		return output+"\n\n";
	}
}