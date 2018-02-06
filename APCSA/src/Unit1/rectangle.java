package Unit1;


import java.awt.Color;
import java.awt.Graphics;

public class rectangle
{
   
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

   public rectangle(int x, int y, int wid, int ht, Color col)
   {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
   }


   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRect(xPos, yPos, width, height);
      window.setColor(Color.MAGENTA);



   }



   public String toString()
   {
   	return xPos+" "+yPos+" "+width+" "+height+" "+color;
   }
}