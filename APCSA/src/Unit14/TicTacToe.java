package Unit14;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;
	private int[][] places;
	public TicTacToe()
	{


	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		places = new int[3][3];
		char[] c = game.toCharArray();
		for(int i = 0; i < 3; i++)
		{
			for(int a = 0; a < 3; a++)
			{
				mat[i][a] = c[a+(3*i)];
			}
		}


	}

	public String getWinner()
	{
		for(int i = 0; i < 3;i++)
		{
			for(int a = 0; a < 3;a++)
			{
				if(mat[i][a] == 'X')
				{
					places[i][a] = 1;
				}
			}
			
		}
		for(int i = 0; i < 3;i++)
		{
			if((places[i][0] + places[i][1] + places[i][2]) == 3)
			{
				return "X wins horizontally!";
			}
			else if((places[i][0] + places[i][1] + places[i][2]) == 0)
			{
				return "O wins horizontally!";
			}
			else if((places[0][i] + places[1][i] + places[2][i]) == 3)
			{
				return "X wins vertically!";
			}
			else if((places[0][i] + places[1][i] + places[2][i]) == 0)
			{
				return "O wins vertically!";
			}
			else if((places[0][0] + places[1][1] + places[2][2]) == 3)
			{
				return "X wins diagonally!";
			}
			else if((places[0][0] + places[1][1] + places[2][2]) == 0)
			{
				return "O wins diagonally!";
			}
			else if((places[0][2] + places[1][1] + places[2][0]) == 3)
			{
				return "X wins diagonally!";
			}
			else if((places[0][2] + places[1][1] + places[2][0]) == 0)
			{
				return "O wins diagonally!";
			}
			
		}
		return "Cat's game - no winner!";
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
		output = output + getWinner();





		return output+"\n\n";
	}
}