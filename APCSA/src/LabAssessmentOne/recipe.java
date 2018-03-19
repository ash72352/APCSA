package LabAssessmentOne;

import java.util.ArrayList;

public class recipe 
{
	
	private String rName;
	private ArrayList<ingredient> ingList;
	
	public recipe()
	{
		rName = "";
		ingList = new ArrayList<ingredient>();
	}
	public recipe(String n)
	{
		rName = n;
		ingList = new ArrayList<ingredient>();
	}
	public recipe(String n, ArrayList<ingredient> r)
	{
		rName = n;
		ingList = r;
	}
	public String getName()
	{
		return rName;
	}
	public ArrayList<ingredient> getIngredients()
	{
		return ingList;
	}
	public void addIng(ingredient i)
	{
		ingList.add(i);
	}
	public ingredient getIng(int index)
	{
		return ingList.get(index);
	}
	public String toString()
	{
		String output = "Ingredients in " + rName + " Recipe:\n";
		
		for(int i = 0; i < ingList.size(); i++)
		{
			output = output + "-\t" + ingList.get(i) + "\n";
		}
		return output;
	}
	
	
	
}
