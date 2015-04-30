//Matthew Partridge...CS110 final

import java.util.ArrayList;

public class GameOfWar {
	private Hand playerOne,playerTwo;
	private Card playerOneCurr, playerTwoCurr;
	private ArrayList<Card> won=new ArrayList<Card>();
	private int shuffleOne,shuffleTwo;
	public boolean war;
	
	public GameOfWar()
	{
		Deck d=new Deck();
		d.shuffle();
		playerOne=new Hand(d.split());
		playerTwo=new Hand(d.getDeck());
		shuffleOne=playerOne.handSize();
		shuffleTwo=playerTwo.handSize();
		war=false;
	}
	public void nextTurn()
	{
		if(shuffleOne==0)
		{
			playerOne.shuffle();
			shuffleOne=playerOne.handSize();
		}
		if(shuffleTwo==0)
		{
			playerTwo.shuffle();
			shuffleTwo=playerTwo.handSize();
		}
		shuffleOne--;
		shuffleTwo--;
		playerOneCurr=playerOne.deal();
		playerTwoCurr=playerTwo.deal();
		won.add(playerOneCurr);
		won.add(playerTwoCurr);
			if(playerOneCurr.isBiggerThan(playerTwoCurr))
			{
				playerOne.addCards(won);
				won=new ArrayList<Card>();
				war=false;
			}
			else if(playerTwoCurr.isBiggerThan(playerOneCurr))
			{
				playerTwo.addCards(won);
				won=new ArrayList<Card>();
				war=false;
			}
			else if(playerTwoCurr.equals(playerOneCurr))
			{
				war=true;
				won.add(playerOne.deal());
				won.add(playerTwo.deal());
			}
	}
	public String getFilenameOne()
	{
		return playerOneCurr.getFilename();
	}
	public String getFilenameTwo()
	{
		return playerTwoCurr.getFilename();
	}
	public int getCardsOne()
	{
		return playerOne.handSize();
	}
	public int getCardsTwo()
	{
		return playerTwo.handSize();
	}
	public boolean isWar()
	{
		return war;
	}
}
