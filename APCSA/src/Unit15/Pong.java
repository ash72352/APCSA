package Unit15;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;
	


	public Pong()
	{
		//set up all variables related to the game
		
		ball = new Ball();
		//ball = new BlinkyBall();
		//ball = new SpeedUpBall();
		
		leftPaddle = new Paddle(30, 210, 30, 150, Color.RED);
		
		rightPaddle = new Paddle(710, 210, 30, 150, Color.BLUE);
		
		keys = new boolean[4];
		
		leftScore = 0;
		rightScore = 0;
		
		
		
		
		
		
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
		
		graphToBack.drawString("Score: " + leftScore + "\t    PONG   \tScore: " + rightScore, 320, 400);

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);


		//see if ball hits left wall or right wall
		if(!(ball.getX()>=20 && ball.getX()<=740))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			if((ball.getX() <= 20))
			{
				rightScore++;
				graphToBack.drawString("Score: " + leftScore + "\t    PONG   \tScore: " + rightScore, 250, 400);
				reset();
				
			}
			if((ball.getX() >= 740))
			{
				leftScore++;
				graphToBack.drawString("Score: " + leftScore + "\t    PONG   \tScore: " + rightScore, 250, 400);
				reset();
				
				
			}
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
		
		
		
		//see if the ball hits the right paddle
		if(didCollideRight(ball))
		{
			
			ball.setXSpeed((int)(-ball.getXSpeed()*(r.nextDouble()+1)));
		}
		double num = r.nextDouble();
		if(num<0.5)
			num = 0.5;
		if(ball.getXSpeed() > leftPaddle.getSpeed())
			ball.setXSpeed((int)(ball.getXSpeed()*(num)));
		if(ball.getYSpeed() > leftPaddle.getSpeed())
			ball.setYSpeed((int)(ball.getYSpeed()*num));
			
		


		//see if the paddles need to be moved
		
		
		if(keys[0] == true && leftPaddle.getY()>=0)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(window);
		}
		if(keys[1] == true  && leftPaddle.getY()<=370)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(window);

		}
		if(keys[2] == true  && rightPaddle.getY()>=0)
		{
			rightPaddle.moveUpAndDraw(window);
		}
		if(keys[3] == true  && rightPaddle.getY()<=370)
		{
			rightPaddle.moveDownAndDraw(window);
		}
		
		if(leftPaddle.getY()<=0)
		{
			
			leftPaddle.setY(leftPaddle.getY()+1);
		}
		if(leftPaddle.getY()>=370)
		{
			
			leftPaddle.setY(leftPaddle.getY()-1);

		}
		if(rightPaddle.getY()<=0)
		{
			rightPaddle.setY(rightPaddle.getY()+1);
		}
		if(rightPaddle.getY()>=370)
		{
			rightPaddle.setY(rightPaddle.getY()-1);
		}
		
		
		if(didCollideTop(ball) || didCollideBottom(ball) || didCollideLeft(ball) || didCollideRight(ball))
		{
			ball.speedUp(true);
		}







		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	private void reset() 
	{
		ball = new Ball();
		//ball = new BlinkyBall();
		//ball = new SpeedUpBall();
		leftPaddle = new Paddle(30, 210, 30, 150, Color.RED);
		
		rightPaddle = new Paddle(710, 210, 30, 150, Color.BLUE);
		
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
   
   
    boolean didCollideLeft(Object obj)
    {
    	Block o = (Block) obj;
    	if(((o.getX()+o.getWidth())>=leftPaddle.getX()&&(o.getX()+o.getWidth())<=(leftPaddle.getX()+leftPaddle.getWidth())) && ((o.getY() + o.getHeight())>leftPaddle.getY() && (o.getY()+o.getHeight())<(leftPaddle.getY()+leftPaddle.getHeight())) || ((o.getX()>=leftPaddle.getX()&&o.getX()<=(leftPaddle.getX()+leftPaddle.getWidth())) && (o.getY()>leftPaddle.getY()&&o.getY()<(leftPaddle.getY()+leftPaddle.getHeight()))))
    	{
    		return true;
    	}
    	if(o.getX() < leftPaddle.getX() && (o.getY() >= leftPaddle.getY() && o.getY() <= (leftPaddle.getHeight() + leftPaddle.getY())))
    		return true;
		return false;
	}
	boolean didCollideRight(Object obj)
	{
		Block o = (Block) obj;
    	if(((o.getX()+o.getWidth())>=rightPaddle.getX()&&(o.getX()+o.getWidth())<=(rightPaddle.getX()+rightPaddle.getWidth())) && ((o.getY() + o.getHeight())>rightPaddle.getY() && (o.getY()+o.getHeight())<(rightPaddle.getY()+rightPaddle.getHeight())) || ((o.getX()>=rightPaddle.getX()&&o.getX()<=(rightPaddle.getX()+rightPaddle.getWidth())) && (o.getY()>rightPaddle.getY()&&o.getY()<(rightPaddle.getY()+rightPaddle.getHeight()))))
    	{
    		return true;
    	}
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
}