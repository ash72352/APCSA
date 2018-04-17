package LabAssesmentPong;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	public Ball(int xS, int yS)
	{
		super(200, 200);
		xSpeed = xS;
		ySpeed = yS;
		
	}
	
	public Ball(int x, int y, int xS, int yS)
	{
		super(x, y);
		xSpeed = xS;
		ySpeed = yS;
	}
	
	public Ball(int x, int y, int w, int h, Color c, int xS, int yS)
	{
		super(x, y, w, h, c);
		xSpeed = xS;
		ySpeed = yS;
	}
	
	public Ball(int x, int y, int w, int h, Color c) 
	{
		super(x,y,w,h,c);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	
	
	
	
	
	
	
	
	   
   //add the set methods
   
	public Ball(int x, int y, int wid, int ht, int xSpd, int ySpd) 
	{
		super(x,y,wid,ht);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}

	public void setXSpeed(int xS)
   
	{
		xSpeed = xS;
	}
	
	public void setYSpeed(int yS)
	   
	{
		ySpeed = yS;
	}



	public void moveAndDraw(Graphics window)
	{
	   	//draw a white ball at old ball location
		super.draw(window, Color.white);
	
		setX(getX()+xSpeed);
		//setY
		setY(getY()+ySpeed);
		//draw the ball at its new location
		super.draw(window);
	}
	
	public void moveAndDraw(Graphics window, Color col)
	{
	   	//draw a white ball at old ball location
		super.draw(window, Color.white);
	
		setX(getX()+xSpeed);
		//setY
		setY(getY()+ySpeed);
		//draw the ball at its new location
		super.draw(window, col);
	}
   
	public boolean equals(Object obj)
	{
		boolean yn = false;
		if(super.equals(obj))
		{
			if(this.getXSpeed() == ((Ball) obj).getXSpeed() && this.getYSpeed() == ((Ball) obj).getYSpeed())
			{
				yn = true;
			}
		}
				


		return yn;
	}   

   //add the get methods
	public int getXSpeed() 
	{
		return xSpeed;
	}

	public int getYSpeed() 
	{
		return ySpeed;
	}
   //add a toString() method
	
	
	public String toString()
	{
		String output = super.toString();
		output+= "\nxSpeed: " + getXSpeed() + "\t ySpeed: " + getYSpeed() + "\n";
		return output;
		
	}
	
	
	public void speedUp(boolean yn) {
	}
	
	
	
	
	
}