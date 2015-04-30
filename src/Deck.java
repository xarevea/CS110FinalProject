//Matthew Partridge...CS110 final

import java.util.*;
public class Deck {
	private ArrayList<Card> cards=new ArrayList<Card>();
	
	public Deck()
	{
		for(int i=1;i<5;i++)
		{
			for(int j=2;j<15;j++)
			{
				Card current=new Card(i,j);
				cards.add(current);
			}
		}
	}
	public void shuffle()
	{
		Collections.shuffle(cards);
	}
	public ArrayList<Card> split()
	{
		int half=cards.size()/2;
		ArrayList<Card> c=new ArrayList<Card>();
		for(int i=0;i<half;i++)
		{
			c.add(this.deal());
		}
		return c;
	}
	public ArrayList<Card> getDeck()
	{
		return cards;
	}
	public Card deal()
	{
		Card c=cards.get(0);
		cards.remove(0);
		return c;
	}
}
