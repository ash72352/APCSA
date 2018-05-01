package Unit17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class ShieldPowerup extends Unit15.Block
{
	private static Random r = new Random();
	private int x;
	private int y;
	private Image image;
	public ShieldPowerup() 
	{
		this(r.nextInt(400) + 100, r.nextInt(400) + 100);
		
		
	}
	public ShieldPowerup(int xPos, int yPos) 
	{
		x = xPos;
		y = yPos;
		try
		{
			image = ImageIO.read(new File("src\\Unit17\\pu.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Powerup image fetch failed");
		}
	}
	public int getX()
	{
		return x;
	}
	public void setX(int xPos)
	{
		x = xPos;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int yPos)
	{
		y = yPos;
	}
	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),20,20,null);
	}
	public void draw( Graphics window , Color c)
	{
		window.setColor(c);
		window.fillRect(getX(),getY(),20,20);
	}
	public String toString()
	{
		return"X: " + x + "\nY: " + y;
	}

}
