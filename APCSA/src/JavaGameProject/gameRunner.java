package JavaGameProject;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
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
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}
	
	   
	

	public static void main( String args[] )
	{
		gameRunner run = new gameRunner();
		

		
	}
}