package JavaGameProject;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.io.IOException;

public class gameRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	public gameBoard theGame;
	public boolean running;

	public gameRunner()
	{
		super("Game");
		setSize(WIDTH,HEIGHT);

		theGame = new gameBoard();
		running = theGame.running;
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}
	public void newGame()
	   {

		   String yn = JOptionPane.showInputDialog("Would You Like To Play Again? (y/n)");

			if(yn.equalsIgnoreCase("y"))
			{
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Runtime runtime = Runtime.getRuntime();
			      
			      try {
			    	  runtime.exec("\\src\\JavaGameProject\\gameRunner.java").waitFor();
					runtime.exec("\\src\\JavaGameProject\\gameRunner.java");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				theGame = new gameBoard();
				theGame.run();
			}
			else
				System.exit(0);
	   }
	   
	public boolean isRunning()
	{
		running = theGame.running;
		return running;
	}

	public static void main( String args[] )
	{
		gameRunner run = new gameRunner();
		while(true)
		{
			if(!run.isRunning())
			{
				run.newGame();
			}
				
		}

		
	}
}