package Unit4;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Name
{
	private String name;
	private int space;

	public Name()
	{


	}

	public Name(String s)
	{
		name = s;

	}

 public void setName(String s)
 {
	 name = s;

 }

	public String getFirst()
	{
		space = name.lastIndexOf(" ");
		String firstName = name.substring(0, space);
		return firstName;
	}

	public String getLast()
	{
		String lastName = name.substring(space + 1);
		return lastName;
	}

	public String toString()
	{
		String fullName = getFirst() + " " + getLast();
		return fullName;
	}
}