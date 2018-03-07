package Unit10;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck 
{

	/**
	 * cards contains all the cards in the deck.
	 */
	private List<Card> cards;
	
	//Unit 9 - Array version of the Deck
	//private Card[] cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;
	private int remaining;

	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		size = 0;
		int rankSize = 0;
		int suitSize = 0;
		for(@SuppressWarnings("unused") String item : suits)
		{
			suitSize++;
		}
		for(@SuppressWarnings("unused") String r : ranks)
		{
			rankSize++;
			for(@SuppressWarnings("unused") String s : suits)
			{
				size++;
			}
		}
		cards = new ArrayList<Card>();


		for(int i = 0; i < suitSize; i++)
		{
			for(int b = 0; b < rankSize; b++)
			{
				cards.add(new Card(ranks[b], suits[i], values[b]));
			}
		}
		
		remaining = size;
		this.shuffle();
		
	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		boolean yn = false;
		if(remaining <= 0)
			yn = true;
		return yn;
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
		Random r = new Random();
		List<Card> temp = cards;
		
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
					temp.set(b, cards.get(i));
					placeHolder[b] = -1;
				}
			}
		}

		cards = temp;
		
		
			

	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		if(isEmpty() != true)
		{
			remaining--;
			return cards.get(remaining);
		}
		else
			return null;
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() 
	{
		String rtn = "size = " + remaining + "\nUndealt cards: \n";


		//Unit 9 - modify to work with Arrays
		
		for (int k = remaining - 1; k >= 0; k--) 
		{
			rtn = rtn + cards.get(k);
			if (k != 0) 
			{
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) 
			{
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		
		for (int k = remaining; k < size; k++) 
		{
			rtn = rtn + cards.get(k);
			if (k != remaining) 
			{
				rtn = rtn + ", ";
			}
			if ((k - size) % 2 == 0) 
			{
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}
		

		rtn = rtn + "\n";
		return rtn;
	}
}