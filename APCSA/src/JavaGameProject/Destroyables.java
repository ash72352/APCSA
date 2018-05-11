package JavaGameProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;


public class Destroyables 
{
	
	private ArrayList<destroyable> rects;
	private Color color;

	public Destroyables() 
	{
		rects = new ArrayList<destroyable>();
		color = Color.WHITE;
	}
	public Destroyables(ArrayList<destroyable> r) 
	{
		rects = r;
		color = Color.WHITE;
	}
	public Destroyables(Color c) 
	{
		rects = new ArrayList<destroyable>();
		color = c;
	}
	public Destroyables(ArrayList<destroyable> r, Color c) 
	{
		rects = r;
		color = c;
	}
	
	public ArrayList<destroyable> getList()
	{
		return rects;
	}
	public Color getColor()
	{
		return color;
	}
	public void setList(ArrayList<destroyable> r)
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
		for(destroyable a : rects)
		{
			if(a.intersects(r))
			{
				return true;
			}
		}
		return false;
	}
	public void append(destroyable r)
	{
		rects.add(r);
	}
	public void remove(int i)
	{
		rects.remove(i);
	}
	public void set(destroyable r, int i)
	{
		rects.set(i, r);
	}
	public destroyable get(int i)
	{
		return rects.get(i);
	}
	public void draw( Graphics window )
	{
		for(destroyable r : rects)
		{
			r.draw(window);
		}
		
	}
	public int length()
	{
		return rects.size();
	}

}
