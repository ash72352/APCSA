package Unit15;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Block
{

	public Wall()
	{
		super(200,200);
	}

	//add the other Wall constructors
	
	
	public Wall(int x, int y)
	{
		super(x, y);
	}
	
	
	public Wall(int x, int y, int w, int h, Color c) 
	{
		super(x,y,w,h,c);
	}
	public void draw(Graphics window)
	{
		super.draw(window);
	}

}
