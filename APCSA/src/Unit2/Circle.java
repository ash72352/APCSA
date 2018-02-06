package Unit2;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Circle
{
	private double radius;
	private double area;

	public void setRadius(double rad)
	{
		radius = rad;
	}

	public void calculateArea( )
	{
		area = radius * radius * 3.1415;
	}

	public void print( )
	{
		System.out.println("The area of a circle with a radius of " + radius + " is " + area + ".");
	}
}