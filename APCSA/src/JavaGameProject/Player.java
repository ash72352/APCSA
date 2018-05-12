package JavaGameProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Player extends MovingThing
{
	private int speed;
	private String direction;
	private Image image;
	private Color color;

	public Player()
	{
		this(0,0,0);
	}

	public Player(int x, int y)
	{
		this(x,y,0);
	}

	public Player(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		color = Color.RED;
		try
		{
			image = ImageIO.read(new File("src\\Unit17\\ship.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Player image fetch failed");
		}
	}


	public void setSpeed(int s)
	{
	   //add more code
		speed = s;
	}
	public Color getColor()
	{
		return color;
	}
	public void setColor(Color c)
	{
		color = c;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.setColor(getColor());
		window.fillRect(getX(), getY(), 10, 10);
		//window.drawImage(image,getX(),getY(),80,80,null);
	}
	public void draw( Graphics window , Color c)
	{
		window.setColor(c);
		window.fillRect(getX(),getY(),80,80);
	}
	public void move(String dir)
	{
		direction = dir;
		super.move(direction);
	}
	
	public String getDir()
	{
		return direction;
	}
   

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
