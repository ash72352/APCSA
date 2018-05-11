package JavaGameProject;

import java.awt.Color;
import java.awt.Graphics;

public class Platform extends Unit15.Block
{
	public Platform() 
	{
		super();
	}
	
	public Platform(int x, int y)
	{
		super(x,y);
	}
	
	
	public Platform(int x, int y, int w, int h, Color c)
	{
		super(x,y,w,h,c);
	}
	
	public Platform(int x, int y, int w, int h) 
	{
		super(x,y,w,h);
	}
	public void setColor(Color c)
	{
		super.setColor(c);
	}
	
	public void draw( Graphics window )
	{
		window.setColor(super.getColor());
    	window.fillRect(getX(),getY(),super.getWidth(),super.getHeight());
	}

}
