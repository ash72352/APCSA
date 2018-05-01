package Unit17;

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

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private int shieldCount = 0;
	private Rectangle shipR;
	private Alien alienOne;
	private Alien alienTwo;
	private int lastKey = 0;
	private String alienDirection;
	private int score;
	private BufferedImage restart;
	private boolean first = true;
	private ShieldPowerup pu = null;
	private Rectangle puR = null;
	private boolean shieldOn = false;
	/* uncomment once you are ready for this part
	 */
	private Aliens aliensOne;
	private Aliens aliensTwo;
	
	private Ammo[] shotsLeft;
	private int remaining;
	private Ammo temp = null;
	private Ammo alienAmmo = null;
	private Rectangle alienAmmoR;
	private Rectangle tempR = null;

	private boolean[] keys;
	private BufferedImage back;

	@SuppressWarnings("unchecked")
	public OuterSpace()
	{
		ArrayList aliensRowTwo = new ArrayList<Alien>();
		for(int i = 0; i<7; i++)
		{
			aliensRowTwo.add(new Alien((80*i)+1, 90, 1));
		}
		aliensTwo = new Aliens(aliensRowTwo);
		setBackground(Color.black);
		keys = new boolean[6];
		score = 0;
		alienDirection  = "RIGHT";
		ship = new Ship(320,450,1);
		shipR = new Rectangle(ship.getX(),ship.getY(),80,80);
		alienOne = new Alien(0, 0, 1);
		//instantiate other stuff
		
		Ammo temp = new Ammo(1000,1000,1);
		shotsLeft = new Ammo[100];
		remaining = 100;
		for(int i = 0; i < shotsLeft.length; i++)
		{
			shotsLeft[i] = temp;
		}
		aliensOne = new Aliens(7);
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
		ship.draw(graphToBack);
		Random r = new Random();
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
		int yn;
		for(Alien item : aliensOne.getList())
		{
			if(item != null)
			{
				yn = r.nextInt(10);
				item.draw(graphToBack);
				if(item.getX() + 80 > 800)
				{
					alienDirection = "LEFT";
				}
				else if(item.getX() < -20)
				{
					alienDirection = "RIGHT";
				}
				item.move(alienDirection);
				item.draw(graphToBack);
				if(alienAmmo == null && yn < 5)
				{
					alienAmmo = new Ammo(20,20,1);
					alienAmmo.setPos(((int)item.getX())+30, ((int)item.getY() + 80)+1);
					alienAmmoR = new Rectangle(alienAmmo.getX(),alienAmmo.getY(),20,20);
					alienAmmo.draw(graphToBack);
					
				}
				
				if(alienAmmo != null && !alienAmmoR.isEmpty())
				{
					alienAmmo.move("DOWN");
					alienAmmoR.setLocation(alienAmmo.getX(), alienAmmo.getY());
					alienAmmo.draw(graphToBack);
					if(alienAmmoR.intersects(shipR) && shieldOn == false)
					{
						alienAmmoR = null;
						alienAmmo = null;
						score--;
					}
					
					
				}
			
			
				if(alienAmmo != null && alienAmmoR.getMaxY() >= 600)
				{
					alienAmmo = null;
					alienAmmoR = null;
				}
			}
			
		}
		for(Alien item : aliensTwo.getList())
		{
			if(item != null)
			{
				yn = r.nextInt(10);
				item.draw(graphToBack);
				if(item.getX() + 80 > 800)
				{
					alienDirection = "LEFT";
				}
				else if(item.getX() < -20)
				{
					alienDirection = "RIGHT";
				}
				item.move(alienDirection);
				item.draw(graphToBack);
				if(alienAmmo == null && yn < 5)
				{
					alienAmmo = new Ammo(20,20,1);
					alienAmmo.setPos(((int)item.getX())+30, ((int)item.getY() + 80)+1);
					alienAmmoR = new Rectangle(alienAmmo.getX(),alienAmmo.getY(),20,20);
					alienAmmo.draw(graphToBack);
					
				}
				
				if(alienAmmo != null && !alienAmmoR.isEmpty())
				{
					alienAmmo.move("DOWN");
					alienAmmoR.setLocation(alienAmmo.getX(), alienAmmo.getY());
					alienAmmo.draw(graphToBack);
					if(alienAmmoR.intersects(shipR) && shieldOn == false)
					{
						alienAmmoR = null;
						alienAmmo = null;
						score--;
					}
					
					
				}
			
			
				if(alienAmmo != null && alienAmmoR.getMaxY() >= 600)
				{
					alienAmmo = null;
					alienAmmoR = null;
				}
			}
			
		}
		
		
		
		
		
		if(keys[0] == true && ship.getX() > -20)
		{
			ship.move("LEFT");
			shipR.setLocation(ship.getX(), ship.getY());
			lastKey = 0;
			ship.draw(graphToBack);
		}
		if(keys[1] == true && (ship.getX() + 80) < 800)
		{
			ship.move("RIGHT");
			shipR.setLocation(ship.getX(), ship.getY());
			lastKey = 1;
			ship.draw(graphToBack);
		}
		if(keys[2] == true && ship.getY() > -15)
		{
			ship.move("UP");
			shipR.setLocation(ship.getX(), ship.getY());
			lastKey = 2;
			ship.draw(graphToBack);
		}
		if(keys[3] == true && (ship.getY() + 80) < 530)
		{
			ship.move("DOWN");
			shipR.setLocation(ship.getX(), ship.getY());
			lastKey = 3;
			ship.draw(graphToBack);
		}
		if(keys[5] == true)
		{
			retry(graphToBack);
		}
		

		//add code to move stuff
		if(puR != null && shipR.intersects(puR))
		{
			ship.shieldMode();
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
			ship.shieldModeOff();
		}


		//add in collision detection
		Alien o;
		Rectangle alienTemp;
		for(int i = 0; i < aliensOne.getList().size();i++)
		{
			if(aliensOne.get(i) != null)
			{
				Alien item = aliensOne.get(i);
				o = item;
				alienTemp = new Rectangle(o.getX(),o.getY(),80,80);
				if(shipR.intersects(alienTemp))
				{
					if(!shipR.isEmpty())
					{
						/*if(lastKey == 0)
						{
							shipR.setLocation(ship.getX()+1, ship.getY());
							ship.setPos((int)shipR.getX(), (int)shipR.getY());
						}
						if(lastKey == 1)
						{
							shipR.setLocation(ship.getX()-1, ship.getY());
							ship.setPos((int)shipR.getX(), (int)shipR.getY());
						}
						if(lastKey == 2)
						{
							shipR.setLocation(ship.getX(), ship.getY()+1);
							ship.setPos((int)shipR.getX(), (int)shipR.getY());
						}
						if(lastKey == 3)
						{
							shipR.setLocation(ship.getX(), ship.getY()-1);
							ship.setPos((int)shipR.getX(), (int)shipR.getY());
						}*/
						retry(graphToBack);
					}
				}
				if(temp != null && !tempR.isEmpty())
				{
					temp.move("UP");
					tempR.setLocation(temp.getX(), temp.getY());
					temp.draw(graphToBack);
					if(tempR.intersects(shipR))
					{
						
					}
					if(tempR.intersects(alienTemp))
					{
						score++;
						//alienTemp.setLocation(1000,1000);
						o.setSpeed(0);
						//o.setPos((int)alienTemp.getX(), (int)alienTemp.getY());
						aliensOne.set(i, null);
						item = null;
						o = null;
						alienTemp = null;
						temp = null;
						tempR = null;
					}
					
				}
			}
			
		}
		for(int i = 0; i < aliensTwo.getList().size();i++)
		{
			if(aliensTwo.get(i) != null)
			{
				Alien item = aliensTwo.get(i);
				o = item;
				alienTemp = new Rectangle(o.getX(),o.getY(),80,80);
				if(shipR.intersects(alienTemp))
				{
					if(!shipR.isEmpty())
					{
						retry(graphToBack);
					}
				}
				if(temp != null && !tempR.isEmpty())
				{
					if(tempR.intersects(shipR))
					{
						
					}
					if(tempR.intersects(alienTemp))
					{
						score++;
						//alienTemp.setLocation(1000,1000);
						o.setSpeed(0);
						//o.setPos((int)alienTemp.getX(), (int)alienTemp.getY());
						aliensTwo.set(i, null);
						item = null;
						o = null;
						alienTemp = null;
						temp = null;
						tempR = null;
					}
					
				}
			}
			
		}
		
		if(keys[4] == true && temp == null && remaining > 0)
		{
			temp = shotsLeft[remaining-1];
			temp.setPos(((int)shipR.getX())+30, ((int)shipR.getY())+1);
			tempR = new Rectangle(temp.getX(),temp.getY(),20,20);
			shotsLeft[remaining-1] = null;
			remaining--;
			temp.draw(graphToBack);
		}
		
		if(temp != null && tempR.getMinY() <= 0)
		{
			temp = null;
			tempR = null;
		}
		boolean win = true;
		boolean[] allDead = new boolean[aliensOne.getList().size()];
		for(int i = 0; i < allDead.length; i++)
		{
			allDead[i] = false;
		}
		for(int i = 0; i < aliensOne.getList().size(); i++)
		{
			if(aliensOne.get(i) == null)
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
		}
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
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
		alienDirection  = "RIGHT";
		ship = new Ship(320,450,1);
		alienAmmo = null;
		alienAmmoR = null;
		shipR = new Rectangle(ship.getX(),ship.getY(),80,80);
		alienOne = new Alien(0, 0, 1);
		//instantiate other stuff
		Ammo temp = new Ammo(1000,1000,1);
		shotsLeft = new Ammo[100];
		remaining = 100;
		for(int i = 0; i < shotsLeft.length; i++)
		{
			shotsLeft[i] = temp;
		}
		aliensOne = new Aliens(aliensOne.getList().size());
		ArrayList aliensRowTwo = new ArrayList<Aliens>();
		for(int i = 0; i<7; i++)
		{
			aliensRowTwo.add(new Alien((80*i)+1, 90, 1));
		}
		aliensTwo = new Aliens(aliensRowTwo);
		
		
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

