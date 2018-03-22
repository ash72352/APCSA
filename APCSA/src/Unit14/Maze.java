package Unit14;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;
   private int[][]places;

	public Maze()
	{
		maze = new int[2][2]; 
		places= new int[2][2];

	}

	public Maze(int size, String line)
	{
		maze = new int[size][size];
		places= new int[size][size];
		char[] c = line.toCharArray();
		int index = 0;
		int spaces = 0;
		int mazeArr = 0;
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] == ' ')
				spaces++;
			
		}
		char[] spaceless = new char[c.length-spaces];
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] != ' ')
			{
				spaceless[index] = c[i];
				index++;
			}
		}
		index = 0;
		for(int i = 0; i<size; i++)
		{
			for(int a = 0; a < size; a++)
			{
				maze[mazeArr][a] = Integer.parseInt(spaceless[(size*index)+a] + "");
			}
			index++;
			if(mazeArr < size-1)
				mazeArr++;
		}
		
			
	}
		
		
		
	

	public boolean hasExitPath(int r, int c)
	{
		int size = maze[0].length;
		boolean yn = false;
		if(maze[r][c] == 1 && places[r][c] != 1)
		{
			
			places[r][c] = 1;
			if(r-1 >= 0)
			{
				if(hasExitPath(r-1, c))
					yn = true;
			}
			if(c-1 >= 0)
			{
				if(hasExitPath(r, c-1))
					yn = true;
			}
			
			if(r-1>=0 && c+1 <size)
			{
				if(hasExitPath(r-1, c+1))
					yn = true;
			}
			
			if(r+1<size && c-1>=0)
			{
				if(hasExitPath(r+1, c-1))
					yn = true;
			}
			if(c+1 <size)
			{
				if(hasExitPath(r, c+1))
					yn = true;
			}
			if(r+1<size)
			{
				if(hasExitPath(r+1, c))
					yn = true;
			}
			
			
		}
		else
			yn = false;
		return yn;
	}

	public String toString()
	{
		String output="";
		
		int index = 0;
		for(int i = 0; i < maze[0].length * maze[0].length; i++)
		{
			output = output + maze[index][i%5];
			if((i+1)%maze[0].length == 0)
			{
				index++;
				output = output +"\n";
			}
		}
		
		if(hasExitPath(0,0)==true)
		{
			output = output + "\nexit found\n";
		}
		else
			output = output + "\nexit not found\n\n";



		return output;
	}
}