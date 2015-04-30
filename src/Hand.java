//Matthew Partridge...CS110 final

import java.util.*;
public class Hand extends Deck {
	
	private ArrayList<Card> cards;
	
	public Hand(ArrayList<Card> c)
	{
		cards=c;
	}
	public int handSize()
	{
		return cards.size();
	}
	public void addCards(ArrayList<Card> c)
	{
		for(int i=c.size()-1;i>=0;i--)
		{
			cards.add(c.get(i));
		}
	}
	public ArrayList<Card> getCards()
	{
		return cards;
	}
	public Card deal()
	{
		Card c=cards.get(0);
		cards.remove(0);
		return c;
	}
	public void shuffle()
	{
		Collections.shuffle(cards);
	}
	
}
