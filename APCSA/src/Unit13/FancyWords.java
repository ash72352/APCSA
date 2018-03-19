package Unit13;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		String temp = sentence;
		int numSpaces = 0;
		char[] c = sentence.toCharArray();
		for(int i = 0; i <sentence.length(); i++)
		{
			if(c[i] == ' ')
			{
				numSpaces++;
			}
		}
		numSpaces++;
		int index = 0;
		int currentSpace = 0;
		wordRay = new String[numSpaces];
		for(int i = 0; i <sentence.length(); i++)
		{
			if(c[i] == ' ')
			{
				wordRay[index] = temp.substring(currentSpace, i);
				currentSpace = i + 1;
				index++;
			}
		}
		wordRay[wordRay.length-1] = temp.substring(currentSpace);
		String[] back = new String[wordRay.length];
		String[] reverse = new String[wordRay.length];
		index = 0;
		for(int i = wordRay.length - 1; i >= 0; i--)
		{
			back[i] = wordRay[index];
			reverse[i] = "";
			index++;
		}
		wordRay = back;

		for(int i = wordRay.length - 1; i >= 0; i--)
		{
			c = wordRay[i].toCharArray();
			for(int a = wordRay[i].length()-1; a>=0; a--)
			{
				reverse[i] = reverse[i] + c[a];
			}
		}
		wordRay = reverse;
	}

	public void setWords(String sentence)
	{
		String temp = sentence;
		int numSpaces = 0;
		char[] c = sentence.toCharArray();
		for(int i = 0; i <sentence.length(); i++)
		{
			if(c[i] == ' ')
			{
				numSpaces++;
			}
		}
		numSpaces++;
		int index = 0;
		int currentSpace = 0;
		wordRay = new String[numSpaces];
		for(int i = 0; i <sentence.length(); i++)
		{
			if(c[i] == ' ')
			{
				wordRay[index] = temp.substring(currentSpace, i);
				currentSpace = i + 1;
				index++;
			}
		}
		wordRay[wordRay.length-1] = temp.substring(currentSpace);
		String[] back = new String[wordRay.length];
		String[] reverse = new String[wordRay.length];
		index = 0;
		for(int i = wordRay.length - 1; i >= 0; i--)
		{
			back[i] = wordRay[index];
			reverse[i] = "";
			index++;
		}
		wordRay = back;

		for(int i = wordRay.length - 1; i >= 0; i--)
		{
			c = wordRay[i].toCharArray();
			for(int a = wordRay[i].length()-1; a>=0; a--)
			{
				reverse[i] = reverse[i] + c[a];
			}
		}
		wordRay = reverse;
	}

	public String toString()
	{
		String output="";
		int max = Integer.MIN_VALUE;
		int[] lengths = new int[wordRay.length];
		int currentIndex = 0;
		for(int i = 0; i < wordRay.length; i++)
		{
			lengths[i] = wordRay[i].length();
			if(lengths[i] > max)
			{
				max = lengths[i];
			}
		}
		while(currentIndex < max)
		{
			for(int i = 0; i < wordRay.length; i++)
			{
				if(lengths[i] > currentIndex)
				{
					output = output + wordRay[i].charAt(currentIndex);
				}
				else
				{
					output = output + " ";
				}
			}
			currentIndex++;
			output = output + "\n";
		}





		return output+"\n\n";
	}
}