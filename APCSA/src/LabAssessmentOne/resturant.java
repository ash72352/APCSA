package LabAssessmentOne;

import java.util.ArrayList;

public class resturant 
{
	
	private String name;
	private ArrayList<table> tables;
	private int size = 0;
	
	public resturant()
	{
		name = "";
		tables = new ArrayList<table>();
		
	}
	public resturant(String n)
	{
		name = n;
		tables = new ArrayList<table>();
		
	}
	public resturant(String n, ArrayList<table> t)
	{
		name = n;
		tables = t;
		size = tables.size();
	}
	public resturant(String n, int numberOfTables)
	{
		name = n;
		tables = new ArrayList<table>();
		table temp;
		for(int i = 0; i < numberOfTables; i++)
		{
			temp = new table(i);
			tables.add(temp);
		}
		size = tables.size();
	}
	public String getName()
	{
		return name;
	}
	public ArrayList<table> getTableList()
	{
		return tables;
	}
	public table getTable(int index)
	{
		return tables.get(index);
	}
	public table getEmptyTable()
	{
		
		for(int i = 0; i < size; i++)
		{
			if(!tables.get(i).isReserved() && !tables.get(i).isFull())
			{
				return tables.get(i);
			}
		}
		return null;
	}
	public String seat()
	{
		table t = getEmptyTable();
		if(t == null)
		{
			return "Sorry! We are full!";
		}
		else
		{
			return "Your table is: Table #" + t.getTableNum();
		}
	}
	public void clearTable(int t)
	{
		tables.set(t, new table(t));
	}
	public String toString()
	{
		String output = "Tables at the " + name + " resturant:\n";
		
		for(int i = 0; i < tables.size(); i++)
		{
			output = output + "\t" + tables.get(i).getTableNum() + "\n";
		}
		return output;
	}
	
	
}
