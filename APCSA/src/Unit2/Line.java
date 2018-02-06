package Unit2;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Line
{
	private double xOne,yOne, xTwo, yTwo;
	private double slope;

	public Line(double x1, double y1, double x2, double y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;




	}

	public void setCoordinates(double x1, double y1, double x2, double y2)
	{

		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;



	}

	public void calculateSlope( )
	{
		double yTotal = (yTwo - yOne);
		double xTotal = (xTwo - xOne);
		slope = yTotal/xTotal;



	}

	public void print( )
	{
		System.out.println("A line with a startpoint at (" + xOne + "," + yOne + ") and an endpoint at (" + xTwo + "," + yTwo + ") has a slope of " + slope + ".");


	}
}