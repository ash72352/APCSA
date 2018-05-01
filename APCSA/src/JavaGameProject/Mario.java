package JavaGameProject;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mario extends Actor
{  
    //Basic Physics Variables  
    private double positionX;  
    private double positionY;  
    private double velocityX = 0;  
    private double velocityY = 0;  
    private double accelerationX = 0;  
    private double accelerationY = 0;  

    //Force Values  
    private double gravityY = 0.1;  
    private double jumpForce = 3.5;  

    private GreenfootImage normalMario;
    private boolean isAlive = true;

    /** Rocket image with thrust */
    private GreenfootImage walkingMarioRight;
    private GreenfootImage walkingMarioLeft;

    public void addedToWorld(World w){  
        //We set our position to the position which we were added to the world at.  
        positionX = getX();  
        positionY = getY();  
        normalMario = this.getImage();
        walkingMarioRight = new GreenfootImage("marioWalkingRight.png");
        walkingMarioRight.scale(52, 52);
        walkingMarioLeft = new GreenfootImage("marioWalkingLeft.png");
        walkingMarioLeft.scale(52, 52);
    }  

    /** 
     * Act - do whatever the Person wants to do. This method is called whenever 
     * the 'Act' or 'Run' button gets pressed in the environment. 
     */  
    public void act()   
    {  
        //Apply Forces to change acceleration to move the person  
        if(isAlive) {
            applyGravity();  
            applyJumpForce();  
            //Basic Physics  
            velocityX += accelerationX;  
            velocityY += accelerationY;  
            positionX += velocityX;  
            positionY += velocityY;  
            accelerationX = 0;  
            accelerationY = 0;  
            setLocation((int)positionX,(int)positionY);
            move();
            ride();
            die();
            
            //hit();
            // instance field to add   
        }
    }      

    /** 
     * Accelerates the person downwards except for when they are on a platform 
     */  
    private void applyGravity(){  
        // Check For collision with platform  
        Actor coll = getOneIntersectingObject(Platform.class);  
        if(coll == null){   
            //This is run when the person is not touching a platform  
            //This code adds gravity to our total acceleration.  
            accelerationY += gravityY;  
        } else {   
            //This is run once we hit a platform  
            //We make our person stop moving in the y direction. (up/down direction).  
            velocityY = 0;  
        }  
    }  

    /** 
     * Accelerates the person upwards if space is pressed and we are on a platform 
     */  
    public void applyJumpForce(){  
        Actor coll = getOneIntersectingObject(Platform.class);  
        if(coll != null){  
            //This is run when the person is touching a platform  
            if(Greenfoot.isKeyDown("up")){  
                accelerationY -= jumpForce;  
            }  
        }  
    }

    public void move()
    {

        if (Greenfoot.isKeyDown("left"))
        {
            positionX -= 3;
            this.setImage(walkingMarioLeft);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            positionX += 3;
            this.setImage(walkingMarioRight);
        }
        if( !(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right") || false) )
        {
            this.setImage(normalMario);
        }

    }

    public void ride()
    {

        Actor nyan;
        nyan = getOneObjectAtOffset(0, 0, NyanCat.class);
        if ( nyan != null )
        {
            World world;
            world = getWorld();
            world.removeObject(nyan);
            world.addObject(new NyanMario(), (int)positionX, (int)positionY);            
            world.removeObject(this);

        }

    }

    public void die()
    {
        int h = 1000;
        if(this.positionY > h )
        {
            isAlive = false;
            World world;
            world = getWorld();
            world.addObject(new Mario(), 500, 359);
            world.removeObject(this);           
        }
    }

    /* public void hit()
    {
    Actor goomba;
    goomba = getOneObjectAtOffset(0, 0, goomba.class);
    if (goomba != null)
    {
    positionX -= 100;
    }
     */

}