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
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


import Unit15.Block;

public class gameBoard extends Canvas implements KeyListener, Runnable
{
	private Player playerOne;
	private Player playerTwo;
	private final int bombOneCount = 1000;
	private boolean isExplodingOne = false;
	private boolean isExplodingTwo = false;
	private int explodeCount = 500;
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
	private String enemyDirection;
	private int score;
	private BufferedImage restart;
	private boolean first = true;
	//private ShieldPowerup pu = null;
	private Rectangle puR = null;
	private boolean shieldOn = false;
	/* uncomment once you are ready for this part
	 */
	//private Enemys enemysOne;
	//private Enemys enemysTwo;
	
	private int remainingOne;
	private int remainingTwo;
	private Bomb[] bombsLeftOne;
	private Bomb[] bombsLeftTwo;
	private Bomb bombOne = null;
	private Bomb enemyBomb = null;
	private Rectangle enemyBombR;
	private Rectangle bombOneR = null;
	private Bomb[] bombOnesLeftTwo;
	private Bomb bombTwo = null;
	private Rectangle bombTwoR = null;
	
	private boolean[] keys;
	private BufferedImage back;

	@SuppressWarnings("unchecked")
	public gameBoard()
	{
		//ArrayList enemysRowTwo = new ArrayList<Enemy>();
		for(int i = 0; i<7; i++)
		{
			//enemysRowTwo.add(new Enemy((80*i)+1, 90, 1));
		}
		//enemysTwo = new Enemys(enemysRowTwo);
		walls = new Walls();
		walls.append(new Rectangle(0,0,10,800));
		walls.append(new Rectangle(0,520,800,10));
		walls.append(new Rectangle(0,0,800,10));
		walls.append(new Rectangle(765,0,10,600));
		walls.append(new Rectangle(100,100,10,100));
		walls.append(new Rectangle(150,100,10,100));
		walls.append(new Rectangle(100,100,100,10));
		setBackground(Color.black);
		keys = new boolean[11];
		score = 0;
		enemyDirection  = "RIGHT";
		playerOne = new Player(125,150,1);
		playerOneR = new Rectangle(playerOne.getX()- 10,playerOne.getY()-10,30,30);
		playerTwo = new Player(225,250,1);
		playerTwoR = new Rectangle(playerTwo.getX()- 10,playerTwo.getY()-10,30,30);
		playerTwo.setColor(Color.BLUE);
		//enemyOne = new Enemy(0, 0, 1);
		//instantiate other stuff
		remainingOne = 100;
		remainingTwo = 100;
		Bomb bombOne = new Bomb(1000,1000);
		bombsLeftOne = new Bomb[100];
		for(int i = 0; i < bombsLeftOne.length; i++)
		{
			bombsLeftOne[i] = bombOne;
		}
		Bomb bombTwo = new Bomb(1000,1000);
		bombsLeftTwo = new Bomb[100];
		for(int i = 0; i < bombsLeftTwo.length; i++)
		{
			bombsLeftTwo[i] = bombTwo;
		}
		//enemysOne = new Enemys(7);
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
		
		
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50);
		graphToBack.drawString("Score: " + score, 25, 100);
		graphToBack.drawString("Press r to restart", 25, 150);
		graphToBack.setColor(playerOne.getColor());
		playerOne.draw(graphToBack);
		graphToBack.setColor(playerTwo.getColor());
		playerTwo.draw(graphToBack);
		walls.setColor(Color.GRAY);
		walls.draw(graphToBack);
		if(bombOne != null)
		{
			bombOne.draw(graphToBack);
		}
		
		
		//graphToBack.fillRect((int)playerOneR.getX(),(int)playerOneR.getY(),30,30);
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
		
		//Enemy AI
		
		int yn;
		/*for(Enemy item : enemysOne.getList())
		{
			if(item != null)
			{
				yn = r.nextInt(10);
				item.draw(graphToBack);
				if(item.getX() + 80 > 800)
				{
					enemyDirection = "LEFT";
				}
				else if(item.getX() < -20)
				{
					enemyDirection = "RIGHT";
				}
				item.move(enemyDirection);
				item.draw(graphToBack);
				if(enemyBomb == null && yn < 5)
				{
					enemyBomb = new Bomb(20,20,1);
					enemyBomb.setPos(((int)item.getX())+30, ((int)item.getY() + 80)+1);
					enemyBombR = new Rectangle(enemyBomb.getX(),enemyBomb.getY(),20,20);
					enemyBomb.draw(graphToBack);
					
				}
				
				if(enemyBomb != null && !enemyBombR.isEmpty())
				{
					enemyBomb.move("DOWN");
					enemyBombR.setLocation(enemyBomb.getX(), enemyBomb.getY());
					enemyBomb.draw(graphToBack);
					if(enemyBombR.intersects(playerOneR) && shieldOn == false)
					{
						enemyBombR = null;
						enemyBomb = null;
						score--;
					}
					
					
				}
			
			
				if(enemyBomb != null && enemyBombR.getMaxY() >= 600)
				{
					enemyBomb = null;
					enemyBombR = null;
				}
			}
			
		}
		for(Enemy item : enemysTwo.getList())
		{
			if(item != null)
			{
				yn = r.nextInt(10);
				item.draw(graphToBack);
				if(item.getX() + 80 > 800)
				{
					enemyDirection = "LEFT";
				}
				else if(item.getX() < -20)
				{
					enemyDirection = "RIGHT";
				}
				item.move(enemyDirection);
				item.draw(graphToBack);
				if(enemyBomb == null && yn < 5)
				{
					enemyBomb = new Bomb(20,20,1);
					enemyBomb.setPos(((int)item.getX())+30, ((int)item.getY() + 80)+1);
					enemyBombR = new Rectangle(enemyBomb.getX(),enemyBomb.getY(),20,20);
					enemyBomb.draw(graphToBack);
					
				}
				
				if(enemyBomb != null && !enemyBombR.isEmpty())
				{
					enemyBomb.move("DOWN");
					enemyBombR.setLocation(enemyBomb.getX(), enemyBomb.getY());
					enemyBomb.draw(graphToBack);
					if(enemyBombR.intersects(playerOneR) && shieldOn == false)
					{
						enemyBombR = null;
						enemyBomb = null;
						score--;
					}
					
					
				}
			
			
				if(enemyBomb != null && enemyBombR.getMaxY() >= 600)
				{
					enemyBomb = null;
					enemyBombR = null;
				}
			}
			
		}*/
		
		
		
		
		
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
			bombOne = bombsLeftOne[remainingOne-1];
			bombOne.setLocation(((int)playerOneR.getX()), ((int)playerOneR.getY()));
			bombOneR = new Rectangle(bombOne.getX(),bombOne.getY(),20,20);
			bombsLeftOne[remainingOne-1] = null;
			remainingOne--;
			bombOne.draw(graphToBack);
		}
		if(keys[6] == true)
		{
			playerTwo.move("LEFT");
			playerTwoR.setLocation(playerTwo.getX()- 10,playerTwo.getY()-10);
			if(keys[1] == false && keys[2] == false && keys[3] == false)
			{
				lastKeyTwo = 6;
			}
			
			playerTwo.draw(graphToBack);
		}
		if(keys[7] == true)
		{
			playerTwo.move("RIGHT");
			playerTwoR.setLocation(playerTwo.getX()- 10,playerTwo.getY()-10);
			if(keys[0] == false && keys[2] == false && keys[3] == false)
			{
				lastKeyTwo = 7;
			}
			playerTwo.draw(graphToBack);
		}
		if(keys[8] == true)
		{
			playerTwo.move("UP");
			playerTwoR.setLocation(playerTwo.getX()- 10,playerTwo.getY()-10);
			if(keys[0] == false && keys[1] == false && keys[3] == false)
			{
				lastKeyTwo = 8;
			}
			playerTwo.draw(graphToBack);
		}
		if(keys[9] == true)
		{
			playerTwo.move("DOWN");
			playerTwoR.setLocation(playerTwo.getX()- 10,playerTwo.getY()-10);
			if(keys[0] == false && keys[1] == false && keys[2] == false)
			{
				lastKeyTwo = 9;
			}
			playerTwo.draw(graphToBack);
		}
		if(keys[10] == true && bombTwo == null && remainingTwo > 0)
		{
			bombTwo = bombsLeftTwo[remainingTwo-1];
			bombTwo.setLocation(((int)playerTwoR.getX()), ((int)playerTwoR.getY()));
			bombTwoR = new Rectangle(bombTwo.getX(),bombTwo.getY(),20,20);
			bombsLeftTwo[remainingTwo-1] = null;
			remainingTwo--;
			bombTwo.draw(graphToBack);
		}
		
		
		
		if(bombOne != null && bombOneR.getMinY() <= 0)
		{
			bombOne = null;
			bombOneR = null;
		}
		if(bombOne != null)
		{
			bombOne.tick(1);
		}
		int explodeOne = 0;
		if(bombOne != null && bombOne.getCount() == 0)
		{
			isExplodingOne = true;
			bombOneR.setBounds(bombOne.getBoomX(), bombOne.getBoomY(), bombOne.getBoomWidth(), bombOne.getBoomHeight());
			graphToBack.setColor(Color.RED);
			graphToBack.fillRect(bombOne.getBoomX(), bombOne.getBoomY(), bombOne.getBoomWidth(), bombOne.getBoomHeight());
			explodeOne = bombOne.boom(bombOneR, playerOneR);
			if(explodeOne == 1)
			{
				retry(graphToBack);
			}
			/*explode = bombOne.boom(bombOneR, boxR);
			if(explode == 1)
			{
				//retry();
				playerOne = null;
			}*/
		}
		if(bombOne != null && isExplodingOne)
		{
			graphToBack.setColor(Color.RED);
			graphToBack.fillRect(bombOne.getBoomX(), bombOne.getBoomY(), bombOne.getBoomWidth(), bombOne.getBoomHeight());
			explodeCount --;
			explodeOne = bombOne.boom(bombOneR, playerOneR);
			if(explodeOne == 1)
			{
				retryOne(graphToBack);
				//playerOne = null;
			}
			explodeOne = bombOne.boom(bombOneR, playerTwoR);
			if(explodeOne == 1)
			{
				retryTwo(graphToBack);
				//playerOne = null;
			}
		}
		if(bombOne != null && explodeCount == 0)
		{
			bombOne = null;
			bombOneR = null;
			explodeCount = 500;
			isExplodingOne = false;
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
			explodeTwo = bombTwo.boom(bombTwoR, playerOneR);
			if(explodeTwo == 1)
			{
				retryOne(graphToBack);
			}
			explodeTwo = bombTwo.boom(bombTwoR, playerTwoR);
			if(explodeTwo == 1)
			{
				retryTwo(graphToBack);
			}
			/*explode = bombTwo.boom(bombTwoR, boxR);
			if(explode == 1)
			{
				//retry();
				playerOne = null;
			}*/
		}
		if(bombTwo != null && isExplodingTwo)
		{
			graphToBack.setColor(Color.RED);
			graphToBack.fillRect(bombTwo.getBoomX(), bombTwo.getBoomY(), bombTwo.getBoomWidth(), bombTwo.getBoomHeight());
			explodeCount --;
			bombTwoR = new Rectangle(bombTwo.getBoomX(), bombTwo.getBoomY(), bombTwo.getBoomWidth(), bombTwo.getBoomHeight());
			explodeTwo = bombTwo.boom(bombTwoR, playerTwoR);
			if(explodeTwo == 1)
			{
				retryTwo(graphToBack);
				//playerOne = null;
			}
			explodeTwo = bombTwo.boom(bombTwoR, playerOneR);
			if(explodeTwo == 1)
			{
				retryOne(graphToBack);
				//playerOne = null;
			}
		}
		if(bombTwo != null && explodeCount == 0)
		{
			bombTwo = null;
			bombTwoR = null;
			explodeCount = 500;
			isExplodingOne = false;
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
		
		
		
		/*Enemy o;
		Rectangle enemyTemp;
		for(int i = 0; i < enemysOne.getList().size();i++)
		{
			if(enemysOne.get(i) != null)
			{
				Enemy item = enemysOne.get(i);
				o = item;
				enemyTemp = new Rectangle(o.getX(),o.getY(),80,80);
				if(playerOneR.intersects(enemyTemp))
				{
					if(!playerOneR.isEmpty())
					{
						/*if(lastKeyOne == 0)
						{
							playerOneR.setLocation(playerOne.getX()+1, playerOne.getY());
							playerOne.setPos((int)playerOneR.getX(), (int)playerOneR.getY());
						}
						if(lastKeyOne == 1)
						{
							playerOneR.setLocation(playerOne.getX()-1, playerOne.getY());
							playerOne.setPos((int)playerOneR.getX(), (int)playerOneR.getY());
						}
						if(lastKeyOne == 2)
						{
							playerOneR.setLocation(playerOne.getX(), playerOne.getY()+1);
							playerOne.setPos((int)playerOneR.getX(), (int)playerOneR.getY());
						}
						if(lastKeyOne == 3)
						{
							playerOneR.setLocation(playerOne.getX(), playerOne.getY()-1);
							playerOne.setPos((int)playerOneR.getX(), (int)playerOneR.getY());
						}*//*
						retry(graphToBack);
					}
				}
				if(bombOne != null && !bombOneR.isEmpty())
				{
					bombOne.move("UP");
					bombOneR.setLocation(bombOne.getX(), bombOne.getY());
					bombOne.draw(graphToBack);
					if(bombOneR.intersects(playerOneR))
					{
						
					}
					if(bombOneR.intersects(enemyTemp))
					{
						score++;
						//enemyTemp.setLocation(1000,1000);
						o.setSpeed(0);
						//o.setPos((int)enemyTemp.getX(), (int)enemyTemp.getY());
						enemysOne.set(i, null);
						item = null;
						o = null;
						enemyTemp = null;
						bombOne = null;
						bombOneR = null;
					}
					
				}
			}
			
		}
		for(int i = 0; i < enemysTwo.getList().size();i++)
		{
			if(enemysTwo.get(i) != null)
			{
				Enemy item = enemysTwo.get(i);
				o = item;
				enemyTemp = new Rectangle(o.getX(),o.getY(),80,80);
				if(playerOneR.intersects(enemyTemp))
				{
					if(!playerOneR.isEmpty())
					{
						retry(graphToBack);
					}
				}
				if(bombOne != null && !bombOneR.isEmpty())
				{
					if(bombOneR.intersects(playerOneR))
					{
						
					}
					if(bombOneR.intersects(enemyTemp))
					{
						score++;
						//enemyTemp.setLocation(1000,1000);
						o.setSpeed(0);
						//o.setPos((int)enemyTemp.getX(), (int)enemyTemp.getY());
						enemysTwo.set(i, null);
						item = null;
						o = null;
						enemyTemp = null;
						bombOne = null;
						bombOneR = null;
					}
					
				}
			}
			
		}
		
		
		boolean win = true;
		boolean[] allDead = new boolean[enemysOne.getList().size()];
		for(int i = 0; i < allDead.length; i++)
		{
			allDead[i] = false;
		}
		for(int i = 0; i < enemysOne.getList().size(); i++)
		{
			if(enemysOne.get(i) == null)
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
		if(win)
		{
			graphToBack.setColor(Color.RED);
			graphToBack.drawString("YOU WIN", 380, 300);
		}*/
		twoDGraph.drawImage(back, null, 0, 0);
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
		//enemyDirection  = "RIGHT";
		playerOne = new Player(125,150,1);
		//enemyBomb = null;
		//enemyBombR = null;
		playerOneR = new Rectangle(playerOne.getX()-10,playerOne.getY()-10,30,30);
		playerTwo = new Player(225,250,1);
		playerTwoR = new Rectangle(playerTwo.getX()- 10,playerTwo.getY()-10,30,30);
		playerTwo.setColor(Color.BLUE);
		//enemyOne = new Enemy(0, 0, 1);
		//instantiate other stuff
		remainingOne = 100;
		lastKeyOne =-1;
		lastKeyTwo =-1;
		Bomb bombOne = new Bomb(1000,1000);
		bombsLeftOne = new Bomb[100];
		for(int i = 0; i < bombsLeftOne.length; i++)
		{
			bombsLeftOne[i] = bombOne;
		}
		Bomb bombTwo = new Bomb(1000,1000);
		bombOnesLeftTwo = new Bomb[100];
		for(int i = 0; i < bombOnesLeftTwo.length; i++)
		{
			bombOnesLeftTwo[i] = bombTwo;
		}
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
		//enemyDirection  = "RIGHT";
		playerOne = new Player(125,150,1);
		//enemyBomb = null;
		//enemyBombR = null;
		playerOneR = new Rectangle(playerOne.getX()-10,playerOne.getY()-10,30,30);
		//enemyOne = new Enemy(0, 0, 1);
		//instantiate other stuff
		remainingOne = 100;
		lastKeyOne =-1;
		Bomb bombOne = new Bomb(1000,1000);
		bombsLeftOne = new Bomb[100];
		for(int i = 0; i < bombsLeftOne.length; i++)
		{
			bombsLeftOne[i] = bombOne;
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
		//enemyDirection  = "RIGHT";
		playerTwo = new Player(225,250,1);
		playerTwoR = new Rectangle(playerTwo.getX()- 10,playerTwo.getY()-10,30,30);
		playerTwo.setColor(Color.BLUE);
		//enemyOne = new Enemy(0, 0, 1);
		//instantiate other stuff
		remainingTwo = 100;
		lastKeyTwo =-1;
		Bomb bombTwo = new Bomb(1000,1000);
		bombsLeftTwo = new Bomb[100];
		for(int i = 0; i < bombsLeftTwo.length; i++)
		{
			bombsLeftTwo[i] = bombTwo;
		}
		/*enemysOne = new Enemys(enemysOne.getList().size());
		ArrayList enemysRowTwo = new ArrayList<Enemys>();
		for(int i = 0; i<7; i++)
		{
			enemysRowTwo.add(new Enemy((80*i)+1, 90, 1));
		}
		enemysTwo = new Enemys(enemysRowTwo);*/
		
		
	}
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
   
}

