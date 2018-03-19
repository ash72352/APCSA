package LabAssessmentOne;

import java.util.ArrayList;

public class plate 
{
	
	private String pName;
	private ArrayList<dish> dishList;
	
	public plate()
	{
		pName = "";
		dishList = new ArrayList<dish>();
	}
	public plate(String n)
	{
		pName = n;
		dishList = new ArrayList<dish>();
		
	}
	public plate(String n, ArrayList<dish> d)
	{
		pName = n;
		dishList = d;
	}
	public String getName()
	{
		return pName;
	}
	public ArrayList<dish> getDishes()
	{
		return dishList;
	}
	public void addDish(dish d)
	{
		dishList.add(d);
	}
	public dish getDish(int index)
	{
		return dishList.get(index);
	}
	public String toString()
	{
		String output = "Dishes on " + pName + "'s plate:\n";
		
		for(int i = 0; i < dishList.size(); i++)
		{
			output = output + "-\t" + dishList.get(i) + "\n";
		}
		return output;
	}
	
	
}
