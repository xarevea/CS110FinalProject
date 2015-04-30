//Matthew Partridge...CS110 final

/**
 * Represents a card from a standard playing deck of 52 cards
 */
public class Card {
	//Declare constants
	public final int SPADES=1;
	public final int CLUBS=2;
	public final int HEARTS=3;
	public final int DIAMONDS=4;
	public final int ACE=14;
	public final int JACK=11;
	public final int QUEEN=12;
	public final int KING=13;
	//Declare variables
	private int rank;
	private int suit;
	/**
	 * the default constructor which allows the user to specify the card suit and rank
	 * @param s
	 * 			the suit of the card expressed as an integer, 1=spades, 2=clubs, 3=hearts, and 4=diamonds
	 * @param r
	 * 			the number value(rank) of the card
	 */
	public Card(int s, int r)
	{
		suit=s;
		rank=r;
	}
	/**
	 * the getSuit method returns the suit of the card as an int
	 */
	public String getSuit()
	{
		if(this.suit==1)
		{
			return"s";
		}
		else if(this.suit==2)
		{
			return"c";
		}
		else if(this.suit==3)
		{
			return"h";
		}
		else
		{
			return"d"; 
		}
	}
	/**
	 * the getRank method returns the rank of the card
	 */
	public int getRank()
	{
		return rank;
	}
	/**
	 * the equals method returns true if the ranks of the two cards are equal
	 * @param c
	 * 			the card that is being compared to the original card
	 */
	public boolean equals(Card c)
	{
		if(this.getRank()==c.getRank())
		{
			return true;
		}
		return false;
	}
	/**
	 * returns the suit and rank of the card as a string
	 */
	public String toString()
	{
		String card="";
		if(this.getRank()==ACE)
		{
			card+="The Ace of "; 
		}
		else if(this.getRank()==JACK)
		{
			card+="The Jack of "; 
		}
		else if(this.getRank()==QUEEN)
		{
			card+="The Queen of "; 
		}
		else if(this.getRank()==KING)
		{
			card+="The King of "; 
		}
		else
		{
			card+="The "+this.getRank()+" of ";
		}
		if(this.getSuit().equals("s"))
		{
			card+="Spades ";
		}
		else if(this.getSuit().equals("c"))
		{
			card+="Clubs ";
		}
		else if(this.getSuit().equals("h"))
		{
			card+="Hearts ";
		}
		else if(this.getSuit().equals("d"))
		{
			card+="Diamonds ";
		}
		
		return card;
	}
	public boolean isBiggerThan(Card c)
	{
		boolean bigger=true;
		if(c.getRank()>=this.getRank())
		{
			bigger=false;
		}
		return bigger;
	}
	public String getFilename()
	{
		String filename="cards/"+this.getSuit()+this.getRank()+".png";
		return filename;
	}
}
