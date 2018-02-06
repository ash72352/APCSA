package Unit2;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Cube
{
	private int side;
	private int surfaceArea;

	public void setSide(int s)
	{
		side = s;
	}

	public void calculateSurfaceArea( )
	{
		surfaceArea = 6*(side*side);
	}

	public void print( )
	{
		System.out.println("The surface area of a cube with side length " + side + " is " + surfaceArea + ".");
	}
}