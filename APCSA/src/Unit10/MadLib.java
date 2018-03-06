package Unit10;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	private int nounsLength = 0;
	private int verbsLength = 0;
	private int adjLength = 0;
	private String fileName;
	public MadLib()
	{



	}

	public MadLib(String fName)
	{
		//load stuff
		fileName = fName;
		nouns = new ArrayList<String>();
		verbs = new ArrayList<String>();
		adjectives = new ArrayList<String>();
		loadNouns();
		loadVerbs();
		loadAdjectives();
		
		try
		{
			Scanner file = new Scanner(new File(fileName));
		
		
		
		
		
		
		
	
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		try
		{
		Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\Unit10\\nouns.dat"));
		while(file.hasNextLine())
		{
			nouns.add(file.nextLine());
			nounsLength++;
		}
		
		
		
		
		}
		catch(Exception e)
		{
			out.print(e);
		}	
		
	}
	
	public void loadVerbs()
	{
		try
		{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\Unit10\\verbs.dat"));
			while(file.hasNextLine())
			{
				verbs.add(file.nextLine());
				verbsLength++;
			}
	
	
	
	
		}
		catch(Exception e)
		{
			out.print(e);
		}
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\Unit10\\adjectives.dat"));
			while(file.hasNextLine())
			{
				adjectives.add(file.nextLine());
				adjLength++;
			}
	
	
	
	
	
		}
		catch(Exception e)
		{
			out.print(e);
		}
	}

	public String getRandomVerb()
	{
		Random r = new Random();
		int a = r.nextInt(nounsLength);
		return verbs.get(a);
	}
	
	public String getRandomNoun()
	{
		
		Random r = new Random();
		int a = r.nextInt(verbsLength);
		return nouns.get(a);
	}
	
	public String getRandomAdjective()
	{
		
		Random r = new Random();
		int a = r.nextInt(adjLength);
		return adjectives.get(a);
	}		

	public String toString()
	{
		Scanner k;
		String whole = "";
		try {
			k = new Scanner(new File(fileName));
			char[] line;
			while(k.hasNextLine())
			{
				line = k.nextLine().toCharArray();
				for(int i = 0; i<line.length; i++)
				{
					if(line[i] == '&')
					{
						whole = whole + getRandomAdjective();
					}
					else if(line[i] == '@')
					{
						whole = whole + getRandomVerb();
					}
					else if(line[i] == '#')
					{
						whole = whole + getRandomNoun();
					}
					else
					{
						whole = whole + line[i];
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	   return whole;
	}
}