package Unit1;



import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rectangleStuff extends JPanel
{
	public rectangleStuff()
	{
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	
	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("First rectangle: 7 by 6, area of 42.",40,40);

		rectangle shape = new rectangle(100, 100, 7, 6, Color.RED);
		
		shape.draw(window);
		
		window.drawString("Second rectangle: 7 by 6, area of 42.",420,40);

		rectangle shapeTwo = new rectangle(440, 100, 16, 5, Color.RED);
		
		shapeTwo.draw(window);
		

		
	}
}