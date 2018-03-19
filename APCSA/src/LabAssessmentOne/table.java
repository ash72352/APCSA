package LabAssessmentOne;

import java.util.ArrayList;

public class table 
{
	
	private int tNum;
	private ArrayList<plate> plateList;
	private ArrayList<String> chairs;
	private int emptySpots = 4;
	private boolean reserved = false;
	
	public table()
	{
		tNum = 0;
		plateList = new ArrayList<plate>();
		chairs = new ArrayList<String>();
		for(int i = 0; i < emptySpots; i++)
		{
			plateList.add(null);
		}
		
		for(int i = 0; i < emptySpots; i++)
		{
			chairs.add("Empty");
		}
	}
	public table(int n)
	{
		tNum = n;
		plateList = new ArrayList<plate>();
		chairs = new ArrayList<String>();
		for(int i = 0; i < emptySpots; i++)
		{
			chairs.add("Empty");
		}
		for(int i = 0; i < emptySpots; i++)
		{
			plateList.add(null);
		}
		
	}
	public table(int n, ArrayList<plate> p)
	{
		tNum = n;
		plateList = p;
		chairs = new ArrayList<String>();
		for(int i = 0; i < plateList.size(); i++)
		{
			chairs.add(plateList.get(i).getName());
		}
	}
	public int getTableNum()
	{
		return tNum;
	}
	public ArrayList<plate> getPlates()
	{
		return plateList;
	}
	public void addPlate(plate p)
	{
		plateList.add(p);
	}
	public plate getplate(int index)
	{
		return plateList.get(index);
	}
	public void serve(plate p)
	{
		String place = p.getName();
		int spot = -1;
		for(int i = 0; i < chairs.size(); i++)
		{
			if(chairs.get(i).equalsIgnoreCase(place))
			{
				spot = i;
			}
		}
		if(spot == -1)
		{
			System.out.println("That plate doesnt belong to this table!");
		}
		else
		{
			plateList.set(spot, p);
		}
	}
	public void clear(int place)
	{
		plateList.set(place, null);
	}
	public boolean isFull()
	{
		if(emptySpots == 0)
			return true;
		else
			return false;
	}
	public void reserve()
	{
		reserved = true;
	}
	public boolean isReserved()
	{
		if(reserved)
		{
			return true;
		}
		else
			return false;
	}
	public String toString()
	{
		String output = "Plates on Table " + tNum + ":\n";
		
		for(int i = 0; i < plateList.size(); i++)
		{
			output = output + "-\t" + chairs.get(i) + "'s plate\n";
		}
		return output;
	}
	
	
	
}
