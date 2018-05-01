package Unit17;

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

public class Aliens
{
	private ArrayList<Alien> ships;

	public Aliens()
	{
		ships = new ArrayList<Alien>(3);
		for(int i = 0; i<ships.size(); i++)
		{
			ships.add(new Alien((80*i)+1, 0,1));
		}
	}
	public Aliens(int size)
	{
		ships = new ArrayList<Alien>();
		for(int i = 0; i<size; i++)
		{
			ships.add(new Alien((80*i)+1, 0, 1));
		}
	}
	public Aliens(ArrayList<Alien> a) 
	{
		ships = a;
	}
	
	public ArrayList<Alien> getList()
	{
		return ships;
	}
	public void remove(int i)
	{
		ships.remove(i);
	}
	public void set(int i, Alien a)
	{
		ships.set(i, a);
	}
	public Alien get(int i)
	{
		return ships.get(i);
	}
	
	

}
