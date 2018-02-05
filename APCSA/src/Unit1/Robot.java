package Unit1;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
   public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString("Robot LAB ", 35, 35 );

      //call head method
      head(window);
      
      //call other methods
      upperBody(window);
      lowerBody(window);
   }

   public void head( Graphics window )
   {
	   window.setColor(Color.YELLOW);
	   window.fillOval( 210, 100, 300, 100 );
	      
	   window.setColor(Color.RED);
	   window.fillOval(225, 135, 25, 25);
	   window.fillOval(445, 135, 25, 25);
	      
	   window.drawArc(275, 130, 155, 65, 180, 180);


		//add more code here
				
   }

   public void upperBody( Graphics window )
   {
	   window.fillRect(210, 200, 300, 150);
	   window.setColor(Color.GRAY);
	   window.fillRect(510, 250, 100, 50);
	   window.fillRect(110, 250, 100, 50);
		//add more code here
   }

   public void lowerBody( Graphics window )
   {
	   window.setColor(Color.CYAN);
	   window.fillOval(210, 300, 300, 150);
		//add more code here

   }
}