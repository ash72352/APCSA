package Unit13;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

import Unit12.Word;

import static java.lang.System.*;

class InsertionSort
{
	private ArrayList<String> list;

	public InsertionSort()
	{
		
		list = new ArrayList<String>();
		
		
	}

	//modfiers
	public void add(String  word)
	{
		int loc = 0;
		
		list.add(word);
		
		ArrayList<String> p = list;
				
		boolean isSorted = false;
		boolean yn = false;
		boolean goneThrough = false;
		boolean already = false;
		String w = "";
		int size = 0;
		char[] cOne;
		char[] cTwo;
		
		while(!isSorted)
		{
			yn = false;
			for(int i = 0; i < p.size()-1; i++)
			{
				goneThrough = false;
				
				cOne = p.get(i).toCharArray();
				cTwo = p.get(i+1).toCharArray();
				if(p.get(i).length() < p.get(i+1).length())
				{
					size = p.get(i).length();
				}
				else
				{
					size = p.get(i+1).length();
				}
				for(int a = 0; a < size; a++)
				{
					if(cTwo[a] < cOne[a] && cOne[0] > cTwo[0])
					{
						w = p.get(i);
						p.set(i, p.get(i+1));
						p.set(i+1, w);
						goneThrough = true;
						break;
					}
					
					
				}
				if(goneThrough)
				{
					
					yn = true;
					break;
				}
			}
			if(!yn)
			{
				isSorted = true;
			}
			already = false;
		}
		list = p;
		
		
	}


	public void remove(String word)
	{
		int index = -1;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).equals(word))
			{
				index = i;
				break;
			}
		}
		try
		{
			list.remove(index);
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		
		
		
	}
	

	public String toString()
	{
		
		String output = "";
		for(int i = 0; i < list.size(); i++)
		{
			output = output + list.get(i) + " ";
		}
		
		
		return output;
	}
}