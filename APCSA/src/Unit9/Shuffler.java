package Unit9;

import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			values1 = perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			values2 = selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] perfectShuffle(int[] values) 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		int[] tempFirst = new int[values.length];
		int[] tempSecond = new int[values.length];
		int half = 0;
		if(values.length%2 == 0)
		{
			half = values.length/2;
		}
		else if(values.length%2 == 1)
		{
			half = values.length/2 + 1;
		}
		for(int i = 0; i < half; i++)
		{
			
			
			tempFirst[i] = values[i];
			tempSecond[i] = values[i + half];
		}
		int a = 0;
		int b = 0;
		for(int i = 0; i < values.length; i++)
		{
			if(i%2 == 0)
			{
				values[i] = tempFirst[a];
				a++;
			}
			else if(i%2 == 1)
			{
				values[i] = tempSecond[b];
				b++;
			}

		}
		return values;
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static int[] selectionShuffle(int[] values) 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
		
		Random r = new Random();
		int size = values.length;
		int remaining = size;
		int[] temp = new int[size];
		for(int c = 0; c < remaining; c++)
		{
			temp[c] = values[c];
		}
		int[] placeHolder = new int[size];
		for(int c = 0; c < size; c++)
		{
			placeHolder[c] = 0;
		}
		int a = 0;
		for(int i = 0; i < remaining; i++)
		{
			a = r.nextInt(remaining);
			while(placeHolder[a] == 1 || placeHolder[a] == -1)
			{
				a = r.nextInt(remaining);
			}
			placeHolder[a] = 1;
			for(int b = 0; b < remaining; b++)
			{
				if(placeHolder[b] == 1)
				{
					temp[b] = values[i];
					placeHolder[b] = -1;
				}
			}
		}
		for(int i = 0; i < remaining; i++)
		{
			values[i] = temp[i];
		}
		return values;
	}
}