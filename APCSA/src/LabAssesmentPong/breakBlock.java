package LabAssesmentPong;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class breakBlock extends Block
{
 //instance variables
 private int speed;

 public breakBlock()
 {
		super(10,10);
    speed =5;
 }
 public breakBlock(int s)
	{
		super(200, 200);
		speed = s;
		
		
	}
	
	public breakBlock(int s, int x, int y)
	{
		super(x, y);
		speed = s;
		
	}
	
	public breakBlock(int x, int y, int w, int h, Color c, int s)
	{
		super(x, y, w, h, c);
		speed = s;
		
	}
	
	public breakBlock(int x, int y, int w, int h, Color c) 
	{
		super(x,y,w,h,c);
		speed = 5;
		
	}
	public breakBlock(int x, int y) 
	{
		super(x,y);
		speed = 3;
	}
	
	public breakBlock(int x, int y, int w, int h, int s) 
	{
		super(x,y,w,h);
		speed = s;
	}

 //add the other breakBlock constructors










 

	public void moveUpAndDraw(Graphics window)
  {
		//draw a white ball at old ball location
			super.draw(window, Color.WHITE);
		
			setY(getY()-speed);
			//setY
			
			//draw the ball at its new location
			super.draw(window);
		
  }

 public void moveDownAndDraw(Graphics window)
 {
	   super.draw(window, Color.WHITE);
	   setY(getY()+speed);
	   super.draw(window);

 }
 
 public boolean equals(Object obj)
	{
		boolean yn = false;
		if(super.equals(obj))
		{
			if(this.getSpeed() == ((breakBlock) obj).getSpeed())
			{
				yn = true;
			}
		}
				


		return yn;
	}   

 //add get methods
 
 public int getSpeed()
 {
	   return speed;
 }
 //add a toString() method
 
 public String toString()
	{
		String output = super.toString();
		output+= "\nSpeed: " + getSpeed() + "\n";
		return output;
		
	}
}