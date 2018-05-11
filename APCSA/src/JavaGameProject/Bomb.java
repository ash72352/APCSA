package JavaGameProject;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Bomb 
{
	private int x = 0;
	private int y = 0;
	private int width = 10;
	private int height = 10;
	private int boomX;
	private int boomY;
	private int boomWidth = 30;
	private int boomHeight = 30;
	private int thisCount = 500;
	private final Color color = Color.YELLOW;
	
	public Bomb(int xPos, int yPos)
	{
		y = yPos;
		x = xPos;
		boomX = x - 10;
		boomY = y - 10;
	}
	
	public int boom(Rectangle bombR, Object o)
	{
		if(thisCount == 0)
		{
			Rectangle r = (Rectangle) o;
			if(bombR.intersects(r))
			{
				return 1;
			}
			return 0;
		}
		return -1;
	}

	public int getX() 
	{
		return x;
		
	}
	public int getY() 
	{
		return y;
		
	}
	public void setX(int xPos) 
	{
		x = xPos;
		
	}
	public void setY(int yPos) 
	{
		y = yPos;
		
	}
	public void setLocation(int xPos, int yPos) 
	{
		x = xPos;
		y = yPos;
		boomX = x - 10;
		boomY = y - 10;
		
	}
	public void draw( Graphics window )
	{
		window.setColor(getColor());
		window.fillRect((int)getX(),(int)getY(),(int)width,(int)height);
		
	}

	public Color getColor() 
	{
		return color;
	}
	public void tick(int msecs)
	{
		if(thisCount >0)
			thisCount -= msecs;
		else
		{
			thisCount = 500;
		}
	}

	public int getCount() 
	{
		
		return thisCount;
	}
	public void setCount(int c)
	{
		thisCount = c;
	}
	public int getBoomX() 
	{
		return boomX;
		
	}
	public int getBoomY() 
	{
		return boomY;
		
	}
	public int getBoomWidth() 
	{
		return boomWidth;
		
	}
	public int getBoomHeight() 
	{
		return boomHeight;
		
	}
	public String toString()
	{
		return "X: " + getX() + ", Y: " + getY() + " ";
	}
	

}
