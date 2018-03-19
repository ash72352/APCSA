package Unit12;



//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Monster implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	//write a default Constructor
	public Monster()
	{
		
	}


	//write an initialization constructor with an int parameter ht
	public Monster(int ht)
	{
		setHeight(ht);
	}


	//write an initialization constructor with int parameters ht and wt
	public Monster(int ht, int wt)
	{
		setHeight(ht);
		setWeight(wt);
	}
	
	
	//write an initialization constructor with int parameters ht, wt, and age
	
	public Monster(int ht, int wt, int age)
	{
		setHeight(ht);
		setWeight(wt);
		setAge(age);
	}

	//modifiers - write set methods for height, weight, and age
	
	public void setHeight(int h)
	{
		myHeight = h;
	}
	
	public void setWeight(int w)
	{
		myWeight = w;
	}
	
	public void setAge(int a)
	{
		myAge = a;
	}
	
	
	
	//accessors - write get methods for height, weight, and age
	public int getHeight()
	{
		return myHeight;
	}
	
	public int getWeight()
	{
		return myWeight;
	}
	
	public int getAge()
	{
		return myAge;
	}
	
	
	//creates a new copy of this Object
	public Object clone()
	{
		Monster clone = this;
	   return clone;
	}

	public boolean equals( Object obj )
	{
		
		Monster o = (Monster) obj;
		if(this == o)
		{
			return true;
		}
		else
			return false;

	}

	public int compareTo( Object obj )
	{
		Monster rhs = (Monster)obj;
		
		if(this.equals(rhs))
		{
			return 0;
		}
		else if(this.getHeight() > rhs.getHeight())
		{
			return 1;
		}
		else if(this.getWeight() > rhs.getWeight())
		{
			return 1;
		}
		else if(this.getAge() > rhs.getAge())
		{
			return 1;
		}
		else
			return -1;


	}

	//write a toString() method
	
	public String toString()
	{
		return "" + getHeight() + " " + getWeight() + " " + getAge();
	}
}