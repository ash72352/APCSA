package Unit13;


//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class QuickSort
{
	private static int passCount;

	public static void quickSort(Comparable[] list)
	{
		int low = 0;
		int high = list.length-1;
		passCount = 0;
		out.println("Pass " + passCount + ":\n" + Arrays.toString(list));
		int split = 0;
		if(low < high)
		{
			
			split = partition(list, low, high);
			quickSort(list, low, split);
			quickSort(list, split+1, high);

		}
			
		

	}

	/*
	method quicksort(array,low,high)
as long as low is less than high
split = partition(array, low, high)
quicksort(array, low, split)
quicksort(array, split+1, high)
	*/
	private static void quickSort(Comparable[] list, int low, int high)
	{
		int split = 0;
		low = low;
		high = high;
		
		if(low < high)
		{
			
			split = partition(list, low, high);
			quickSort(list, low, split);
			passCount++;
			out.println("Pass " + passCount + ":\n" + Arrays.toString(list));
			
			quickSort(list, split+1, high);
		}
		

		






	}

/*  while bot is less than top
	loop as long as bot + 1 is less than pivot
	loop as long as top – 1 is more than pivot
	check to see if bot and top have crossed
	return top
	swap bot spot and top spot
 */
	private static int partition(Comparable[] list, int low, int high)
	{
		Comparable pivot = list[low];
		int bot = low - 1;
		int top = high + 1;

		while(bot<top)
		{
			while(list[--top].compareTo(pivot) > 0);
			while(list[++bot].compareTo(pivot) < 0);
			if(bot >= top)
			{
				return top;
			}
			Comparable temp = list[bot];
			list[bot] = list[top];
			list[top] = temp;
			
		}
		return (Integer) null;
	}
}