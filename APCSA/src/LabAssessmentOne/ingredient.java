package LabAssessmentOne;

public class ingredient 
{
	
	private String ingName;
	private String type;
	
	public ingredient()
	{
		
	}
	public ingredient(String i)
	{
		ingName = i;
	}
	public ingredient(String i, String t)
	{
		ingName = i;
		type = t;
	}
	public String getName()
	{
		return ingName;
	}
	public String getType()
	{
		return type;
	}
	
	
	

}
