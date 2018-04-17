package LabAssesmentPong;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.Random;


public class Breakout extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int score;
	private Block[][] blocks;
	private Block breakBlock;
	private String[][] coords;
	private boolean[][] isHit;
	


	public Breakout()
	{
		//set up all variables related to the game
		System.out.println("David Datta \nPeriod 4\nComp Number 07");
		ball = new Ball();
		ball.setXSpeed(1);
		ball.setYSpeed(1);
		//ball = new BlinkyBall();
		//ball = new SpeedUpBall();
		
		leftPaddle = new Paddle(30, 210, 30, 100, Color.RED);
		
		breakBlock = new Block(710, 10, 15, 75, Color.RED);
		
		blocks = new Block[5][4];
		coords = new String[5][4];
		isHit = new boolean[5][4];
		int x = 625;
		int y = 30;
		String temp = "";
		for(int i = 0; i <5; i++)
		{
			for(int a = 0; a < 4; a++)
			{
				x =(610 +(a*50) + 15);
				y = ((i*95) +30);
				blocks[i][a] = new Block(x, y, 15, 75, Color.RED);
				temp = x + "," +y;
				coords[i][a] = temp;
				temp = "";
				isHit[i][a] = false;
			}
		}
		
		keys = new boolean[4];
		
		score = 0;
		
		
		
		
		
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window)
   {
	   paint(window);
	   
   }

   public void paint(Graphics window)
   {
	   
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		//if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		
		graphToBack.drawString("\t    Breakout   \tScore: " + score, 320, 400);

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		for(int i = 0; i <5; i++)
		{
			for(int a = 0; a < 4; a++)
			{
				if(blocks[i][a] != null)
					blocks[i][a].draw(graphToBack);
			}
		}
		



		//see if ball hits left wall or right wall
		if(!(ball.getX()>=20))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			reset(graphToBack);
			
			
		}
		Random r = new Random();
		//see if the ball hits the top or bottom wall 
		if(didCollideTop(ball) || didCollideBottom(ball))
		{
			ball.setYSpeed((int)(-ball.getYSpeed()*(r.nextDouble()+1)));
		}

		

		//see if the ball hits the left paddle
		if(didCollideLeft(ball))
		{
			//ball.setYSpeed((-ball.getYSpeed()));
			ball.setXSpeed((int)(-ball.getXSpeed()*(r.nextDouble()+1)));
		}
		
		
		
		
		if(didCollideRight(ball))
		{
			
			ball.setXSpeed((int)(-ball.getXSpeed()*(r.nextDouble()+1)));
		}
		
		if(didCollideBrick(ball))
		{
			score++;
			for(int i = 0; i <5; i++)
			{
				for(int a = 0; a < 4; a++)
				{
					if(isHit[i][a])
					{
						ball.setXSpeed((int)(-ball.getXSpeed()*(r.nextDouble()+1)));
						blocks[i][a] = null;
					}
					
				}
			}
			graphToBack.drawString("\t    Breakout   \tScore: " + score, 320, 400);
			
			
		}
		
		
		double num = r.nextDouble();
		if(num<0.5)
			num = 0.5;
		if(ball.getXSpeed() > 3)
			ball.setXSpeed((int)(ball.getXSpeed()*(num)));
			
		


		//see if the paddles need to be moved
		
		
		if(keys[0] == true && leftPaddle.getY()>=0)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(window);
		}
		if(keys[1] == true  && leftPaddle.getY()<=425)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(window);

		}
		
		
		if(leftPaddle.getY()<=0)
		{
			
			leftPaddle.setY(leftPaddle.getY()+1);
		}
		if(leftPaddle.getY()>=425)
		{
			
			leftPaddle.setY(425);

		}
		
		
		
		







		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	private void reset(Graphics g) 
	{
		ball = new Ball();
		ball.setXSpeed(1);
		ball.setYSpeed(1);
		//ball = new BlinkyBall();
		//ball = new SpeedUpBall();
		
		leftPaddle = new Paddle(30, 210, 30, 100, Color.RED);
		
		breakBlock = new Block(710, 10, 15, 75, Color.RED);
		
		blocks = new Block[5][4];
		coords = new String[5][4];
		isHit = new boolean[5][4];
		int x = 625;
		int y = 30;
		String temp = "";
		for(int i = 0; i <5; i++)
		{
			for(int a = 0; a < 4; a++)
			{
				x =(610 +(a*50) + 15);
				y = ((i*95) +30);
				blocks[i][a] = new Block(x, y, 15, 75, Color.RED);
				temp = x + "," +y;
				coords[i][a] = temp;
				temp = "";
				isHit[i][a] = false;
			}
		}
		
		keys = new boolean[4];
		
		score = 0;
		
		
		
		
		
		
		new Thread(this).start();
		addKeyListener(this);
		
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
   
	   public void addBlocks()
		{
		   int x;
		   int y;
		   int count = 0;
			for(int i = 0; i < blocks.length; i++)
			{
				for(int a = 0; a < 4; a++)
				{
					
					x =(610 +(i*50) + 15);
					y = ((count*95) +30);
					blocks[i][a] = new Block(x, y, 15, 75, Color.RED);

					count++;
				}
				count = 0;
			}
		}
    boolean didCollideLeft(Object obj)
    {
    	Block o = (Block) obj;
    	if(((o.getX()+o.getWidth())>=leftPaddle.getX()&&(o.getX()+o.getWidth())<=(leftPaddle.getX()+leftPaddle.getWidth())) && ((o.getY() + o.getHeight())>leftPaddle.getY() && (o.getY()+o.getHeight())<(leftPaddle.getY()+leftPaddle.getHeight())) || ((o.getX()>=leftPaddle.getX()&&o.getX()<=(leftPaddle.getX()+leftPaddle.getWidth())) && (o.getY()>leftPaddle.getY()&&o.getY()<(leftPaddle.getY()+leftPaddle.getHeight()))))
    	{
    		return true;
    	}
		return false;
    	
	}
	boolean didCollideRight(Object obj)
	{
		Block o = (Block) obj;
    	if((o.getX() >= 750) || ((o.getX() + o.getWidth()) >= 750))
    		return true;
		return false;
	}
	boolean didCollideTop(Object obj)
	{
		Block o = (Block) obj;
    	if((o.getY() <= 0))
    		return true;
		return false;
	}
	public boolean didCollideBottom(Object obj)
	{
		Block o = (Block) obj;
    	if((o.getY() >= 500))
    		return true;
		return false;
		
	}
	public boolean didCollideBrick(Object obj)
	{
		Block o = (Block) obj;
		Block t;
		int x;
		int y;
		for(int i = 0; i <5; i++)
		{
			for(int a = 0; a < 4; a++)
			{
				x = Integer.parseInt(coords[i][a].substring(0, 3));
				y =Integer.parseInt(coords[i][a].substring(4));
				if(  (( (o.getX() <= (x+15)) && (o.getY() <= (y+75)) && ((o.getX() + o.getWidth()) >= x) && ((o.getY() + o.getHeight()) >= y)  ) || ( (o.getX() <= (x)) && (o.getY() <= (y)) && ((o.getX() + o.getWidth()) >= (x+15)) && ((o.getY() + o.getHeight()) >= (y + 75))  ) ) && blocks[i][a] != null)
				{
					isHit[i][a] = true;
					return true;
				}
			}
		}
		return false;
    	
	}
	
	
}