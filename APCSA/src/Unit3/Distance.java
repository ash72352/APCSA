package Unit3;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance, xTotalSquared, yTotalSquared;

	public Distance()
	{



	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;


	}

	public void calcDistance()
	{
		xTotalSquared = Math.pow((xTwo-xOne), 2);
		yTotalSquared = Math.pow((yTwo-yOne), 2);

		distance = Math.pow((xTotalSquared + yTotalSquared), 0.5);


	}

	public void print( )
	{
		if((xTotalSquared + yTotalSquared) < 0)
		{
			System.out.println("ERROR :: Unreal Root.");
		}
		else if((xTotalSquared + yTotalSquared) >= 0)
		{
			System.out.print("Distance == ");
			System.out.printf("%.2f\n", distance);
			

		}


	}
}