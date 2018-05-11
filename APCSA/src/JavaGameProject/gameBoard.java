package JavaGameProject;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date - 
//Class - 
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

import Unit15.Block;

public class gameBoard extends Canvas implements KeyListener, Runnable
{
	public boolean running = true;
	private Player playerOne;
	private Player playerTwo;
	private final int bombOneCount = 1000;
	private boolean isExplodingOne = false;
	private boolean isExplodingTwo = false;
	private int explodeCountOne = 250;
	private int explodeCountTwo = 250;
	private int shieldCount = 0;
	private Rectangle playerTwoR;
	private Rectangle playerOneR;
	private Walls walls;
	private ArrayList borders;
	private ArrayList bordersR;
	//private Enemy enemyOne;
	//private Enemy enemyTwo;
	private int lastKeyOne = -1;
	private int lastKeyTwo = -1;
	private String bombDirectionOne  = "DOWN";
	private String bombDirectionTwo  = "DOWN";
	private int score;
	private BufferedImage restart;
	private boolean first = true;
	//private ShieldPowerup pu = null;
	private Rectangle puR = null;
	private boolean shieldOn = false;
	
	private int remainingOne;
	private int remainingTwo;
	private Bomb[] bombsLeftOne;
	private Bomb[] bombsLeftTwo;
	private Bomb bombOne = null;
	private Rectangle bombOneR = null;
	private Bomb[] bombOnesLeftTwo;
	private Bomb bombTwo = null;
	private Rectangle bombTwoR = null;
	private Destroyables barrels;
	private Rectangle[] livesOne = {new Rectangle(35, 50, 10, 10), new Rectangle(35, 70, 10, 10), new Rectangle(35, 90, 10, 10)};
	private Rectangle[] livesTwo = {new Rectangle(730, 470, 10, 10), new Rectangle(730, 450, 10, 10), new Rectangle(730, 430, 10, 10)};
	private int livesLeftOne = 3;
	private int livesLeftTwo = 3;
	private boolean wl = false;
	private boolean replay = true;
	private boolean[] keys;
	private BufferedImage back;

	@SuppressWarnings("unchecked")
	public gameBoard()
	{
		
		//borders:
		walls = new Walls();
		walls.append(new Rectangle(50,50,10,420));
		walls.append(new Rectangle(50,470,665,10));
		walls.append(new Rectangle(50,50,665,10));
		walls.append(new Rectangle(715,50,10,430));
		//inside walls:
		walls.append(new Rectangle(100,50,10,100));
		walls.append(new Rectangle(100,100,100,10));
		walls.append(new Rectangle(250,100,100,10));
		walls.append(new Rectangle(160,150,10,270));
		walls.append(new Rectangle(60,210,100,10));
		walls.append(new Rectangle(210,150,10,270));
		walls.append(new Rectangle(210,350,100,10));
		//destroyables:
		barrels = new Destroyables();
		barrels.append(new destroyable(60,120));
		
		setBackground(Color.black);
		keys = new boolean[12];
		score = 0;
		bombDirectionOne  = "DOWN";
		bombDirectionTwo  = "DOWN";
		playerOne = new Player(75,75,1);
		playerOneR = new Rectangle(playerOne.getX()- 10,playerOne.getY()-10,30,30);
		playerOne.setColor(Color.RED);
		playerTwo = new Player(685,435,1);
		playerTwoR = new Rectangle(playerTwo.getX()- 10,playerTwo.getY()-10,30,30);
		playerTwo.setColor(Color.BLUE);
		//enemyOne = new Enemy(0, 0, 1);
		//instantiate other stuff
		remainingOne = 100;
		remainingTwo = 100;
		final Bomb bomb = new Bomb(1000,1000);
		bombsLeftOne = new Bomb[100];
		for(int i = 0; i < bombsLeftOne.length; i++)
		{
			bombsLeftOne[i] = bomb;
		}
		bombsLeftTwo = new Bomb[100];
		for(int i = 0; i < bombsLeftTwo.length; i++)
		{
			bombsLeftTwo[i] = bomb;
		}
		
		
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		
			//set up the double buffering to make the game animation nice and smooth
			Graphics2D twoDGraph = (Graphics2D)window;
	
			//take a snap shop of the current screen and same it as an image
			//that is the exact same width and height as the current screen
			if(back==null)
			   back = (BufferedImage)(createImage(getWidth(),getHeight()));
			if(first = true)
			{
				restart = back;
				first = false;
			}
	
			//create a graphics reference to the back ground image
			//we will draw all changes on the background image
			Graphics graphToBack = back.createGraphics();
			//System.out.println("X: " + playerOne.getX() + "\nY: " + playerOne.getY());
		if(!wl)
		{
			graphToBack.setColor(Color.BLACK);
			graphToBack.fillRect(0,0,800,600);
			graphToBack.setColor(Color.BLUE);
			graphToBack.drawString("BombSeeker ", 25, 25);
			//graphToBack.drawString("Score: " + score, 25, 100);
			//graphToBack.drawString("Press r to restart", 25, 150);
			graphToBack.setColor(playerOne.getColor());
			playerOne.draw(graphToBack);
			for(Rectangle r : livesOne)
			{
				if(r!=null)
				{
					graphToBack.fillRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
				}
			}
			graphToBack.setColor(playerTwo.getColor());
			playerTwo.draw(graphToBack);
			for(Rectangle r : livesTwo)
			{
				if(r!=null)
				{
					graphToBack.fillRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
				}
			}
			walls.setColor(Color.GRAY);
			walls.draw(graphToBack);
			if(bombOne != null)
			{
				bombOne.draw(graphToBack);
			}
			if(bombTwo != null)
			{
				bombTwo.draw(graphToBack);
			}
			
			
			
			
			barrels.draw(graphToBack);
			//graphToBack.fillRect((int)playerOneR.getX(),(int)playerOneR.getY(),30,30);
			if(bombOne != null && bombOneR.getMinY() <= 0)
			{
				bombOne = null;
				bombOneR = null;
			}
			if(bombOne != null)
			{
				bombOne.tick(1);
			}
			boolean explodeOne;
			if(bombOne != null && bombOne.getCount() == 0)
			{
				isExplodingOne = true;
				bombOneR.setBounds(bombOne.getBoomX(), bombOne.getBoomY(), bombOne.getBoomWidth(), bombOne.getBoomHeight());
				graphToBack.setColor(Color.RED);
				graphToBack.fillRect(bombOne.getBoomX(), bombOne.getBoomY(), bombOne.getBoomWidth(), bombOne.getBoomHeight());
				explodeOne = bombOneR.intersects(playerOneR);
				if(explodeOne)
				{
					if(livesLeftOne != 0)
					{
						livesOne[livesLeftOne-1] = null;
						livesLeftOne--;
					}
					retryOne(graphToBack);
				}
				explodeOne = bombOneR.intersects(playerTwoR);
				if(explodeOne)
				{
					if(livesLeftTwo != 0)
					{
						livesTwo[livesLeftTwo-1] = null;
						livesLeftTwo--;
					}
					retryTwo(graphToBack);
				}
				for(int i = 0; i < barrels.length(); i++)
				{
					barrels.get(i).destroy(bombOneR);
				}
				
			}
			if(bombOneR != null && isExplodingOne)
			{
				graphToBack.setColor(Color.RED);
				graphToBack.fillRect(bombOne.getBoomX(), bombOne.getBoomY(), bombOne.getBoomWidth(), bombOne.getBoomHeight());
				
				explodeCountOne --;
				explodeOne =bombOneR.intersects(playerOneR);
				if(explodeOne)
				{
					if(livesLeftOne != 0)
					{
						livesOne[livesLeftOne-1] = null;
						livesLeftOne--;
					}
					retryOne(graphToBack);
					//playerOne = null;
				}
				explodeOne = bombOneR.intersects(playerTwoR);
				if(explodeOne)
				{
					if(livesLeftTwo != 0)
					{
						livesTwo[livesLeftTwo-1] = null;
						livesLeftTwo--;
					}
					retryTwo(graphToBack);
					//playerOne = null;
				}
				for(int i = 0; i < barrels.length(); i++)
				{
					barrels.get(i).destroy(bombOneR);
				}
			}
			if(bombOneR != null && explodeCountOne == 0)
			{
				bombOne = null;
				bombOneR = null;
				explodeCountOne = 250;
				isExplodingOne = false;
			}
			if(bombOneR != null && isExplodingOne && (bombOneR.intersects(playerOneR)))
			{
				if(livesLeftOne != 0)
				{
					livesOne[livesLeftOne-1] = null;
					livesLeftOne--;
				}
				retryOne(graphToBack);
			}
			if(bombOneR != null && isExplodingOne && (bombOneR.intersects(playerTwoR)))
			{
				if(livesLeftTwo != 0)
				{
					livesTwo[livesLeftTwo-1] = null;
					livesLeftTwo--;
				}
				retryTwo(graphToBack);
			}
			
			//bombTwo
			
			if(bombTwo != null && bombTwoR.getMinY() <= 0)
			{
				bombTwo = null;
				bombTwoR = null;
			}
			if(bombTwo != null)
			{
				bombTwo.tick(1);
			}
			
			
			int explodeTwo = 0;
			if(bombTwo != null && bombTwo.getCount() == 0)
			{
				isExplodingTwo = true;
				bombTwoR.setBounds(bombTwo.getBoomX(), bombTwo.getBoomY(), bombTwo.getBoomWidth(), bombTwo.getBoomHeight());
				graphToBack.setColor(Color.RED);
				graphToBack.fillRect(bombTwo.getBoomX(), bombTwo.getBoomY(), bombTwo.getBoomWidth(), bombTwo.getBoomHeight());
				explodeTwo = bombTwo.boom(bombTwoR, playerTwoR);
				if(explodeTwo == 1)
				{
					
					if(livesLeftTwo != 0)
					{
						livesTwo[livesLeftTwo-1] = null;
						livesLeftTwo--;
					}
					retryTwo(graphToBack);
					//playerOne = null;
				}
				explodeTwo = bombTwo.boom(bombTwoR, playerOneR);
				if(explodeTwo == 1)
				{
					if(livesLeftOne != 0)
					{
						livesOne[livesLeftOne-1] = null;
						livesLeftOne--;
					}
					
					
					retryOne(graphToBack);
					//playerOne = null;
				}
				for(int i = 0; i < barrels.length(); i++)
				{
					barrels.get(i).destroy(bombTwoR);
				}
			}
			if(bombTwo != null && isExplodingTwo)
			{
				graphToBack.setColor(Color.RED);
				graphToBack.fillRect(bombTwo.getBoomX(), bombTwo.getBoomY(), bombTwo.getBoomWidth(), bombTwo.getBoomHeight());
				explodeCountTwo--;
				bombTwoR = new Rectangle(bombTwo.getBoomX(), bombTwo.getBoomY(), bombTwo.getBoomWidth(), bombTwo.getBoomHeight());
				explodeTwo = bombTwo.boom(bombTwoR, playerTwoR);
				if(explodeTwo == 1)
				{
					
					if(livesLeftTwo != 0)
					{
						livesTwo[livesLeftTwo-1] = null;
						livesLeftTwo--;
					}
					retryTwo(graphToBack);
					//playerOne = null;
				}
				explodeTwo = bombTwo.boom(bombTwoR, playerOneR);
				if(explodeTwo == 1)
				{
					if(livesLeftOne != 0)
					{
						livesOne[livesLeftOne-1] = null;
						livesLeftOne--;
					}
					
					
					retryOne(graphToBack);
					//playerOne = null;
				}
				for(int i = 0; i < barrels.length(); i++)
				{
					barrels.get(i).destroy(bombTwoR);
				}
			}
			if(bombTwo != null && explodeCountTwo == 0)
			{
				bombTwo = null;
				bombTwoR = null;
				explodeCountTwo = 250;
				isExplodingTwo = false;
			}
			if(bombTwo != null && isExplodingTwo && (bombTwoR.intersects(playerOneR)))
			{
				if(livesLeftOne != 0)
				{
					livesOne[livesLeftOne-1] = null;
					livesLeftOne--;
				}
				retryOne(graphToBack);
			}
			if(bombTwo != null && isExplodingTwo &&(bombTwoR.intersects(playerTwoR)))
			{
				if(livesLeftTwo != 0)
				{
					livesTwo[livesLeftTwo-1] = null;
					livesLeftTwo--;
				}
				retryTwo(graphToBack);
			}
			
			if(walls.intersects(playerOneR))
			{
				if(lastKeyOne == 0)
				{
					playerOneR.setLocation((int)playerOneR.getX()+ 1,(int)playerOneR.getY());
					playerOne.setPos((int)playerOneR.getX()+10, (int)playerOneR.getY()+10);
					//lastKeyOne = -1;
					keys[0] = false;
				}
				if(lastKeyOne == 1)
				{
					playerOneR.setLocation((int)playerOneR.getX()- 1,(int)playerOneR.getY());
					playerOne.setPos((int)playerOneR.getX()+10, (int)playerOneR.getY()+10);
					//lastKeyOne = -1;
					keys[1] = false;
				}
				if(lastKeyOne == 2)
				{
					playerOneR.setLocation((int)playerOneR.getX(),(int)playerOneR.getY()+1);
					playerOne.setPos((int)playerOneR.getX()+10, (int)playerOneR.getY()+10);
					//lastKeyOne = -1;
					keys[2] = false;
				}
				if(lastKeyOne == 3)
				{
					playerOneR.setLocation((int)playerOneR.getX(),(int)playerOneR.getY()-1);
					playerOne.setPos((int)playerOneR.getX()+10, (int)playerOneR.getY()+10);
					//lastKeyOne = -1;
					keys[3] = false;
				}
			}
			if(barrels.intersects(playerOneR))
			{
				if(lastKeyOne == 0)
				{
					playerOneR.setLocation((int)playerOneR.getX()+ 1,(int)playerOneR.getY());
					playerOne.setPos((int)playerOneR.getX()+10, (int)playerOneR.getY()+10);
					//lastKeyOne = -1;
					keys[0] = false;
				}
				if(lastKeyOne == 1)
				{
					playerOneR.setLocation((int)playerOneR.getX()- 1,(int)playerOneR.getY());
					playerOne.setPos((int)playerOneR.getX()+10, (int)playerOneR.getY()+10);
					//lastKeyOne = -1;
					keys[1] = false;
				}
				if(lastKeyOne == 2)
				{
					playerOneR.setLocation((int)playerOneR.getX(),(int)playerOneR.getY()+1);
					playerOne.setPos((int)playerOneR.getX()+10, (int)playerOneR.getY()+10);
					//lastKeyOne = -1;
					keys[2] = false;
				}
				if(lastKeyOne == 3)
				{
					playerOneR.setLocation((int)playerOneR.getX(),(int)playerOneR.getY()-1);
					playerOne.setPos((int)playerOneR.getX()+10, (int)playerOneR.getY()+10);
					//lastKeyOne = -1;
					keys[3] = false;
				}
			}
			if(walls.intersects(playerTwoR))
			{
				if(lastKeyTwo == 6)
				{
					playerTwoR.setLocation((int)playerTwoR.getX()+ 1,(int)playerTwoR.getY());
					playerTwo.setPos((int)playerTwoR.getX()+10, (int)playerTwoR.getY()+10);
					//lastKeyOne = -1;
					keys[6] = false;
				}
				if(lastKeyTwo == 7)
				{
					playerTwoR.setLocation((int)playerTwoR.getX()- 1,(int)playerTwoR.getY());
					playerTwo.setPos((int)playerTwoR.getX()+10, (int)playerTwoR.getY()+10);
					//lastKeyOne = -1;
					keys[7] = false;
				}
				if(lastKeyTwo == 8)
				{
					playerTwoR.setLocation((int)playerTwoR.getX(),(int)playerTwoR.getY()+1);
					playerTwo.setPos((int)playerTwoR.getX()+10, (int)playerTwoR.getY()+10);
					//lastKeyOne = -1;
					keys[8] = false;
				}
				if(lastKeyTwo == 9)
				{
					playerTwoR.setLocation((int)playerTwoR.getX(),(int)playerTwoR.getY()-1);
					playerTwo.setPos((int)playerTwoR.getX()+10, (int)playerTwoR.getY()+10);
					//lastKeyOne = -1;
					keys[9] = false;
				}
			}
			
			if(barrels.intersects(playerTwoR))
			{
				if(lastKeyTwo == 6)
				{
					playerTwoR.setLocation((int)playerTwoR.getX()+ 1,(int)playerTwoR.getY());
					playerTwo.setPos((int)playerTwoR.getX()+10, (int)playerTwoR.getY()+10);
					//lastKeyOne = -1;
					keys[6] = false;
				}
				if(lastKeyTwo == 7)
				{
					playerTwoR.setLocation((int)playerTwoR.getX()- 1,(int)playerTwoR.getY());
					playerTwo.setPos((int)playerTwoR.getX()+10, (int)playerTwoR.getY()+10);
					//lastKeyOne = -1;
					keys[7] = false;
				}
				if(lastKeyTwo == 8)
				{
					playerTwoR.setLocation((int)playerTwoR.getX(),(int)playerTwoR.getY()+1);
					playerTwo.setPos((int)playerTwoR.getX()+10, (int)playerTwoR.getY()+10);
					//lastKeyOne = -1;
					keys[8] = false;
				}
				if(lastKeyTwo == 9)
				{
					playerTwoR.setLocation((int)playerTwoR.getX(),(int)playerTwoR.getY()-1);
					playerTwo.setPos((int)playerTwoR.getX()+10, (int)playerTwoR.getY()+10);
					//lastKeyOne = -1;
					keys[9] = false;
				}
			}
			
			
			
			Random r = new Random();
			
			//PowerupSpawn
			/*
			int pSpawn = r.nextInt(1000000);
			pSpawn = r.nextInt(1000);
			if(pu == null && pSpawn < 5)
			{
				pu = new ShieldPowerup();
				puR = new Rectangle(pu.getX(),pu.getY(),20,20);
				pu.draw(graphToBack);
			}
			if(pu!=null)
			{
				pu.draw(graphToBack);
			}
			*/
			
			
			
			
			
			
			
			
			if(keys[0] == true)
			{
				playerOne.move("LEFT");
				playerOneR.setLocation(playerOne.getX()- 10,playerOne.getY()-10);
				if(keys[1] == false && keys[2] == false && keys[3] == false)
				{
					lastKeyOne = 0;
				}
				
				playerOne.draw(graphToBack);
			}
			if(keys[1] == true)
			{
				playerOne.move("RIGHT");
				playerOneR.setLocation(playerOne.getX()- 10,playerOne.getY()-10);
				if(keys[0] == false && keys[2] == false && keys[3] == false)
				{
					lastKeyOne = 1;
				}
				playerOne.draw(graphToBack);
			}
			if(keys[2] == true)
			{
				playerOne.move("UP");
				playerOneR.setLocation(playerOne.getX()- 10,playerOne.getY()-10);
				if(keys[0] == false && keys[1] == false && keys[3] == false)
				{
					lastKeyOne = 2;
				}
				playerOne.draw(graphToBack);
			}
			if(keys[3] == true)
			{
				playerOne.move("DOWN");
				playerOneR.setLocation(playerOne.getX()- 10,playerOne.getY()-10);
				if(keys[0] == false && keys[1] == false && keys[2] == false)
				{
					lastKeyOne = 3;
				}
				playerOne.draw(graphToBack);
			}
			if(keys[5] == true)
			{
				retry(graphToBack);
			}
			if(keys[4] == true && bombOne == null && remainingOne > 0)
			{
				if(lastKeyOne == 0)
				{
					bombOne = new Bomb(((int)playerOne.getX()-10), ((int)playerOne.getY()));
				}
				if(lastKeyOne == 1)
				{
					bombOne = new Bomb(((int)playerOne.getX()+10), ((int)playerOne.getY()));
				}
				if(lastKeyOne == 2)
				{
					bombOne = new Bomb(((int)playerOne.getX()), ((int)playerOne.getY()-10));
				}
				if(lastKeyOne == 3)
				{
					bombOne = new Bomb(((int)playerOne.getX()), ((int)playerOne.getY()+10));
				}
				else
				{
					bombOne = new Bomb(((int)playerOne.getX()), ((int)playerOne.getY()));
				}
				
				bombsLeftOne[remainingOne-1] = null;
				bombOneR = new Rectangle(bombOne.getX(),bombOne.getY(),20,20);
				
				remainingOne--;
				keys[4] = false;
				bombOne.draw(graphToBack);
			}
			if(keys[6] == true)
			{
				playerTwo.move("LEFT");
				playerTwoR.setLocation(playerTwo.getX()- 10,playerTwo.getY()-10);
				if(keys[7] == false && keys[8] == false && keys[9] == false)
				{
					lastKeyTwo = 6;
				}
				
				playerTwo.draw(graphToBack);
			}
			if(keys[7] == true)
			{
				playerTwo.move("RIGHT");
				playerTwoR.setLocation(playerTwo.getX()- 10,playerTwo.getY()-10);
				if(keys[6] == false && keys[8] == false && keys[9] == false)
				{
					lastKeyTwo = 7;
				}
				playerTwo.draw(graphToBack);
			}
			if(keys[8] == true)
			{
				playerTwo.move("UP");
				playerTwoR.setLocation(playerTwo.getX()- 10,playerTwo.getY()-10);
				if(keys[6] == false && keys[7] == false && keys[9] == false)
				{
					lastKeyTwo = 8;
				}
				playerTwo.draw(graphToBack);
			}
			if(keys[9] == true)
			{
				playerTwo.move("DOWN");
				playerTwoR.setLocation(playerTwo.getX()- 10,playerTwo.getY()-10);
				if(keys[6] == false && keys[7] == false && keys[8] == false)
				{
					lastKeyTwo = 9;
				}
				playerTwo.draw(graphToBack);
			}
			if(keys[10] == true && bombTwo == null && remainingTwo > 0)
			{
				if(lastKeyTwo == 6)
				{
					bombTwo = new Bomb(((int)playerTwo.getX()-10), ((int)playerTwo.getY()));
				}
				else if(lastKeyTwo == 7)
				{
					bombTwo = new Bomb(((int)playerTwo.getX()+10), ((int)playerTwo.getY()));
				}
				else if(lastKeyTwo == 8)
				{
					bombTwo = new Bomb(((int)playerTwo.getX()), ((int)playerTwo.getY()-10));
				}
				else if(lastKeyTwo == 9)
				{
					bombTwo = new Bomb(((int)playerTwo.getX()), ((int)playerTwo.getY()+10));
				}
				else
				{
					bombTwo = new Bomb(((int)playerTwo.getX()), ((int)playerTwo.getY()));
				}
	
				bombsLeftTwo[remainingTwo-1] = null;
				bombTwoR = new Rectangle(bombTwo.getX(),bombTwo.getY(),20,20);
				
				remainingTwo--;
				keys[10] = false;
				bombTwo.draw(graphToBack);
			}
			if(keys[11] == true)
			{
				debug();
			}
			
			
			
			
	
			//add code to move stuff
			/*if(puR != null && playerOneR.intersects(puR))
			{
				playerOne.shieldMode();
				pu = null;
				puR = null;
				shieldCount = 1000;
				shieldOn = true;
				
			}
			if(shieldOn)
			{
				shieldCount--;
			}
			if(shieldCount <= 0)
			{
				shieldOn = false;
				playerOne.shieldModeOff();
			}*/
	
	
			//add in collision detection
			
			
			
			
			
			
			boolean win = true;
			boolean[] allDead = new boolean[livesOne.length];
			for(int i = 0; i < allDead.length; i++)
			{
				allDead[i] = false;
			}
			for(int i = 0; i < livesOne.length; i++)
			{
				if(livesOne[i] == null)
				{
					allDead[i] = true;
				}
			}
			for(int i = 0; i < allDead.length; i++)
			{
				if(allDead[i] == false)
				{
					win = false;
					break;
				}
			}
			if(livesLeftOne == 0)
			{
				graphToBack.setColor(playerTwo.getColor());
				graphToBack.drawString("TWO WINS", 380, 300);
				wl = true;
			}
			if(livesLeftTwo == 0)
			{
				graphToBack.setColor(playerOne.getColor());
				graphToBack.drawString("ONE WINS", 380, 300);
				wl = true;
			}
			twoDGraph.drawImage(back, null, 0, 0);
		}
		else
		{
			replay = false;
			
		}
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			keys[4] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[6] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			keys[7] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			keys[8] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			keys[9] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_E)
		{
			keys[10] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_R)
		{
			keys[5] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[11] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			keys[4] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			keys[6] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			keys[7] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			keys[8] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			keys[9] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_E)
		{
			keys[10] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_R)
		{
			keys[5] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[11] = false;
		}
		repaint();
	}
	

	public void keyTyped(KeyEvent e)
	{

	}
	
	public void retry(Graphics g)
	{
		back = restart;
		first = true;
		score = 0;
		bombDirectionOne  = "DOWN";
		bombDirectionTwo  = "DOWN";

		playerOne = new Player(75,75,1);
		playerOneR = new Rectangle(playerOne.getX()- 10,playerOne.getY()-10,30,30);
		playerOne.setColor(Color.RED);
		playerTwo = new Player(685,435,1);
		playerTwoR = new Rectangle(playerTwo.getX()- 10,playerTwo.getY()-10,30,30);
		playerTwo.setColor(Color.BLUE);
		//enemyOne = new Enemy(0, 0, 1);
		//instantiate other stuff
		remainingOne = 100;
		lastKeyOne =-1;
		lastKeyTwo =-1;
		Bomb bomb = new Bomb(1000,1000);
		bombsLeftOne = new Bomb[100];
		for(int i = 0; i < bombsLeftOne.length; i++)
		{
			bombsLeftOne[i] = bomb;
		}
		bombOnesLeftTwo = new Bomb[100];
		for(int i = 0; i < bombOnesLeftTwo.length; i++)
		{
			bombOnesLeftTwo[i] = bomb;
		}
		bombOne = null;
		bombOneR = null;
		bombTwo = null;
		bombTwoR = null;
		//destroyables:
		barrels = new Destroyables();
		barrels.append(new destroyable(60,100));
		livesLeftOne = 3;
		livesLeftTwo = 3;
		livesOne[0] = new Rectangle(35, 50, 10, 10);
		livesOne[1] = new Rectangle(35, 70, 10, 10);
		livesOne[2] = new Rectangle(35, 90, 10, 10);
		livesTwo[0] = new Rectangle(730, 470, 10, 10);
		livesTwo[1] = new Rectangle(730, 450, 10, 10);
		livesTwo[2] = new Rectangle(730, 430, 10, 10);

		/*enemysOne = new Enemys(enemysOne.getList().size());
		ArrayList enemysRowTwo = new ArrayList<Enemys>();
		for(int i = 0; i<7; i++)
		{
			enemysRowTwo.add(new Enemy((80*i)+1, 90, 1));
		}
		enemysTwo = new Enemys(enemysRowTwo);*/
		
		
	}
	public void retryOne(Graphics g)
	{
		back = restart;
		first = true;
		score = 0;
		bombDirectionOne  = "DOWN";
		bombDirectionTwo  = "DOWN";
		playerOne = new Player(75,75,1);
		playerOneR = new Rectangle(playerOne.getX()- 10,playerOne.getY()-10,30,30);
		playerOne.setColor(Color.RED);
		//enemyOne = new Enemy(0, 0, 1);
		//instantiate other stuff
		remainingOne = 100;
		lastKeyOne =-1;
		Bomb bomb = new Bomb(1000,1000);
		bombsLeftOne = new Bomb[100];
		for(int i = 0; i < bombsLeftOne.length; i++)
		{
			bombsLeftOne[i] = bomb;
		}
		/*enemysOne = new Enemys(enemysOne.getList().size());
		ArrayList enemysRowTwo = new ArrayList<Enemys>();
		for(int i = 0; i<7; i++)
		{
			enemysRowTwo.add(new Enemy((80*i)+1, 90, 1));
		}
		enemysTwo = new Enemys(enemysRowTwo);*/
		
		
	}
	public void retryTwo(Graphics g)
	{
		back = restart;
		first = true;
		score = 0;
		bombDirectionOne  = "DOWN";
		bombDirectionTwo  = "DOWN";
		playerTwo = new Player(685,435,1);
		playerTwoR = new Rectangle(playerTwo.getX()- 10,playerTwo.getY()-10,30,30);
		playerTwo.setColor(Color.BLUE);
		//enemyOne = new Enemy(0, 0, 1);
		//instantiate other stuff
		remainingTwo = 100;
		lastKeyTwo =-1;
		Bomb bomb = new Bomb(1000,1000);
		bombsLeftTwo = new Bomb[100];
		for(int i = 0; i < bombsLeftTwo.length; i++)
		{
			bombsLeftTwo[i] = bomb;
		}
		/*enemysOne = new Enemys(enemysOne.getList().size());
		ArrayList enemysRowTwo = new ArrayList<Enemys>();
		for(int i = 0; i<7; i++)
		{
			enemysRowTwo.add(new Enemy((80*i)+1, 90, 1));
		}
		enemysTwo = new Enemys(enemysRowTwo);*/
		
		
	}
	public void debug()
	{
		System.out.println("isExplodingOne: " + isExplodingOne);
		System.out.println("isExplodingTwo: " +  isExplodingTwo);
		System.out.println("explodeCountOne: " +  explodeCountOne);
		System.out.println("explodeCountTwo: " +  explodeCountTwo );
		System.out.println("playerTwoR: " +  playerTwoR);
		System.out.println("playerOneR: " +  playerOneR);

		System.out.println("lastKeyOne: " +  lastKeyOne);
		System.out.println("lastKeyTwo: " +  lastKeyTwo);

		System.out.println("Score: " +  score);
		
		System.out.println("remainingOne: " +  remainingOne);
		System.out.println("remainingTwo: " +  remainingTwo);
		System.out.println("bombsLeftOne: " +  Arrays.toString(bombsLeftOne));
		System.out.println("bombOne: " +  bombOne);
		System.out.print("bombOne Count: ");
		try{
			System.out.print(bombOne.getCount());
		}
		catch(Exception e)
		{
			System.out.print("null");
		}
		System.out.println("\nbombOneR: " +  bombOneR);
		System.out.println("bombsLeftTwo: " +  Arrays.toString(bombsLeftTwo));
		System.out.println("bombTwo: " +  bombTwo);
		System.out.print("bombTwo Count: ");
		try{
			System.out.print(bombTwo.getCount());
		}
		catch(Exception e)
		{
			System.out.print("null");
		}
		System.out.println("\nbombTwoR: " +  bombTwoR);
		keys[11] = false;
	}
   public void run()
   {
   	try
   	{
   		while(replay)
   		{
   		   Thread.currentThread().sleep(5);
   		   running = true;
            repaint();
         }
   		running = false;
      }catch(Exception e)
      {
      }
  	}
   public void exit()
   {
	   System.exit(0);
   }
   
   
}

