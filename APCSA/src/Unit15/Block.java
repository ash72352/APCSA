package Unit15;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	

	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		xPos = 100;
		yPos = 150;
		width = 10;
		height = 10;
		color = Color.BLACK;

	}

	//add other Block constructors - x , y , width, height, color
	
	public Block(int x, int y)
	{
		xPos = x;
		yPos = y;
		width = 10;
		height = 10;
		color = Color.BLACK;
	}
	
	
	public Block(int x, int y, int w, int h, Color c)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = c;
	}
	
	public Block(int x, int y, int w, int h) 
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = Color.BLACK;
	}
	
	
   //add the other set methods
   

   

	public void setColor(Color col)
	{
		color = col;
		
	}

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public int getHeight() 
   {
	return height;
   }

   public int getWidth() 
   {
	return width;
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(xPos, yPos, width, height);

   }
   
	public boolean equals(Object obj)
	{
		boolean yn = false;
		
		if((this.getWidth()==((Block) obj).getWidth()) && (this.getX()==((Block) obj).getX()) && (this.getY()==((Block) obj).getY()) &&(this.getHeight()==((Block) obj).getHeight()))
			yn = true;
		else
			yn = false;
		
		return yn;
	}

	@Override
	public void setPos(int x, int y) 
	{
		xPos = x;
		yPos = y;
		
	}

	@Override
	public void setX(int x) 
	{
		xPos = x;
		
	}

	@Override
	public void setY(int y) 
	{
		yPos = y;
		
	}

	@Override
	public int getX() 
	{
		return xPos;
	}

	@Override
	public int getY() 
	{
		return yPos;
	}   

   //add the other get methods
    

   //add a toString() method  - x , y , width, height, color
	
	public String toString()
	{
		String output ="";
		output+= "xPos: " + xPos + "\tyPos: " + yPos + "\nWidth: " + width + "\tHeight: " + height + "\nColor: " + color;
		return output;
	}
}