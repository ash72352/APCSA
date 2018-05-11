package JavaGameProject;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class destroyable implements Locatable
{
	private Rectangle thisR = new Rectangle();
	private int xPos;
	private int yPos;
	private int width = 40;
	private int height = 40;
	private boolean destroyed = false;

	private Color color;

	public destroyable()
	{
		xPos = 1000;
		yPos = 1400;
		width = 40;
		height = 40;
		thisR.setBounds(xPos-1, yPos-1, width+3, height+3);
		setColor(Color.ORANGE);

	}

	//add other destroyable constructors - x , y , width, height, color
	
	public destroyable(int x, int y)
	{
		xPos = x;
		yPos = y;
		width = 40;
		height = 40;
		thisR.setBounds(xPos-1, yPos-1, width+3, height+3);
		setColor(Color.ORANGE);
	}

 

 

	public void setColor(Color col)
	{
		color = col;
		
	}
	public void draw(Graphics window)
	{
		if(!destroyed)
		{
			window.setColor(getColor());
			window.fillRect(getX(), getY(), getWidth(), getHeight());
		}
		else
		{
			setPos(1000,1200);
		}
		
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
		if(!destroyed)
		{
			window.setColor(col);
			window.fillRect(xPos, yPos, width, height);
		}
	}
 
	public boolean equals(Object obj)
	{
		boolean yn = false;
		
		if((this.getWidth()==((destroyable) obj).getWidth()) && (this.getX()==((destroyable) obj).getX()) && (this.getY()==((destroyable) obj).getY()) &&(this.getHeight()==((destroyable) obj).getHeight()))
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
		thisR.setBounds(xPos-1, yPos-1, width+3, height+3);
		
	}

	@Override
	public void setY(int y) 
	{
		yPos = y;
		thisR.setBounds(xPos-1, yPos-1, width+3, height+3);
		
	}

	@Override
	public int getX() 
	{
		return xPos;
		
	}

	public int getY() 
	{
		return yPos;
	}   
	public boolean intersects(Object o)
	{
		Rectangle r = (Rectangle) o;
		if(!destroyed)
		{
			if(r.intersects(thisR))
			{
				
				return true;
			}
		}
		return false;
	}
	public void destroy(Rectangle r)
	{
		if(!destroyed)
		{
			if(intersects(r))
			{
				destroyed = true;
				thisR.setBounds(1000, 1200, width, height);
				thisR = null;
			}
		}
	}
	
	public String toString()
	{
		String output ="" + thisR;
		//output+= "xPos: " + xPos + "\tyPos: " + yPos + "\nWidth: " + width + "\tHeight: " + height + "\nColor: " + getColor();
		
		return output;
	}

	public Color getColor() {
		return color;
	}
}