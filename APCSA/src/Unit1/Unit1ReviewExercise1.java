package Unit1;

/*Write a program that constructs a rectangle with an area of 42 and a rectangle with a perimeter of 42. 
 *Print the widths and heights of both rectangles.
 */

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class Unit1ReviewExercise1 extends JFrame
{
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	public Unit1ReviewExercise1()
	{
		super("Two Rectangles");

		setSize(WIDTH,HEIGHT);

		getContentPane().add(new rectangleStuff());

		setVisible(true);
	}

	public static void main(String[] args) 
	{
		Unit1ReviewExercise1 run = new Unit1ReviewExercise1();

	}

}
