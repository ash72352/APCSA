package LabAssessmentOne;

import java.util.ArrayList;

public class dish 
{
	
	private String dName;
	private ArrayList<ingredient> ingList;
	private recipe rec = null;
	
	public dish()
	{
		dName = "";
		rec = new recipe();
		ingList = rec.getIngredients();
	}
	public dish(String n)
	{
		dName = n;
		rec = new recipe();
		ingList = rec.getIngredients();
		
	}
	public dish(String n, ArrayList<ingredient> r)
	{
		dName = n;
		rec = new recipe(n, r);
		ingList = rec.getIngredients();
	}
	public dish(recipe r)
	{
		rec = r;
		dName = r.getName();
		ingList = r.getIngredients();
		
	}
	public String getName()
	{
		return dName;
	}
	public ArrayList<ingredient> getIngredients()
	{
		return ingList;
	}
	public recipe getRec()
	{
		return rec;
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
		String output = "Ingredients in " + dName + ":\n";
		
		for(int i = 0; i < ingList.size(); i++)
		{
			output = output + "-\t" + ingList.get(i) + "\n";
		}
		return output;
	}
	
	
	
	
	
}
