package Unit12;



//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\Unit12\\" + "lab18e.dat"));

		int size = file.nextInt();
		file.nextLine();
		String complete = "";
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < size; i++)
		{
			list.add(file.nextLine());
		}
		
		ArrayList<String> b = list;
		ArrayList<Word> p = new ArrayList<Word>();
		Word t;
		for(int i = 0; i < list.size(); i++)
		{
			t = new Word(b.get(i));
			p.add(t);
		}
				
		Word w;
		boolean isSorted = false;
		boolean yn = false;
		boolean goneThrough = false;
				
		while(isSorted == false)
		{
			yn = true;
			for(int i = 0; i < list.size()-1; i++)
			{
				if(p.get(i).compareTo(p.get(i + 1)) == 1)
				{
					w = p.get(i+1);
					p.set(i + 1, p.get(i));
					p.set(i,w);
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
		isSorted = false;
		w = null;
		
		while(isSorted == false)
		{
			yn = true;
			for(int i = 0; i < list.size()-1; i++)
			{
				if(p.get(i).compareTo(p.get(i + 1)) == 0)
				{
					for(int a = 0; a < p.get(i).toString().length(); a++)
					{
						if(p.get(i).toString().charAt(0) > p.get(i+1).toString().charAt(0))
						{
							w = p.get(i+1);
							p.set(i + 1, p.get(i));
							p.set(i,w);
							goneThrough = true;
							if(goneThrough)
							{
								yn = false;
								break;
							}
						}
					}
				}
						
			}
			if(yn)
				isSorted=true;
		}
		isSorted = false;
		w = null;
		while(isSorted == false)
		{
			yn = true;
			for(int i = 0; i < list.size()-1; i++)
			{
				if(p.get(i).compareTo(p.get(i + 1)) == 0)
				{
					for(int a = 0; a < p.get(i).toString().length(); a++)
					{
						if(p.get(i).toString().charAt(0) == p.get(i+1).toString().charAt(0) && p.get(i).toString().charAt(1) > p.get(i+1).toString().charAt(1))
						{
							w = p.get(i+1);
							p.set(i + 1, p.get(i));
							p.set(i,w);
							goneThrough = true;
							if(goneThrough)
							{
								yn = false;
								break;
							}
						}
					}
				}
						
			}
			if(yn)
				isSorted=true;
		}
		for(int i = 0; i < list.size(); i++)
		{
					
			out.println(p.get(i));
					
		}










	}
}