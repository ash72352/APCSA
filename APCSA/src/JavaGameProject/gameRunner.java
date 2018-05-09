package JavaGameProject;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class gameRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public gameRunner()
	{
		super("Game");
		setSize(WIDTH,HEIGHT);

		gameBoard theGame = new gameBoard();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		gameRunner run = new gameRunner();
	}
}