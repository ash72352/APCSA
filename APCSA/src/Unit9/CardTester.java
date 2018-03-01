package Unit9;

/**
 * This is a class that tests the Card class.
 */
public class CardTester 
{

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card t = new Card("Jack", "Diamonds", 11);
		Card s = new Card("Queen", "Diamonds", 12);
		System.out.println(t.rank());
		System.out.println(t.suit());
		System.out.println(t.pointValue());
		System.out.println(t.matches(s));
		System.out.println(t.toString());
	}
}