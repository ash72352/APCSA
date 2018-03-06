package Unit10;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester
{

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] rank = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suit = {"Diamonds", "Hearts", "Spades", "Clubs"};
		int[] pointValues = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		
		Deck d = new Deck(rank, suit, pointValues);

		System.out.println("In deck D after one deal:\n");
		d.deal();
		System.out.println(d.toString());
		

		
		Deck c = new Deck(rank, suit, pointValues);
		System.out.println("Is deck C empty? " + c.isEmpty() + "\n");
		
		Deck b = new Deck(rank, suit, pointValues);
		System.out.println("Size of deck B? " + b.size());


	}
}