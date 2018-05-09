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

public class Walls 
{
	
	private ArrayList<Rectangle> rects;
	private Color color;

	public Walls() 
	{
		rects = new ArrayList<Rectangle>();
		color = Color.WHITE;
	}
	public Walls(ArrayList<Rectangle> r) 
	{
		rects = r;
		color = Color.WHITE;
	}
	public Walls(Color c) 
	{
		rects = new ArrayList<Rectangle>();
		color = c;
	}
	public Walls(ArrayList<Rectangle> r, Color c) 
	{
		rects = r;
		color = c;
	}
	
	public ArrayList<Rectangle> getList()
	{
		return rects;
	}
	public Color getColor()
	{
		return color;
	}
	public void setList(ArrayList<Rectangle> r)
	{
		rects = r;
	}
	public void setColor(Color c)
	{
		color = c;
	}
	public boolean intersects(Object o)
	{
		Rectangle r = (Rectangle) o;
		for(Rectangle a : rects)
		{
			if(r.intersects(a))
			{
				return true;
			}
		}
		return false;
	}
	public void append(Rectangle r)
	{
		rects.add(r);
	}
	public void remove(int i)
	{
		rects.remove(i);
	}
	public void set(Rectangle r, int i)
	{
		rects.set(i, r);
	}
	public void draw( Graphics window )
	{
		for(Rectangle r : rects)
		{
			window.setColor(getColor());
	    	window.fillRect((int)r.getX(),(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());
		}
		
	}

}
